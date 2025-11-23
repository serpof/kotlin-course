package ru.stimmax.ru.stimmax.lessons.lesson22.homework

//Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
//
// 1. NullPointerException
// 2. IndexOutOfBoundsException
// 3. ClassCastException
// 4. IllegalArgumentException
// 5. NumberFormatException
// 6. IllegalStateException
// 7. OutOfMemoryError
// 8. StackOverflowError
//Задание 9. Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок

fun main() {
    try {
        // NullPointerException
        val s: String? = null
        println(s!!.length)

        // IndexOutOfBoundsException
        val list = listOf(1, 2, 3)
        println(list[5])

        // ClassCastException
        val obj: Any = "Hello"
        val num = obj as Int

        // IllegalArgumentException
        require(2 > 5) { "require failed" }

        // NumberFormatException
        val parsed = "abc".toInt()

        // IllegalStateException
        check(false) { "Illegal state" }

        // OutOfMemoryError
        val huge = MutableList(1_000_000_000) { "X" }

        // StackOverflowError
        fun recurse(): Int = recurse()
        recurse()

    } catch (e: NullPointerException) {
        println("Caught NullPointerException: ${e.message}")
    } catch (e: IndexOutOfBoundsException) {
        println("Caught IndexOutOfBoundsException: ${e.message}")
    } catch (e: ClassCastException) {
        println("Caught ClassCastException: ${e.message}")
    } catch (e: IllegalArgumentException) {
        println("Caught IllegalArgumentException: ${e.message}")
    } catch (e: NumberFormatException) {
        println("Caught NumberFormatException: ${e.message}")
    } catch (e: IllegalStateException) {
        println("Caught IllegalStateException: ${e.message}")
    } catch (e: OutOfMemoryError) {
        println("Caught OutOfMemoryError: ${e.message}")
    } catch (e: StackOverflowError) {
        println("Caught StackOverflowError: ${e.message}")
    } finally {
        println("Finally executed")
    }
}

//Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и в блоке try/catch выполни набор действий
// с этим аргументом которые могут потенциально вызвать одно из исключений в этом же порядке:
//
//NullPointerException
//IndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//NumberFormatException
//IllegalStateException
//В блоке catch перехватывай исключение с общим типом Throwable а внутри через when определи тип исключения и
// выведи сообщение с названием исключения. Сразу после when выброси перехваченное исключение через throw,
// чтобы прекратить работу программы. Если аргумент функции не вызвал исключение, то выведи текст,
// сообщающий, что переданный аргумент фантастически хорош!
fun testArgument(arg: Any?) {
    try {
        val length = (arg as String?).let { it!!.length }

        val list = listOf(1)
        val element = list[5]

        val casted: Int = arg as Int

        require(arg == "Magic") { "Argument is not Magic" }

        val number = arg.toString().toInt()

        check(arg != null) { "Illegal state: arg is null" }

        println("Переданный аргумент фантастически хорош!")

    } catch (t: Throwable) {

        when (t) {
            is NullPointerException ->
                println("Перехвачено исключение: NullPointerException")

            is IndexOutOfBoundsException ->
                println("Перехвачено исключение: IndexOutOfBoundsException")

            is ClassCastException ->
                println("Перехвачено исключение: ClassCastException")

            is IllegalArgumentException ->
                println("Перехвачено исключение: IllegalArgumentException")

            is NumberFormatException ->
                println("Перехвачено исключение: NumberFormatException")

            is IllegalStateException ->
                println("Перехвачено исключение: IllegalStateException")

            else ->
                println("Неизвестная ошибка: ${t::class.simpleName}")
        }

        throw t
    }
}