package ru.stimmax.ru.stimmax.lessons.lesson18.homework

//Создай абстрактный класс для программируемого оборудования
//(с имплементацией соответствующего интерфейса и реализацией методов)
//и наследуй его от абстрактного класса включаемого оборудования.

abstract class ProgrammableDevice : SwitchableDevice(),  Programmable {
    override fun programAction(action: String) {
        println("It is programming action: $action")
    }

    override fun execute() {
        println("It is executing programmed action")
    }
}