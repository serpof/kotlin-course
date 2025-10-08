package ru.stimmax.ru.stimmax.lessons.lesson10.homework

fun main() {
//Задачи на работу со словарём
// 1. Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
    val emptyMap = mapOf<Int, Int>()

// 2. Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
    val floatDoubleMap = mutableMapOf(1.2f to 2.3, 3.9f to 324.9438)

// 3. Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
    val intStringMap = mutableMapOf<Int, String>()

// 4. Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
    val mutableMapEx = mutableMapOf<Int, Int>()
    mutableMapEx[1] = 2
    mutableMapEx[3] = 3
    mutableMapEx[5] = 4

// 5. Используя словарь из предыдущего задания, извлеките значение, используя ключ.
// Попробуй получить значение с ключом, которого в словаре нет.
    println(mutableMapEx[3])
    println(mutableMapEx[10])

// 6. Удалите определенный элемент из изменяемого словаря по его ключу.
    mutableMapEx.remove(5)

// 7. Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение.
// Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
    val doubleIntMap = mutableMapOf(2.3 to 5, 5.0 to 3, 1.29 to 39, 1.53 to 0)
    for ((key, value) in doubleIntMap) {
        if (value == 0) println("infinite")
        else println(key / value)
    }

// 8. Измените значение для существующего ключа в изменяемом словаре.
    doubleIntMap[1.29] = 20949

// 9. Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
    val ages1 = mapOf(
        "Alice" to 25,
        "Bob" to 30,
        "Charlie" to 28
    )

    val ages2 = mapOf(
        "David" to 22,
        "Emma" to 27,
        "Frank" to 35
    )
    val resultMap = mutableMapOf<String, Int>()
    for ((person, age) in ages1) resultMap[person] = age
    for ((person, age) in ages2) resultMap[person] = age

// 10. Создайте словарь, где ключами являются строки, а значениями - списки целых чисел.
// Добавьте несколько элементов в этот словарь.
    val stringListMap = mutableMapOf<String, List<Int>>()
    stringListMap["months"] = listOf(1, 2, 3, 4)
    stringListMap["days"] = listOf(10, 20, 30, 40)

// 11. Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк.
// Добавь данные в словарь. Получи значение по ключу (это должно быть множество строк) и добавь
// в это множество ещё строку. Распечатай полученное множество.
    val data = mutableMapOf<Int, MutableSet<String>>()
    data[1] = mutableSetOf("Apple", "Avocado")
    data[2] = mutableSetOf("Banana", "Blueberry")
    data[3] = mutableSetOf("Cherry")
    data[2]?.add("Strawberry")
    println(data[2])

// 12. Создай словарь, где ключами будут пары чисел. Через перебор найди значение у которого пара будет содержать
// цифру 5 в качестве первого или второго значения.
    val coordinates = mutableMapOf<Pair<Int, Int>, String>()
    coordinates[1 to 2] = "Point A"
    coordinates[3 to 4] = "Point B"
    coordinates[5 to 6] = "Point C"
    for ((key) in coordinates) {
        if ((key.first == 5) || (key.second == 5)) {
            println(key)
            break
        }
    }

//Задачи на подбор оптимального типа для словаря
// 1. Словарь библиотека: Ключи - автор книги, значения - список книг
    val library = mutableMapOf<String, MutableSet<String>>()

// 2. Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
    val plantsDirectory = mutableMapOf<String, MutableSet<String>>()

// 3. Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
    val quarterfinals = mutableMapOf<String, MutableSet<String>>()

// 4. Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
    val treated = mutableMapOf<String, MutableSet<String>>()

// 5. Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.
    val travelerDictionary = mutableMapOf<String, MutableMap<String, MutableSet<String>>>()
}