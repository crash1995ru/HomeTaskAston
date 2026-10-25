package ru.aston.homework.jsonparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Student {

    private String lastName;
    private String firstName;
    private String patronymic;
    private List<Book> bookList;

    @JsonCreator
    public Student(@JsonProperty("lastName") String lastName,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("patronymic") String patronymic,
                   @JsonProperty("bookList") List<Book> bookList) {

        validateLastName(lastName);
        validateFirstName(firstName);
        validatePatronymic(patronymic);
        validateBookList(bookList);

        this.lastName = lastName.trim();
        this.firstName = firstName.trim();
        this.patronymic = (patronymic == null) ? null : patronymic.trim();
        this.bookList = new ArrayList<>(bookList);
    }

    public Student(String lastName, String firstName, List<Book> bookList) {
        this(lastName, firstName, null, bookList);
    }

    private static void validateLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой");
        }
        if (lastName.trim().length() < 2) {
            throw new IllegalArgumentException("Фамилия слишком короткая: " + lastName);
        }
        if (lastName.trim().length() > 100) {
            throw new IllegalArgumentException("Фамилия слишком длинная");
        }
        if (!lastName.trim().matches("[А-Яа-яЁёA-Za-z\\-]+")) {
            throw new IllegalArgumentException("Фамилия содержит недопустимые символы: " + lastName);
        }
    }

    private static void validateFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (firstName.trim().length() < 2) {
            throw new IllegalArgumentException("Имя слишком короткое: " + firstName);
        }
        if (firstName.trim().length() > 100) {
            throw new IllegalArgumentException("Имя слишком длинное");
        }
        if (!firstName.trim().matches("[А-Яа-яЁёA-Za-z\\-]+")) {
            throw new IllegalArgumentException("Имя содержит недопустимые символы: " + firstName);
        }
    }

    private static void validatePatronymic(String patronymic) {

        if (patronymic == null) return;

        if (patronymic.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Отчество не может быть пустой строкой (используйте null)");
        }
        if (patronymic.trim().length() < 2) {
            throw new IllegalArgumentException("Отчество слишком короткое: " + patronymic);
        }
        if (!patronymic.trim().matches("[А-Яа-яЁёA-Za-z\\-]+")) {
            throw new IllegalArgumentException(
                    "Отчество содержит недопустимые символы: " + patronymic);
        }
    }

    private static void validateBookList(List<Book> bookList) {
        if (bookList == null) {
            throw new IllegalArgumentException(
                    "Список книг не может быть null (передайте пустой список)");
        }
        if (bookList.contains(null)) {
            throw new IllegalArgumentException("Список книг не может содержать null");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName.trim();
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        validatePatronymic(patronymic);
        this.patronymic = (patronymic == null) ? null : patronymic.trim();
    }

    public List<Book> getBookList() {
        return Collections.unmodifiableList(bookList);
    }

    public void setBookList(List<Book> bookList) {
        validateBookList(bookList);
        this.bookList = new ArrayList<>(bookList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(lastName, student.lastName)
                && Objects.equals(firstName, student.firstName)
                && Objects.equals(patronymic, student.patronymic)
                && Objects.equals(bookList, student.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymic, bookList);
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}