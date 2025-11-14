package ru.stimmax.ru.stimmax.lessons.lesson19.homework

//9. Создай класс ListValidator с дженериком, ограниченным типом Number,
// имплементируй интерфейс Validator типизированный по типу List с nullable типом дженерика класса
//Реализуй проверку:
// 1. Ни один элемент списка не является null
// 2. Ни один элемент приведённый к типу Double не равен 0.0

class ListValidator<N: Number>: Validator<List<N?>> {

    override fun validate(element: List<N?>): Boolean {
        return element.all { it != null && it.toDouble() != 0.0 }
    }

}