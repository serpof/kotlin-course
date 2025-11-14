package ru.stimmax.ru.stimmax.lessons.lesson19.homework

//2. Напиши класс ListHolder, который будет хранить список элементов типа T и иметь метод для добавления
//нового элемента и получения всех элементов в виде неизменяемого списка.

class ListHolder<T> {

    private val items = mutableListOf<T>()

    fun addItem(item: T) {
        items.add(item)
    }

    fun getItems(): List<T> = items.toList()

}