package ru.stimmax.ru.stimmax.lessons.lesson27.homework

// Задание 1: Enum'ы
// Задание 2: печать типов недвижимости по возрастанию длины названия enum (humanTitle)
// Задание 3: запуск лямбды () -> Unit и возврат статуса по исключениям
// Задание 4: фильтр планет (Planet) -> Boolean и возврат первой подходящей или исключение

// =========================
// Задание 1
// =========================

enum class TestStatus {
    PASSED,
    BROKEN,
    FAILED
}

enum class PropertyType(val humanTitle: String) {
    APARTMENT("Квартира"),
    STUDIO("Студия"),
    ROOM("Комната"),
    HOUSE("Дом"),
    COTTAGE("Коттедж"),
    TOWNHOUSE("Таунхаус"),
    DUPLEX("Дуплекс"),
    PENTHOUSE("Пентхаус"),
    VILLA("Вилла"),
    LOFT("Лофт")
}

data class PlanetInfo(
    val distanceAu: Double, // расстояние до Солнца (а.е.)
    val massKg: Double      // масса, кг
)

enum class Planet(val info: PlanetInfo) {
    // усреднённые расстояния (semi-major axis), массы в кг
    MERCURY(PlanetInfo(distanceAu = 0.387, massKg = 3.3011e23)),
    VENUS(PlanetInfo(distanceAu = 0.723, massKg = 4.8675e24)),
    EARTH(PlanetInfo(distanceAu = 1.000, massKg = 5.97237e24)),
    MARS(PlanetInfo(distanceAu = 1.524, massKg = 6.4171e23)),
    JUPITER(PlanetInfo(distanceAu = 5.203, massKg = 1.8982e27)),
    SATURN(PlanetInfo(distanceAu = 9.537, massKg = 5.6834e26)),
    URANUS(PlanetInfo(distanceAu = 19.191, massKg = 8.6810e25)),
    NEPTUNE(PlanetInfo(distanceAu = 30.068, massKg = 1.02413e26));

    val distanceAu: Double get() = info.distanceAu
    val massKg: Double get() = info.massKg
}

// =========================
// Задание 2
// =========================

fun printPropertyTypesByTitleLength() {
    PropertyType.entries
        .sortedBy { it.humanTitle.length }
        .forEach { println(it.humanTitle) }
}

// =========================
// Задание 3
// =========================

fun runTest(action: () -> Unit): TestStatus =
    try {
        action()
        TestStatus.PASSED
    } catch (e: AssertionError) {
        TestStatus.FAILED
    } catch (e: Throwable) {
        TestStatus.BROKEN
    }

// =========================
// Задание 4
// =========================

fun firstPlanetWhere(predicate: (Planet) -> Boolean): Planet {
    return Planet.entries.firstOrNull(predicate)
        ?: throw NoSuchElementException("Нет планет, удовлетворяющих условию фильтра.")
}
