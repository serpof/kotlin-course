package ru.stimmax.ru.stimmax.lessons.lesson15.homework.container

class AddMap: Materials() {

    fun addMap(items: Map<String, String>) {
        val extractedMaterials = extractMaterials()
        for (i in items.keys) {
            addMaterial(i)
        }
        extractedMaterials.forEach { addMaterial(it) }
        for (i in items.values) {
            addMaterial(i)
        }
    }
}