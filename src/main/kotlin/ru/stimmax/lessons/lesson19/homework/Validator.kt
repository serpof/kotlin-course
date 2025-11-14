package ru.stimmax.ru.stimmax.lessons.lesson19.homework

//6. Напиши интерфейс Validator с дженериком с функцией валидации,
//которая будет принимать элемент с типом дженерика и возвращать булево значение.

interface Validator<Q> {

    fun validate(element: Q): Boolean

}