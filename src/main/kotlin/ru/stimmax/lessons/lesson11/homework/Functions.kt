package ru.stimmax.ru.stimmax.lessons.lesson11.homework

//Задачи на сигнатуру метода.
//Напишите сигнатуру метода в которую входит модификатор доступа, название функции, список аргументов с типами
//и возвращаемое значение. В теле метода можешь сделать возврат объекта нужного типа если это требуется
//для устранения ошибок.

// 1. Не принимает аргументов и не возвращает значения.
fun noArgsNoReturns() {
}

// 2. Принимает два целых числа и возвращает их сумму.
fun sum(firstNum: Int, secondNum: Int): Int = firstNum + secondNum

// 3. Принимает строку и ничего не возвращает.
fun stringNothing(str: String) {
}

// 4. Принимает список целых чисел и возвращает среднее значение типа Double.
fun avgValue(array: List<Int>): Double {
    var sum = 0.0
    for (i in array) sum += i
    return sum / array.size
}

// 5. Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun stringLength(str:String?): Int? {
    return str?.length
}

// 6. Не принимает аргументов и возвращает nullable вещественное число.
fun getNullableNum(): Double? {
    return null
}

// 7. Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun getList(list: List<Int>?) {
    val size = list?.size
}

// 8. Принимает целое число и возвращает nullable строку.
fun getNullableString(num: Int): String? {
    return num.toString()
}

// 9. Не принимает аргументов и возвращает список nullable строк.
fun getNullableStringsList(): List<String?> {
    val list = listOf("")
    return mutableListOf()
}

// 10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun getNullableBoolean(str: String?, num: Int?): Boolean? {
    if (str == null && num == null) {
        return null
    }
    return if (str != null && num != null) {
        str.length == num
    } else {
        false
    }
}

//Задачи на написание кода.
//Напишите валидную сигнатуру метода, а так же рабочий код для задач.

// 11. Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(num: Int): Int {
    return num * 2
}

// 12. Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное,
// и false в противном случае.
fun isEven(num: Int): Boolean {
    return num % 2 == 0
}

// 13. Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n.
//Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(n: Int) {
    if (n < 1) {
        return
    }
    for (i in 1..n) {
        println(i)
    }
}

// 14. Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число
//в списке. Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(array: List<Int>): Int? {
    for(i in array) {
        if (i < 0) {
            return i
        }
    }
    return null
}

// 15. Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить
// каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью
// return без возврата значения.
fun processList(strList: List<String?>) {
    for (str in strList) {
        if (str == null) {
            return
        }
        println(str)
    }
}