package ru.stimmax.ru.stimmax.lessons.lesson18.homework

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}