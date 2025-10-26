package ru.stimmax.ru.stimmax.lessons.lesson15.homework.container

//Третий класс при добавлении строки должен отсортировать весь список материалов в алфавитном порядке,
//включая добавляемый материал.

class Sorted: Materials() {

    fun sort(item: String) {
        addMaterial(item)
        val extractedMaterials = extractMaterials()
        extractedMaterials.sorted()
            .forEach { addMaterial(it)}

    }
}