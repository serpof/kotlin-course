package ru.stimmax.ru.stimmax.lessons.lesson14.homework

class Concert(val groupName: String,
              var location: String,
              val price: Double,
              var capacity: Int,
              ) {

    private var soldTickets: Int = 0

    fun info() {
        println(
            "Welcome! The band ${this.groupName} has arrived! " +
            "The performance will take place in the ${this.location}! Ticket price: ${this.price} rubles.")
    }
    fun buyTicket() {
        if (this.soldTickets <= this.capacity) {
            soldTickets++
        } else {
            println("All tickets are sold!")
        }
    }
}