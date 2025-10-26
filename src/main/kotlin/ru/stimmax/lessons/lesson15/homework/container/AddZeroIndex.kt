package ru.stimmax.ru.stimmax.lessons.lesson15.homework.container

//Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)
class AddZeroIndex(): Materials() {

    fun addZeroIndex(item: String) {
        val extractedMaterials = extractMaterials()
        addMaterial(item)
        extractedMaterials.forEach { addMaterial(it)}
    }

}