package ru.stimmax.ru.stimmax.lessons.lesson14.homework

class Party(var location: String, var attendees: Int) {
    fun details() {
        println("Место проведения: ${this.location}, количество гостей: ${this.attendees}.")
    }
}