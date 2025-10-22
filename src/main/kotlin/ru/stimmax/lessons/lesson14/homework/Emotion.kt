package ru.stimmax.ru.stimmax.lessons.lesson14.homework

class Emotion(val type: String, var intensity: Int) {
    fun express() {
        when (this.intensity) {
            in 0..3 -> println("не очень $type")
            in 4..8 -> println(type)
            in 9..10 -> println("очень $type")
        }
    }
}