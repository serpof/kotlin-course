package ru.stimmax.ru.stimmax.lessons.lesson16.homework

//Принтер
//Создай абстрактный принтер, который имеет абстрактный метод печати, принимающий в качестве аргумента строку.
//Создай классы наследники: лазерный и струйный
//Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно чёрными буквами
// на белом фоне (хорошо работает на тёмной теме)
//Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно цветными буквами
// на цветном фоне. Слова должны быть разноцветны. Можно сделать список пар с цветом текста и фона и проходить
// циклически по этому списку при выводе текста. Проверить работу на длинном тексте

abstract class Printer {
    abstract fun print(text: String)
}

class LaserPrinter : Printer() {
    override fun print(text: String) {
        val words = text.split(" ")
        for (word in words) {
            println("\u001B[30m\u001B[47m$word\u001B[0m")
        }
    }
}

class InkjetPrinter : Printer() {
    private val colorPairs = listOf(
        "\u001B[31m\u001B[43m",
        "\u001B[32m\u001B[46m",
        "\u001B[34m\u001B[47m",
        "\u001B[35m\u001B[40m",
        "\u001B[33m\u001B[44m"
    )

    override fun print(text: String) {
        val words = text.split(" ")
        for ((index, word) in words.withIndex()) {
            val color = colorPairs[index % colorPairs.size]
            println("${color}$word\u001B[0m")
        }
    }
}

fun main() {
    val text = "Kotlin is a modern statically typed programming language that makes developers happier."

    val laser = LaserPrinter()
    val inkjet = InkjetPrinter()

    println("=== Лазерный принтер ===")
    laser.print(text)

    println("\n=== Струйный принтер ===")
    inkjet.print(text)
}