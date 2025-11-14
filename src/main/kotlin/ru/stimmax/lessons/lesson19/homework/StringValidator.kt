package ru.stimmax.ru.stimmax.lessons.lesson19.homework

//7. Создай класс StringValidator и имплементируй интерфейс Validator с типом String?.
//Реализуй проверку, что строка не является null, не пустая и не состоит из одних пробелов.
class StringValidator: Validator<String?> {

    override fun validate(element: String?): Boolean {
        return !element.isNullOrBlank()
    }

}