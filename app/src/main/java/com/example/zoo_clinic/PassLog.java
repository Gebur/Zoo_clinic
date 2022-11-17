package com.example.zoo_clinic;

public class PassLog {
    // Переменные для хранения пароля и эмейла.
    private String email, password, pet, pet_type;

    public PassLog(String email, String password, String pet, String pet_type) {
        // Без него файербейс не хочет работать.
    }

    // Конструктор для переменных.
    public PassLog(String email, String password) {
        this.email = email;
        this.password = password;
        this.pet = pet;
        this.pet_type = pet_type;
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

    public String getpetName() {
        return pet;
    }

    public void setpetName(String pet) {
        this.pet = pet;
    }

    public String getpet_type() {
        return pet_type;
    }

    public void setpet_type(String pet_type) {
        this.pet_type = pet_type;
    }

}

