package ru.stimmax.ru.stimmax.lessons.lesson21.homework

//Задача 1.
//
// Напишите функцию analyzeDataType, принимающую параметр типа Any. Функция должна определить тип аргумента и
// вывести соответствующее сообщение:
//
//Для строки: "Это строка: [значение]".
//Для любого числа: "Это число: [значение]".
//Для списка: "Это список, количество элементов: [количество]".
//Для словаря: "Это словарь, количество пар: [количество]".
//Для остальных типов: "Неизвестный тип данных".
//Используйте оператор is для проверки типов.

fun analyzeDataType(item: Any) {
    val itemType = when (item) {
        is String -> "It's string: $item"
        is Number -> "It's number: $item"
        is List<*> -> "It's list, item ammount: ${item.size}"
        is Map<*, *> -> "It's map, pair amount: ${item.size}"
        else -> "Unknown data type"
    }
    println(itemType)
}

//Задача 2.
//
//Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка,
// если аргумент можно безопасно привести к типу List. В случае неудачного приведения функция должна возвращать -1.
// Используйте as? для безопасного приведения типа.

fun safeCastToList(item: Any): Int {
    return (item as? List<*>)?.size ?: -1
}
//Задача 3.
//
//Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки,
// если аргумент можно привести к типу String. В случае, если аргумент равен null или не является строкой,
// функция должна возвращать 0.

fun getStringLengthOrZero(item: Any?): Int {
    return (item as? String)?.length ?: 0
}

//Задача 4.
//
//Создайте функцию-расширение класса Any toSquare. Функция гарантированно вызывается у числа
// (в виде числа или строки, например 4 или 4.2 или “4.2”) и должна вернуть квадрат этого числа. Если придёт число,
// его нужно возвести в квадрат, если придёт строка, то его нужно преобразовать в число через функцию toDouble()
// и возвести в квадрат.

fun Any.toSquare(): Double {
    val num = (this as? Number)?.toDouble()
        ?: (this as String).toDouble()
    return num * num
}

//Задача 5.
//
//Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех
// целочисленных (Int) и вещественных (Double) значений в списке. Все остальные типы должны быть проигнорированы.

fun sumIntOrDoubleValues(list: List<Any>): Double {
    return list.sumOf { (it as? Int)?.toDouble() ?: (it as? Double) ?: 0.0 }
}

//Задача 6.
//
//Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к типу List<*>.
// Если приведение успешно, функция должна напечатать все строки из списка, если элемент не является строкой,
// то вывести предупреждение об этом. Если приведение неудачно, должно быть выведено сообщение об ошибке,
// не прерывая выполнение программы.

fun tryCastToListAndPrint(item: Any) {
    val result = (item as? List<*>)?.map { (it as? String) ?: "The element is not string" }
        ?: "Couldn't cast the element"
    println(result)
}