package ru.stimmax.ru.stimmax.lessons.lesson18.homework

//Создай абстрактный класс для включаемого оборудования и имплементируют соответствующий
//интерфейс с реализацией методов (достаточно println с выполняемым действием).
abstract class SwitchableDevice : Powerable {
    protected var isOn: Boolean = false

    override fun powerOn() {
        isOn = true
        println("It is powering ON")
    }

    override fun powerOff() {
        isOn = false
        println("It is powering OFF")
    }
}