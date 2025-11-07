package ru.stimmax.ru.stimmax.lessons.lesson17.homework

abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass.
    // Ответ - ChildrenClass имеет такое же поле, которое не наследовано, а является полем ChildrenClass
    private val privateVal: String,
    // 2. объясни, почему это поле недоступно в main()
    // Ответ - поле с модификатором protected доступно только в области видимости класса или его наследников
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"
    fun setPrivate(value: String) {
        privateField = value
    }
    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }
    fun printText() {
        privatePrint()
    }
    // 7. объясни, почему эта функция не может быть публичной
    // Ответ - class ProtectedClass имеет модификатор protected, поэтому не может быть доступным везде
    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }
    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
    // Ответ - потому что в наследнике это метод переопределен
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }
    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }
    // 9. объясни, почему эта функция не может быть публичной или protected
    // Ответ - потому что class PrivateClass имеет модификатор private
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}
class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    // Ответ - это публичное поле родительского класса, оно доступно везде
    publicVal: String
) : BaseClass(privateVal, protectedVal, privateVal) {
    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    // Ответ - Функция публичная, наследована из родительского класса

    // 12. проверь, что выводится на печать при вызове функции printText() - Печать из класса BaseClass
    // и объясни, почему не происходит переопределение метода privatePrint()
    // Ответ - происходит вызов из родительского класса, в дочернем классе метод не переопределен
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }
    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }

    // 5. Ответ
    fun updateProtectedField(value: String) {
        protectedField = value
    }
}

fun main() {
    val child = ChildrenClass("privateVal field", "protectedVal field", "publicVal field")
    child.printText()

}