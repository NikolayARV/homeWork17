package com.example.recipeapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FirstController {
    @GetMapping
    public String appLaunched() {
        return "Приложение загружено";
    }

    @GetMapping("/info")

    public String page() {
        return """
                Имя ученика: Николай Разенков 
                Название проекта: рецепты 
                Дата создания проекта: 01.01.2023
                Описание проекта: первая сборка проекта
                """
                ;
    }
}

//Второй запрос должен обрабатывать запросы с конкретным URL-адресом http://localhost:8080/info и возвращать:
//имя ученика,
//название вашего проекта,
//дату создания проекта,
//описание проекта в свободной форме.