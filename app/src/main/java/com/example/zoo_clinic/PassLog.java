package com.example.zoo_clinic;

public class PassLog {
    // Переменные для хранения пароля и эмейла.
    private String email, password;

    public PassLog() {
        // Без него файербейс не хочет работать.
    }

    // Конструктор для переменных.
    public PassLog(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Дальше идут геттеры и сеттеры для эмейла и пароля.
    public String getEmailName() {
        return email;
    }

    public void setEmailName(String email) {
        this.email = email;
    }

    public String getPasswordName() {
        return password;
    }

    public void setPasswordName(String password) {
        this.password = password;
    }

}

