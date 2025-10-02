package ru.stimmax.ru.stimmax.lessons.lesson07.homework

fun main(){
    stars()
}

//Задания для цикла for
//Прямой диапазон.
//Напишите цикл for, который выводит числа от 1 до 5.
fun fromOneToFive() {
    for (i in 1..5) println (i)
}

//Напишите цикл for, который выводит четные числа от 1 до 10.
fun oddNumbers() {
    for (i in 1..10) if (i % 2 == 0) println (i)
}

//Обратный диапазон.
//Создайте цикл for, который выводит числа от 5 до 1.
fun fromFiveToOne() {
    for (i in 5 downTo 1) println (i)
}

//Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
fun fromTenToOne() {
    for (i in 10 downTo 1) println (i - 2)
}
//С шагом (step)
//Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
fun step() {
    for (i in 1..9 step 2) println(i)
}

//Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
fun stepThree() {
    for (i in 1..20 step 3) println(i)
}

//Использование до (until)
//Создайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
val size = 5
fun forWithUntil() {
    for (i in 3 until size step 2) println(i)
}

//Задания для цикла while
//Цикл while.
//Создайте цикл while, который выводит квадраты чисел от 1 до 5.
fun numberSquare() {
    var counter = 0
    while (counter++ < 5) {
        println(counter * counter)
    }
}

//Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
fun reduceNumber() {
    var counter = 11
    while (counter-- > 5) {
        println(counter)
    }
}
//Цикл do while
//Используйте цикл do while, чтобы вывести числа от 5 до 1.
fun doWhileOne () {
    var counter = 5
    do println(counter--)
    while (counter > 0)
}

//Создайте цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5.
fun doWhileTwo () {
    var counter = 5
    do println(counter++)
    while (counter < 10)
}
//Задания для прерывания и пропуска итерации
//Использование break.
//Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.
fun useBreak () {
    for (i in 1..10) if (i == 6) break
}

//Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10.
fun infiniteWhile() {
    var counter = 1
    while(true) {
        if (counter == 10) break
        else println(counter++)
    }
}

//Использование continue
//В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа.
fun skipOdd() {
    for (i in 1..10) {
        if (i % 2 == 0) continue
        println(i)
    }
}

//Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
fun skipSomeNumbers() {
    var counter = 0
    while(counter++ < 10) {
        if (counter % 3 == 0) continue
        println(counter)
    }
}

//Используя вложенный цикл реализовать таблицу умножения, как на картинке.
fun multiplicationTable() {
    for (i in 1..10) {
        for (j in 1..10) {
            print("${i * j} ")
        }
        println()
    }
}

//Напишите функцию, которая суммирует числа от 1 до 'arg' с помощью цикла for. 'arg' - целочисленный аргумент функции.
fun sumNumbers(arg:Int) {
    var sum = 0
    for (i in 1..arg) {
        sum += i
    }
    println(sum)
}

//Напишите функцию, которая вычисляет факториал числа 'arg' с использованием цикла while.
fun factorial(arg: Int) {
    var counter = 1
    var factorialValue = 1
    while (counter++ < arg) {
        factorialValue *= counter
    }
    println(factorialValue)
}

//Напишите функцию, которая находит сумму всех четных чисел от 2 до 'arg', используя цикл while.
fun sumOdd(arg: Int) {
    var counter = 1
    var sum = 0
    while (counter++ < arg) {
        if (counter % 2 == 0) sum += counter
    }
    println(sum)
}

//Напишите функцию, которая используя вложенные циклы while, выведет заполненный прямоугольник размером 5x3 из символов *.
fun stars() {
    var rows = 0
    var columns = 0
    while (rows++ < 3) {
        while (columns++ < 5) {
            print('*')
        }
        columns = 0
        println()
    }
}

//Напишите функцию, которая используя цикл for найдёт суммы чётных и нечётных значений чисел от 1 до arg.
fun sumOddAndEven(arg: Int) {
    var sumOdd = 0
    var sumEven = 0
    for (i in 1..arg) {
        if (i % 2 == 0) sumOdd += i
        else sumEven += i
    }
    println("Sum of odd numbers is $sumOdd, sum of even numbers is $sumEven")
}