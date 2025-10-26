package ru.stimmax.ru.stimmax.lessons.lesson15.homework

//Учебные Заведения
//Базовый класс: Учебное Заведение
//Производные классы: Школа, …
//Дополнительное разветвление для …: …
abstract class EducationalInstitution(val capacity: Int) {
}

open class School(capacity: Int): EducationalInstitution(capacity) {

}

class PrivateSchool(capacity: Int): School(capacity) {

}

class PublicSchool(capacity: Int): School(capacity) {

}