package ru.stimmax.ru.stimmax.lessons.lesson19.homework

class PhrasesToListOfStrings : Mapper<String, List<String>> {

    override fun map(item: String): List<String> {
        return item.split(" ").toList()
    }

    override fun mapList(items: List<String>): List<List<String>> {
        return items.map{ map(it) }
    }

}