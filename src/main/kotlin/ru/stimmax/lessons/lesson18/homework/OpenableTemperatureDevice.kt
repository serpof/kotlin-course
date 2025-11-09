package ru.stimmax.ru.stimmax.lessons.lesson18.homework

//Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться
//и с наследованием от программируемого оборудования. Также имплементируй интерфейсы.
abstract class OpenableTemperatureDevice :
    ProgrammableDevice(),
    TemperatureRegulatable,
    Openable {

    override val maxTemperature: Int
        get() = 100

    override fun setTemperature(temp: Int) {
        println("It setting temperature to $temp°C (max $maxTemperature°C)")
    }

    override fun open() {
        println("It is opening")
    }

    override fun close() {
        println("It is closing")
    }
}