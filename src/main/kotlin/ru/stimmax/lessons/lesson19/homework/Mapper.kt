package ru.stimmax.ru.stimmax.lessons.lesson19.homework

//3. Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
// a. элементов одного типа в элементы другого типа
// б. списка элементов одного типа в список элементов другого типа

interface Mapper<S, X> {

    fun map(item: S): X
    fun mapList(items: List<S>): List<X>

}