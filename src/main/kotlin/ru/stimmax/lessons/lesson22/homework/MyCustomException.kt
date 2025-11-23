package ru.stimmax.ru.stimmax.lessons.lesson22.homework

//Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст.
// Выброси это исключение в main

class MyCustomException(message: String) : AssertionError(message)

fun main() {
    throw MyCustomException("Это моё кастомное исключение!")
}