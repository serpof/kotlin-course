package ru.stimmax.ru.stimmax.lessons.lesson16.homework

//Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
//Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
//Выполнить перегрузку addToCart который:
//Принимает два аргумента (itemId и количество amount)
//Принимает словарь из id и количества и добавляет всё в корзину.
//Принимает список из id (добавляет по одной единице).
//Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
//Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину в консоль.
//Переопредели у корзины метод toString для красивого форматирования содержимого таблицы, включая итоговое
// количество артикулов и общее количество всего товара в корзине.
class Basket {

    private val goods= mutableMapOf<String, Int>()

    fun addToCart(itemId: String) {
        goods[itemId] = goods.getOrDefault(itemId, 0) + 1
    }

    fun addToCart(itemId: String, amount: Int) {
        goods[itemId] = goods.getOrDefault(itemId, 0) + amount
    }

    fun addToCart(itemId: List<String>) {
        for (item in itemId) {
            goods[item] = goods.getOrDefault(item, 0) + 1
        }
    }

    fun addToCart(itemId: Map<String, Int>) {
        for ((id, amount) in itemId) {
            goods[id] = goods.getOrDefault(id, 0) + amount
        }
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.appendLine("=== Содержимое корзины ===")
        var totalItems = 0
        for ((id, amount) in goods) {
            builder.appendLine("Товар: $id, количество: $amount")
            totalItems += amount
        }
        builder.appendLine("==========================")
        builder.appendLine("Всего артикулов: ${goods.size}")
        builder.appendLine("Всего товаров: $totalItems")
        return builder.toString()
    }
}

fun main() {
    val basket = Basket()

    // Добавляем по одному
    basket.addToCart("A123")
    basket.addToCart("B456")

    // Добавляем с количеством
    basket.addToCart("A123", 3)

    // Добавляем список
    basket.addToCart(listOf("C789", "A123", "D000"))

    // Добавляем словарь
    basket.addToCart(mapOf("E111" to 5, "B456" to 2))

    println(basket)
}