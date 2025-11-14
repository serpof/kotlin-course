package ru.stimmax.ru.stimmax.lessons.lesson19.homework

//1. Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент,
//если он существует, иначе возвращать null. Например, у списка из четырёх элементов - среднего элемента нет.

fun <T> getMiddleElement(item: List<T>): T? {
    return if (item.size % 2 == 0) {
        null
    } else {
        item[item.size / 2]
    }
}

//5. Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками и возвращает словарь,
//в котором ключ и значения поменялись местами.

fun <K, V> transposition(item: Map<K, V>): Map<V, K> {
    val revers = mutableMapOf<V, K>()
    for (pair in item) {
        revers[pair.value] = pair.key
    }
    return revers
}