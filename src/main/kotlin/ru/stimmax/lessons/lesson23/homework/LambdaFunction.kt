package ru.stimmax.ru.stimmax.lessons.lesson23.homework

// 1. Создай функцию, которая принимает список чисел и возвращает среднее арифметическое всех чётных чисел этого списка.
//С помощью require проверь, что список не пустой.
//   1. Создай аналогичную анонимную функцию.
//   2. Создай аналогичное лямбда выражение с указанием типа.
//   3. Создай лямбда выражение без указания типа.
//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).

fun averageOfEven(numbers: List<Int>): Double {
    require(numbers.isNotEmpty()) { "List must not be empty" }

    val evens = numbers.filter { it % 2 == 0 }
    return evens.average()
}

val averageOfEvenAnon = fun(numbers: List<Int>): Double {
    require(numbers.isNotEmpty()) { "List must not be empty" }

    val evens = numbers.filter { it % 2 == 0 }
    return evens.average()
}

val averageOfEvenLambdaTyped: (List<Int>) -> Double = { numbers ->
    require(numbers.isNotEmpty()) { "List must not be empty" }

    val evens = numbers.filter { it % 2 == 0 }
    evens.average()
}

val averageOfEvenLambda = { numbers: List<Int> ->
    require(numbers.isNotEmpty()) { "List must not be empty" }

    val evens = numbers.filter { it % 2 == 0 }
    evens.average()
}

// 2. Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа. Сделай проверку,
// что входящее число больше нуля. Подсказка: для парсинга символа в число можно использовать функцию digitToInt()
//   1. Создай аналогичную анонимную функцию.
//   2. Создай аналогичное лямбда выражение с указанием типа.
//   3. Создай лямбда выражение без указания типа.
//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.

fun sumOfDigits(number: Long): Int {
    require(number > 0) { "Number must be greater than zero" }

    return number
        .toString()
        .sumOf { it.digitToInt() }
}

val sumOfDigitsAnon = fun(number: Long): Int {
    require(number > 0) { "Number must be greater than zero" }

    return number
        .toString()
        .sumOf { it.digitToInt() }
}

val sumOfDigitsLambdaTyped: (Long) -> Int = { number ->
    require(number > 0) { "Number must be greater than zero" }

    number
        .toString()
        .sumOf { it.digitToInt() }
}

val sumOfDigitsLambda = { number: Long ->
    require(number > 0) { "Number must be greater than zero" }

    number
        .toString()
        .sumOf { it.digitToInt() }
}


// 3. Создай функцию-расширение списка чисел, которая будет возвращать множество дубликатов чисел (встречающихся в списке более одного раза).
//   1. Создай аналогичную анонимную функцию.
//   2. Создай аналогичное лямбда выражение с указанием типа.
//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.

fun List<Int>.duplicates(): Set<Int> {
    return this
        .groupBy { it }
        .filter { it.value.size > 1 }
        .keys
}

val duplicatesAnon = fun List<Int>.(): Set<Int> {
    return this
        .groupBy { it }
        .filter { it.value.size > 1 }
        .keys
}

val duplicatesLambdaTyped: (List<Int>) -> Set<Int> = { numbers ->
    numbers
        .groupBy { it }
        .filter { it.value.size > 1 }
        .keys
}


fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)

    println("Result from regular function: ${averageOfEven(list)}")
    println("Result from anonymous function: ${averageOfEvenAnon(list)}")
    println("Result from typed lambda: ${averageOfEvenLambdaTyped(list)}")
    println("Result from untyped lambda: ${averageOfEvenLambda(list)}")

    val num = 987654321L

    println("Result from regular function: ${sumOfDigits(num)}")
    println("Result from anonymous function: ${sumOfDigitsAnon(num)}")
    println("Result from typed lambda: ${sumOfDigitsLambdaTyped(num)}")
    println("Result from untyped lambda: ${sumOfDigitsLambda(num)}")

    val list1 = listOf(1, 2, 3, 2, 4, 5, 1, 1)
    println("Duplicates: ${list1.duplicates()}")
    println("Duplicates (anonymous): ${duplicatesAnon(list)}")
    println("Duplicates (typed lambda): ${duplicatesLambdaTyped(list)}")
}

