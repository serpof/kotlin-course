package ru.stimmax.ru.stimmax.lessons.lesson14.homework.rackAndShelves

class Shelf(val shelveCapacity: Int) {

    private val items = mutableListOf<String>()
    var currentCapacity = shelveCapacity

    fun addItem(item: String): Boolean {
        val itemLength = item.length
        if (currentCapacity - itemLength >= 0) {
            currentCapacity -= itemLength
            items.add(item)
            return true
        } else {
            return false
        }
    }

    fun removeItem(item: String): Boolean {
        if (items.contains(item)) {
            items.remove(item)
            currentCapacity += item.length
            return true
        } else {
            return false
        }
    }

    fun canAccommodate(item: String)= currentCapacity >= item.length

    fun containsItem(item: String) = items.contains(item)

    fun getItems() = items.toList()

}