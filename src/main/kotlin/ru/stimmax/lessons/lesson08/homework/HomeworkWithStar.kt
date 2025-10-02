package ru.stimmax.ru.stimmax.lessons.lesson08.homework

fun main() {
    multiplicationTable2(3, 40)
}

//7. Все слова с большой буквы.
//Напишите метод, который преобразует строку из нескольких слов в строку, где каждое слово начинается с заглавной буквы,
// а все остальные - строчные. Используй перебор, анализ символов и замену букв на заглавную с помощью метода
// uppercase() для конкретной буквы.
fun allWordsFromUpperCase(arg: String): String {
    var allUpperWords = ""
    for (word in arg.split(" ")) {
        allUpperWords +=  word[0].uppercase() + word.substring(1) + " "
    }

    return allUpperWords.trim()
}

//8. Игра в разведчика.
//Напишите шифратор/дешифратор для строки. Шифровка производится путём замены двух соседних букв между собой:
// Kotlin шифруется в oKltni. Дешифровка выполняется аналогично.
// Если длина строки - нечётная, в конец добавляется символ пробела до начала шифрования.
// Таким образом все шифрованные сообщения будут с чётной длинной. Должно получиться два публичных метода:
// encrypt() и decrypt() которые принимают строку и печатают результат в консоль.
fun encrypt(strFor: String) {
    var strForEncrypt = strFor
    val strLength = strFor.length
    var strEncrypted = ""
    if (strLength % 2 != 0) strForEncrypt += " "
    for (i in 0..<strLength step 2) {
        strEncrypted = strEncrypted + strForEncrypt[i + 1] + strForEncrypt[i]
    }

    println(strEncrypted)
}

fun decrypt(strFor: String) {
    var strDecrypted = ""
    for (i in 0..<strFor.length step 2) {
        strDecrypted = strDecrypted + strFor[i + 1] + strFor[i]
    }
    println(strDecrypted)
}

//9. Таблица умножения.
//Напишите функцию, которая принимает два числа и выводит таблицу умножения, у которой в заголовках столбцов и
// строк находятся перемножаемые числа, а в перекрестии заголовка и столбца - результат перемножения.
// Важно: каждый столбец должен быть выровнен по правому краю с помощью шаблона с форматированием строк. Размер
// форматирования каждой строки нужно вычислять динамически для каждого столбца.
fun multiplicationTable2(arg1: Int, arg2: Int) {
    var table = ""
    val firstColumn = arg1.toString().length
    var firstRow = ""
    val num = (arg1 * arg2).toString().length + 1
    for (i in 1..arg2) {
        firstRow += "%${num}s".format(i.toString())
    }
    println("${"%${firstColumn}s".format(" ")}$firstRow")
    for (i in 1..arg1) {
        for (j in 1..arg2) {
            table += "%${num}s".format((i * j).toString())
        }
        println("${"%${firstColumn}s".format(i)}$table")
        table = ""
    }
}