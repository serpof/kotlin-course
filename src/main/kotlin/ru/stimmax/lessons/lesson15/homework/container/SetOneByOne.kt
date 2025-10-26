package ru.stimmax.ru.stimmax.lessons.lesson15.homework.container

import kotlin.math.max

//Второй класс должен получать список строк и вставлять их в начало контейнера,
//но поочерёдно с теми данными, которые уже есть. То-есть, наш список должен
//появиться в контейнере по индексам 0, 2, 4 и так далее.
class SetOneByOne: Materials() {

    fun setOneByOne(items: List<String>) {
        val extractedMaterials = extractMaterials()
        val maxSize = max(extractedMaterials.size, items.size)
        for (i in 0..<maxSize) {
            if (i < items.size) {
                addMaterial(items[i])
            }
            if (i < extractedMaterials.size) {
                addMaterial(extractedMaterials[i])
            }
        }
    }

}