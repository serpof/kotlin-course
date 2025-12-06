package ru.stimmax.ru.stimmax.lessons.lesson24.homework

// Создай функцию, которая:
// принимает булево значение
// принимает функцию, принимающую строку и ничего не возвращающую
// возвращает целое число
fun task1(flag: Boolean, action: (String) -> Unit): Int {
    if (flag) action("Флаг = true")
    else action("Флаг = false")
    return if (flag) 1 else 0
}

// Создай функцию расширения целого числа, которая:
// принимает функцию расширения целого числа, принимающую строку и возвращающую список строк
// возвращает список строк
fun Int.extProcess(processor: Int.(String) -> List<String>): List<String> {
    return this.processor("value = $this")
}

// Создай функцию с двумя дженериками расширяющую первый дженерик, которая:
// принимает функцию расширяющую первый дженерик, ничего не принимает и возвращает второй дженерик
// возвращает второй дженерик
fun <A, B> A.transform(proc: A.() -> B): B {
    return this.proc()
}

// Создай функцию, которая:
// принимает строку
// возвращает функцию, которая ничего не принимает и возвращает строку
fun task4(text: String): () -> String {
    return { text }
}

// Создай функцию расширяющую дженерик, которая:
// ничего не принимает
// возвращает функцию, принимающую строку и возвращающую дженерик
fun <T> T.buildProcessor(): (String) -> T {
    return { this }
}

// Скопируй набор кодов цвета и функцию окрашивания строки в переданный в неё цвет из набора.
// Напиши функцию colorizeWords которая печатает слова из длинного предложения
// разбитого по пробелу разным цветом.
// Правило подбора цвета для каждого слова нужно передавать в виде функции,
// которая принимает слово и возвращает это же слово но уже "в цвете".

object Colors {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}

fun String.colorize(color: String): String =
    "$color$this${Colors.RESET}"

// colorizeWords
// Расширяет строку → обрабатывает слова → печатает результат
fun String.colorizeWords(rule: (String) -> String) {
    this.split(" ")
        .map { rule(it) }
        .forEach { println(it) }
}

// 1) Цвет зависит от характеристик
val ruleByCharacteristics: (String) -> String = { word ->
    when {
        word.firstOrNull()?.isUpperCase() == true ->
            word.colorize(Colors.BLUE)

        word.length < 3 ->
            word.colorize(Colors.YELLOW)

        word.length > 6 ->
            word.colorize(Colors.PURPLE)

        word.length % 2 == 0 ->
            word.colorize(Colors.CYAN)

        else ->
            word.colorize(Colors.GREEN)
    }
}

// 2) Цвет выбирается по очереди из списка цветов циклически
fun ruleCycle(colors: List<String>): (String) -> String {
    var index = 0
    return { word ->
        val c = colors[index]
        index = (index + 1) % colors.size
        word.colorize(c)
    }
}

// 3) Цвет выбирается по очереди, но направление меняется функцией-счётчиком
fun rulePingPong(colors: List<String>): (String) -> String {
    var index = 0

    var counter: (Int) -> Int = { it + 1 } // старт: инкремент

    return { word ->
        val c = colors[index]

        index = counter(index)

        if (index >= colors.size) {
            index = colors.size - 1
            counter = { it - 1 }
        } else if (index < 0) {
            index = 0
            counter = { it + 1 }
        }

        word.colorize(c)
    }
}

fun main() {

    val text = """
        Функции высшего порядка позволяют передавать поведение через параметры,
        а также создавать гибкие цепочки обработки данных в Kotlin.
        В этом задании мы раскрашиваем слова цветами.
    """.trimIndent()

    println("=== Характеристики ===")
    text.colorizeWords(ruleByCharacteristics)

    println("\n=== Цикл ===")
    text.colorizeWords(
        ruleCycle(listOf(Colors.RED, Colors.GREEN, Colors.YELLOW, Colors.PURPLE))
    )

    println("\n=== Пинг-Понг ===")
    text.colorizeWords(
        rulePingPong(listOf(Colors.CYAN, Colors.RED, Colors.GREEN, Colors.BLUE))
    )
}