package ru.stimmax.ru.stimmax.lessons.lesson16.homework

//Геометрические Фигуры и Их Площадь
//Абстрактный (базовый) класс: Shape с open методом area().
//Классы наследники: Circle, Square, Triangle.
//Метод area() возвращает 0.0.
//Переопределите метод area() в каждом классе-наследнике для расчета площади соответствующей фигуры.
//Подсказка: каждый класс должен иметь аргументы конструктора, позволяющие вычислить площадь
// (для круга это радиус, для квадрата это сторона, для треугольника это две стороны и угол между ними)
//Создай набор геометрических фигур и выведи в цикле их площадь
import kotlin.math.*

abstract class Shape {

    open fun area(): Double {
        return 0.0
    }

}

class Circle(val radius: Double): Shape() {

    override fun area(): Double {
        return PI * radius * radius
    }

}

class Square(val side: Double): Shape() {

    override fun area(): Double {
        return side * side
    }

}

class Triangle(val side1: Double, val side2: Double, val angle: Double): Shape() {

    override fun area(): Double {
        return 0.5 * side1 * side2 * sin(Math.toRadians(angle))
    }

}

fun main() {
    val shapes: List<Shape> = listOf(Circle(5.0), Square(3.7), Triangle(3.0, 4.0, 98.0))
    for (shape in shapes) {
        println(shape.area())
    }
}