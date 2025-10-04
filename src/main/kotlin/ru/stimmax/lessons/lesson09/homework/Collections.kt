package ru.stimmax.ru.stimmax.lessons.lesson09.homework

//Работа с массивами Array.
// 1. Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
fun arrayNumbers(): Array<Int> {
    val numbers = arrayOf(1, 2, 3, 4, 5)
    return numbers
}

// 2. Создайте пустой массив строк размером 10 элементов.
fun arrayStrings(): Array<String> {
    val strings = Array(10) { "" }
    return strings
}

// 3. Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
fun arrayDouble(): Array<Double> {
    val numbers = Array(5) { 0.0 }
    for (i in numbers.indices) numbers[i] = i * 2.0
    return numbers
}

// 4. Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение,
// равное его индексу, умноженному на 3.
fun arrayInt(i1: Int, i2: Int, i3: Int, i4: Int, i5: Int): Array<Int> {
    val numbers = Array(5) { 0 }
    for (i in numbers.indices) numbers[i] = i * 3
    return numbers
}

// 5. Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
fun arrayString(): Array<String?> {
    val strings = arrayOf("one string", null, "two string")
    return strings
}

// 6. Создайте массив целых чисел и скопируйте его в новый массив в цикле.
fun copyArray(): Array<Int> {
    val arrayOne = arrayOf(10, 20, 48, 3, 93, 9483)
    val arrayTwo = Array(6) { 0 }
    for (i in arrayOne.indices) {
        arrayTwo[i] = arrayOne[i]
    }
    return arrayTwo
}

// 7. Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого.
// Распечатайте полученные значения.
fun difference() {
    val arrayOne = arrayOf(321, 5423, 653, 2345, 432, 32)
    val arrayTwo = arrayOf(543, 635, 84, 2543, 78, 84)
    val arrayThree = Array(6) { 0 }
    for (i in arrayOne.indices) {
        arrayThree[i] = arrayOne[i] - arrayTwo[i]
        println(arrayThree[i])
    }
}

// 8. Создайте массив целых чисел. Найдите индекс элемента со значением 5.
// Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
fun arrayAndWhile() {
    val array = arrayOf(1, 2, 5, 4)
    var counter = 0
    var index = -1
    while (counter++ < array.size - 1) {
        if (array[counter] == 5) {
            index = counter
            break
        }
    }
    println(index)
}

// 9. Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль.
// Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
fun oddOrEven() {
    val arrayInt = arrayOf(93, 49328, 9328, 29384, 95)
    for (i in arrayInt) if (i % 2 == 0) println("$i чётное") else println("$i нечётное")
}

// 10. Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент,
// в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
fun findString(array: Array<String>, arg: String) {
    for (i in array) {
        if (i.contains(arg)) {
            println(i)
            break
        }
    }
}

//Работа со списками List.
// 1. Создайте пустой неизменяемый список целых чисел.
fun listInt(): List<Int> {
    val emptyList = emptyList<Int>()
    return emptyList
}

// 2. Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
fun threeStrings(): List<String> {
    val listOfStrings = listOf("Hello", "World", "Kotlin")
    return listOfStrings
}

// 3. Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
fun mutableListInt(): List<Int> {
    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    return mutableList
}

// 4. Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
fun addMutableListInt(): List<Int> {
    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    mutableList.add(6)
    mutableList.add(7)
    mutableList.add(8)
    return mutableList
}

// 5. Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
fun removeStrings(): List<String> {
    val listOfStrings: MutableList<String> = mutableListOf("Hello", "World", "Kotlin")
    listOfStrings.remove("World")
    return listOfStrings
}

// 6. Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
fun printListInt() {
    val printList = listOf(1, 2, 3, 4, 5)
    for (i in printList) println(i)
}

// 7. Создайте список строк и получите из него второй элемент, используя его индекс.
fun printSecondElement() {
    val sentences = listOf(
        "Kotlin is a modern programming language.",
        "It runs on the Java Virtual Machine.",
        "Android developers often use Kotlin.",
        "The syntax is clean and expressive.",
        "Null safety is one of its key features."
    )
    println(sentences[1])
}

// 8. Имея изменяемый список чисел, измените значение элемента на определенной позиции (например,
// замените элемент с индексом 2 на новое значение).
fun changeElement() {
    val intList: MutableList<Int> = mutableListOf(43, 432, 67, 64)
    println(intList[2])
    intList[2] = 9000
    println(intList[2])
}

// 9. Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков.
// Реши задачу с помощью циклов.
fun unionList() {
    val sentences = listOf(
        "Kotlin is a modern programming language.",
        "It runs on the Java Virtual Machine.",
        "Android developers often use Kotlin.",
        "The syntax is clean and expressive.",
        "Null safety is one of its key features."
    )
    val sentences2 = listOf(
        "Kotlin is easy to learn.",
        "I enjoy writing clean code.",
        "Android apps are often built with Kotlin.",
        "Learning new languages improves your skills.",
        "Practice makes perfect."
    )
    val unionList: MutableList<String> = mutableListOf()
    for (i in sentences) {
        unionList.add(i)
    }
    for (j in sentences2) {
        unionList.add(j)
    }
    println(unionList)
}

// 10. Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
fun minAndMax() {
    val listInt = listOf(43, 423, 5835, 3958, 2984, 492)
    var min = listInt[0]
    var max = listInt[0]
    for (i in listInt) {
        if (i > max) {
            max = i
        } else if (i < min) {
            min = i
        }
    }
    println("$min, $max")
}

// 11. Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
fun oddList() {
    val listInt = listOf(43, 423, 5835, 3958, 2984, 492)
    val result: MutableList<Int> = mutableListOf()
    for (i in listInt) {
        if (i % 2 == 0) {
            result.add(i)
        }
    }
    println(result)
}

//Работа с Множествами Set.
// 1. Создайте пустое неизменяемое множество целых чисел.
fun emptySet() {
    val emptySet = emptySet<Int>()
}

// 2. Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
fun intSet() {
    val intSet: Set<Int> = setOf(1, 2, 3)
}

// 3. Создайте изменяемое множество строк и инициализируйте его несколькими значениями
// (например, "Kotlin", "Java", "Scala").
fun stringSet() {
    val stringSet: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")
}

// 4. Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
fun addStringSet() {
    val stringSet: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")
    stringSet.add("Swift")
    stringSet.add("Go")
}

// 5. Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
fun mutableIntSet() {
    val mutableIntSet: MutableSet<Int> = mutableSetOf(1, 2, 3)
    mutableIntSet.remove(2)
}

// 6. Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
fun printSet() {
    val printSet: Set<Int> = setOf(1, 2, 3)
    for (i in printSet) println(i)
}

// 7. Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве
// указанная строка. Нужно вернуть булево значение true если строка есть. Реши задачу через цикл.
fun containString(setOfStrings: Set<String>, findElem: String): Boolean {
    var isContain = false
    for (i in setOfStrings) {
        if (i.equals(findElem)) {
            isContain = true
            break
        }
    }
    return isContain
}

// 8. Создайте множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
fun convertSetToList() {
    val sentences = setOf(
        "Kotlin is a modern programming language.",
        "It runs on the Java Virtual Machine.",
        "Android developers often use Kotlin.",
        "The syntax is clean and expressive.",
        "Null safety is one of its key features."
    )
    val sentencesList: MutableList<String> = mutableListOf()
    for (sentence in sentences) sentencesList.add(sentence)
    println(sentencesList)
}