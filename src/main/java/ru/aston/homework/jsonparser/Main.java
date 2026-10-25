package ru.aston.homework.jsonparser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Student> students = new ArrayList<>();
        try (InputStream is = Main.class.getResourceAsStream("/students.json")) {
            if (is == null) {
                throw new IllegalStateException("students.json not found on classpath");
            }
            students = mapper.readValue(is, new TypeReference<List<Student>>() {});
        } catch (IOException e) {
           e.getMessage();
        }

        students.stream()
                .peek(System.out::println)
                .map(Student::getBookList)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getPages)
                        .thenComparing(Book::getTitle)
                        .thenComparing(Book::getAuthor))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Такая книга отсутствует")
                );
    }
}
