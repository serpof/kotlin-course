package ru.stimmax.ru.stimmax.lessons.lesson15.homework

import kotlin.math.PI

//Геометрические Фигуры
//Базовый класс: Геометрическая Фигура
//Производные классы: Многоугольник, Круг
//Дополнительное разветвление для многоугольника: Треугольник, Четырехугольник
abstract class Figure() {
    abstract fun square(): Double
    abstract fun length(): Double
}

class Circle(val radius: Double): Figure() {

    override fun square(): Double {
        return PI * radius * radius
    }

    override fun length(): Double {
        return 2 * PI * radius
    }
}

open class Polygon(val sideNumbers: Double): Figure() {

    override fun square(): Double {
        return sideNumbers
    }

    override fun length(): Double {
        return sideNumbers
    }
}

class Triangle(): Polygon(3.0) {

    override fun square(): Double {
        return sideNumbers
    }

    override fun length(): Double {
        return sideNumbers
    }
}

class Square(): Polygon(4.0) {

    override fun square(): Double {
        return sideNumbers
    }

    override fun length(): Double {
        return sideNumbers
    }
}