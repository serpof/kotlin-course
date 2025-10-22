package ru.stimmax.ru.stimmax.lessons.lesson14.homework

object Moon {
    var isVisible: Boolean = true
    var phase: String = "New Moon"

    fun showPhase() {
        if (isVisible) {
            println(this.phase)
        } else {
            println("Moon isn't visible")
        }
    }
}