package ru.stimmax.ru.stimmax.lessons.lesson18.homework

class Refrigerator : OpenableTemperatureDevice() {
    override val maxTemperature: Int
        get() = 10 
}

class WashingMachine : OpenableTemperatureDevice(), WaterContainer {
    override val capacity: Int = 10

    override fun fillWater(amount: Int) {
        if (!isOn) {
            println("It is OFF. Cannot fill water.")
            return
        }
        println("It filling $amount liters of water (max $capacity)")
    }

    override fun getWater(amount: Int) {
        if (!isOn) {
            println("It is OFF. Cannot get water.")
            return
        }
        println("It using $amount liters of water")
    }
}

class Kettle : OpenableTemperatureDevice(), WaterContainer {
    override val maxTemperature: Int
        get() = 100

    override val capacity: Int = 2

    override fun fillWater(amount: Int) {
        if (!isOn) {
            println("It is OFF. Cannot fill water.")
            return
        }
        println("It filling $amount liters of water (max $capacity)")
    }

    override fun getWater(amount: Int) {
        if (!isOn) {
            println("It is OFF. Cannot get water.")
            return
        }
        println("It using $amount liters of water")
    }
}

class Oven : OpenableTemperatureDevice() {
    override val maxTemperature: Int
        get() = 250
}

fun main() {
    val devices: List<OpenableTemperatureDevice> = listOf(
        Refrigerator(),
        WashingMachine(),
        Kettle(),
        Oven()
    )

    for (device in devices) {
        device.powerOn()
        device.open()
        device.setTemperature(75)
        device.programAction("Start operation")
        device.execute()
        device.close()
        device.powerOff()
        println("------")
    }

    val washingMachine = devices[1] as WashingMachine
    washingMachine.powerOn()
    washingMachine.fillWater(5)
    washingMachine.getWater(3)
    washingMachine.powerOff()
}