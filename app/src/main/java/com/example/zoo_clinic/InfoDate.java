package com.example.zoo_clinic;

public class InfoDate {
    // Переменные для хранения инфы и даты.
    private String info, date;

    public InfoDate() {
        // Без него файербейс не хочет работать.
    }

    // Конструктор для переменных.
    public InfoDate(String info, String date) {
        this.info = info;
        this.date = date;
    }

    // Дальше идут геттеры и сеттеры для эмейла и пароля.
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
