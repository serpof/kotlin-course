package ru.stimmax.ru.stimmax.lessons.lesson05.homework

fun main() {

    // task 1
    val initialSoundIntensity: Double = 5.0
    val attenuationCoefficient: Double? = 0.9
    val defaultCoefficient = 0.5
    val attenuatedSoundIntensity = initialSoundIntensity * (attenuationCoefficient ?: defaultCoefficient)

    //task 2
    val defaultPriceGoods: Double = 50.00
    val priceGoods: Double? = null
    val deliveryPrice: Double = 10.0
    val insuranceCoefficient: Double = 0.005
    val fullPriceDelivery = deliveryPrice + (priceGoods ?: defaultPriceGoods) * insuranceCoefficient

    //task 3
    val pressure: Double? = 760.00
    val errorMessage: String = "Error! Pressure is missed"
    val result = pressure ?: errorMessage

}