package ru.stimmax.ru.stimmax.lessons.lesson16.homework

//Класс “Логгер” - инструмент для вывода информации в консоль с разным префиксами уровня
// логирования (INFO, WARNING, ERROR, DEBUG)
//Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO.
//Выполнить перегрузку метода log, который:
//Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом
// на красном фоне.
//Принимает список сообщений и все их выводит с уровнем INFO.
//Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR.
//Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.

class Logger {

    fun log(message: String) {
        println("\u001B[34m[INFO]\u001B[0m $message")
    }

    fun log(level: String, message: String) {
        when (level.uppercase()) {
            "WARNING" -> println("\u001B[33m[WARNING]\u001B[0m $message")
            "ERROR" -> println("\u001B[37m\u001B[41m[ERROR]\u001B[0m $message")
            "DEBUG" -> println("\u001B[36m[DEBUG]\u001B[0m $message")
            else -> log(message)
        }
    }

    fun log(messages: List<String>) {
        for (msg in messages) log(msg)
    }

    fun log(exception: Exception) {
        println("\u001B[37m\u001B[41m[ERROR]\u001B[0m ${exception.message}")
    }
}

fun main() {
    val logger = Logger()
    logger.log("System started")
    logger.log("WARNING", "Low disk space")
    logger.log("ERROR", "File not found")
    logger.log("DEBUG", "Connection established")
    logger.log(listOf("User logged in", "Data processed", "Session ended"))
    logger.log(Exception("Null pointer exception"))
}