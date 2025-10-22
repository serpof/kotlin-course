package ru.stimmax.ru.stimmax.lessons.lesson14.homework.rackAndShelves

class Rack(val rackCapacity: Int) {

    private val shelves = mutableListOf<Shelf>()

    fun addShelve(shelf: Shelf): Boolean {
        if (!shelves.contains(shelf) && shelves.size < rackCapacity) {
            shelves.add(shelf)
            return true
        } else {
            return false
        }
    }

    fun removeShelve(shelveNumber: Int): List<String> {
        return if (shelveNumber in shelves.indices) {
            shelves.removeAt(shelveNumber).getItems()
        } else {
            emptyList()
        }
    }

    fun addItem(item: String): Boolean {
        for (shelve in shelves) {
            if (shelve.canAccommodate(item)) {
                shelve.addItem(item)
                return true
            }
        }
        return false
    }

    fun removeItem(item: String): Boolean {
        for (shelve in shelves) {
            if (shelve.containsItem(item)) {
                return shelve.removeItem(item)
            }
        }
        return false
    }

    fun containsItem(item: String): Boolean {
        return shelves.any { it.containsItem(item) }
    }

    fun getShelves() = shelves.toList()

    fun printContents() {
        for (index in shelves.indices) {
            println("""
               Shelve index = $index
               Shelve capacity = ${shelves[index].shelveCapacity}
               Remaining capacity = ${shelves[index].currentCapacity}
               List of items = ${shelves[index].getItems().joinToString()}
               
            """.trimIndent())
        }
    }

    fun advancedRemoveShelf(indexOfShelve: Int): List<String> {
        if (indexOfShelve !in shelves.indices) {
            return emptyList()
        }
        val remainingItems = mutableListOf<String>()

        for (item in shelves[indexOfShelve].getItems().sortedByDescending { it.length }) {
            var placed = false
            for ((i, shelve) in shelves.withIndex()) {
                if (i == indexOfShelve) {
                    continue
                }
                if (shelve.canAccommodate(item)) {
                    shelve.addItem(item)
                    placed = true
                    break
                }
            }
            if (!placed) {
                remainingItems.add(item)
            }
        }
        removeShelve(indexOfShelve)
        return remainingItems.toList()
    }

}