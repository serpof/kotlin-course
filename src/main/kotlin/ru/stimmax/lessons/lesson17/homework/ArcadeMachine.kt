package ru.stimmax.ru.stimmax.lessons.lesson17.homework

//Игровой автомат.
//Опиши схематически класс игрового автомата, правильно расставив объявление полей (val или var) и
// методов (аргументы и возвращаемые значения), включая модификаторы доступа (private для приватных)
//
//Поля:
//цвет
//модель
//включен
//ОС загружена
//список установленных игр
//наличие джойстика
//баланс вырученных средств
//владелец
//телефон поддержки
//игровой сеанс оплачен
//стоимость одного игрового сеанса
//пин-код автомата

//Методы:
//включить
//выключить
//загрузить ОС
//завершить работу ОС
//показать список игр
//включить игру
//оплатить игровой сеанс
//забрать наличные с помощью пин-кода
//открыть сейф и выдать наличные

class ArcadeMachine(val color: String,
                    val model: String,
                    var isJoystickAvailable: Boolean) {

    private var isTurned = false
    private var isOSLoaded = false
    val gameList = mutableListOf(
        "Batman",
        "Spiderman",
        "Aqua men"
    )
    private var balance = 0.0
    private var owner = ""
    var supportNumber = ""
    private var isGamePaid = false
    var sessionPrice = 10.0
    private var pinCode = 1234

    fun turnOn() {
        isTurned = true
        loadOS()
    }

    fun loadOS() {
        if (isOSLoaded) {
            println("OS is already loaded")
        } else {
            isOSLoaded = true
        }
    }

    fun endOS() {
        isOSLoaded = false
    }

    fun showGameList() {
        println(gameList.toList().joinToString("\n"))
    }

    fun payGame(payment: Double) {
        if (payment >= sessionPrice) {
            isGamePaid = true
            balance += payment
        } else {
            println("Game session costs more!")
        }
    }

    fun startGame(gameName: String) {
        if (!isGamePaid) {
            println("You must pay for game")
            return
        } else if (gameName !in gameList){
            println("We don't have $gameName")
            return
        } else {
            println("$gameName started")
        }
        isGamePaid = false
        return
    }

    fun withdrawCash(pin: Int): Double {
        if (pin == pinCode) {
            return openSafeAndWithdraw()
        } else {
            println("Wrong pin")
            return 0.0
        }
    }

    private fun openSafeAndWithdraw(): Double {
        val withdrawAmount = balance
        balance = 0.0
        return withdrawAmount
    }

}