package ru.stimmax.ru.stimmax.lessons.lesson18.homework

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}