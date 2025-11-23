package ru.stimmax.ru.stimmax.lessons.lesson22.homework

//Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий
//IndexOutOfBoundsException тип в качестве аргумента. Напиши код, который спровоцирует выброс IndexOutOfBoundsException,
//перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.

class MyRuntimeIndexException(
    cause: IndexOutOfBoundsException
) : RuntimeException("Wrapped IndexOutOfBoundsException", cause)

fun main() {
    try {
        // Код, который гарантированно вызывает IndexOutOfBoundsException
        val list = listOf(1, 2, 3)
        println(list[10])

    } catch (e: IndexOutOfBoundsException) {
        println("Перехвачено исключение: ${e::class.simpleName}")

        // Бросаем свой тип исключения, оборачивая оригинальное
        throw MyRuntimeIndexException(e)
    }
}