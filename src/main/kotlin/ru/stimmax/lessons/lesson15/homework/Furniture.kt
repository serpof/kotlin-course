package ru.stimmax.ru.stimmax.lessons.lesson15.homework

//Иерархия Мебели
//Базовый класс: Мебель
//Производные классы: …
//Дополнительное разветвление для …: …
abstract class Furniture() {
}

open class KitchenFurniture(): Furniture() {
}

class Cupboard(): KitchenFurniture() {
}