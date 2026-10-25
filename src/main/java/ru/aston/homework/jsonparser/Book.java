package ru.aston.homework.jsonparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private LocalDate year;
    private int pages;

    @JsonCreator
    public Book(@JsonProperty("title") String title,
                @JsonProperty("author") String author,
                @JsonProperty("year") LocalDate year,
                @JsonProperty("pages") int pages) {

        validateTitle(title);
        validateAuthor(author);
        validateYear(year);
        validatePages(pages);

        this.title = title.trim();
        this.author = author.trim();
        this.year = year;
        this.pages = pages;
    }

    private static void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название книги не может быть пустым");
        }
    }

    private static void validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Автор не может быть пустым");
        }
    }

    private static void validateYear(LocalDate year) {
        if (year == null) {
            throw new IllegalArgumentException("Дата не может быть null");
        }
        if (year.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Дата публикации не может быть в будущем");
        }
        if (year.isBefore(LocalDate.of(1450, 1, 1))) {
            throw new IllegalArgumentException("Слишком старая дата публикации");
        }
    }

    private static void validatePages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Количество страниц должно быть больше 0");
        }
        if (pages > 10000) {
            throw new IllegalArgumentException("Слишком много страниц: " + pages);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        validateAuthor(author);
        this.author = author;
    }

    public int getYear() {
        return year.getYear();
    }

    public void setYear(LocalDate year) {
        validateYear(year);
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        validatePages(pages);
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, pages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                '}';
    }
}