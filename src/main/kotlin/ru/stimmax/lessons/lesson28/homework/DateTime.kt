package ru.stimmax.ru.stimmax.lessons.lesson28.homework

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import java.time.temporal.Temporal
import java.time.temporal.TemporalAccessor

private val BOOMER_START: LocalDate = LocalDate.of(1946, 1, 1)
private val BOOMER_END: LocalDate = LocalDate.of(1964, 12, 31)
private val ZOOMER_START: LocalDate = LocalDate.of(1997, 1, 1)
private val ZOOMER_END: LocalDate = LocalDate.of(2012, 12, 31)

fun LocalDate.identifyGeneration() {
    val isBoomer = this.isAfter(BOOMER_START.minusDays(1)) && this.isBefore(BOOMER_END.plusDays(1))
    val isZoomer = this.isAfter(ZOOMER_START.minusDays(1)) && this.isBefore(ZOOMER_END.plusDays(1))
    println(
        when {
            isBoomer -> "Бумер"
            isZoomer -> "Зумер"
            else -> "Не определено"
        }
    )
}

private fun TemporalAccessor.has(field: ChronoField): Boolean =
    try { isSupported(field) } catch (_: Exception) { false }

fun formatTemporalCustom(t: Temporal): String {
    val a: TemporalAccessor = t

    val hasDate = a.has(ChronoField.YEAR) && a.has(ChronoField.MONTH_OF_YEAR) &&
            a.has(ChronoField.DAY_OF_MONTH)
    val hasTime = a.has(ChronoField.HOUR_OF_DAY) && a.has(ChronoField.MINUTE_OF_HOUR)
    val hasSeconds = a.has(ChronoField.SECOND_OF_MINUTE)

    val datePart = if (hasDate) {
        val y = a.get(ChronoField.YEAR)
        val m = a.get(ChronoField.MONTH_OF_YEAR)
        val d = a.get(ChronoField.DAY_OF_MONTH)
        "%04d-%02d-%02d".format(y, m, d)
    } else null

    val timePart = if (hasTime) {
        val hh = a.get(ChronoField.HOUR_OF_DAY)
        val mm = a.get(ChronoField.MINUTE_OF_HOUR)
        val ss = if (hasSeconds) a.get(ChronoField.SECOND_OF_MINUTE) else 0
        "%02d:%02d:%02d".format(hh, mm, ss)
    } else null

    val zonePart = when (t) {
        is ZonedDateTime -> t.zone.id
        is OffsetDateTime -> t.offset.id
        is OffsetTime -> t.offset.id
        is Instant -> "Z"
        else -> null
    }

    return buildString {
        when {
            datePart != null && timePart != null -> append("$datePart $timePart")
            datePart != null -> append(datePart)
            timePart != null -> append(timePart)
            else -> append(t.toString())
        }
        if (zonePart != null) append(" $zonePart")
    }
}

fun formatTemporalIso(t: Temporal): String = when (t) {
    is LocalDate -> DateTimeFormatter.ISO_LOCAL_DATE.format(t)
    is LocalTime -> DateTimeFormatter.ISO_LOCAL_TIME.format(t)
    is LocalDateTime -> DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(t)
    is OffsetTime -> DateTimeFormatter.ISO_OFFSET_TIME.format(t)
    is OffsetDateTime -> DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(t)
    is ZonedDateTime -> DateTimeFormatter.ISO_ZONED_DATE_TIME.format(t)
    is Instant -> DateTimeFormatter.ISO_INSTANT.format(t)
    else -> t.toString()
}

fun main() {
    // 1 Создай текущую метку времени и выведи её на печать (чтобы ещё раз запомнить название этого класса)
    val ts: Instant = Instant.now()
    println("Timestamp class: ${ts::class.qualifiedName} -> $ts")

    // 2 Создай дату своего дня рождения.
    val birthday: LocalDate = LocalDate.of(1990, 1, 15)

    // 3 Создай период между датой своего рождения и текущей датой. Выведи на печать количество лет из этого периода.
    val years = Period.between(birthday, LocalDate.now()).years
    println("Years since birthday: $years")

    // 4 Создай функцию, которая принимает тип Temporal и выводит форматированное значение в зависимости от того,
    // содержит ли аргумент время и часовой пояс. Temporal - это общий тип для разных классов даты-времени.
    // В форматированном значении нужно выводить часы, минуты, секунды и таймзону, если они представлены в переданном
    // объекте. Обработай в методе все типы дат, которые знаешь. Реализуй два варианта функции - с собственный
    // форматированием и с форматами из ISO коллекции.
    println("Custom formatting:")
    listOf(
        LocalDate.of(2020, 12, 31),
        LocalTime.of(23, 59, 58),
        LocalDateTime.of(2020, 12, 31, 23, 59, 58),
        OffsetTime.of(10, 11, 12, 0, ZoneOffset.ofHours(2)),
        OffsetDateTime.of(2020, 12, 31, 23, 59, 58,
            0, ZoneOffset.UTC),
        ZonedDateTime.of(2020, 12, 31, 23, 59, 58,
            0, ZoneId.of("Europe/Belgrade")),
        Instant.parse("2020-12-31T23:59:58Z"),
        Year.of(2025),
        YearMonth.of(2025, 12),
        MonthDay.of(2, 25),
    ).forEach { println("${it::class.simpleName}: ${formatTemporalCustom(it as Temporal)}") }

    println("ISO formatting:")
    listOf(
        LocalDate.of(2020, 12, 31),
        LocalTime.of(23, 59, 58),
        LocalDateTime.of(2020, 12, 31, 23, 59, 58),
        OffsetTime.of(10, 11, 12, 0, ZoneOffset.ofHours(2)),
        OffsetDateTime.of(2020, 12, 31, 23, 59, 58,
            0, ZoneOffset.UTC),
        ZonedDateTime.of(2020, 12, 31, 23, 59, 58,
            0, ZoneId.of("Europe/Belgrade")),
        Instant.parse("2020-12-31T23:59:58Z"),
        Year.of(2025),
        YearMonth.of(2025, 12),
        MonthDay.of(2, 25),
    ).forEach { println("${it::class.simpleName}: ${formatTemporalIso(it as Temporal)}") }

    // 5 Создай объекты дат и / или времени которые мы изучили и по очереди передай их в метод созданный выше.
    // Не используй в них метод now()


    // 6 Создайте функцию identifyGeneration, которая расширяет класс LocalDate и печатает строку, определяющую,
    // к какому поколению принадлежит человек родившийся в эту дату: "Бумер" для тех, кто родился с 1946 по 1964 год
    // включительно, и "Зумер" для тех, кто родился с 1997 по 2012 год включительно. Если дата рождения не попадает ни
    // в один из этих диапазонов, функция должна печатать "Не определено". Для сравнения дат используй методы
    // isAfter(otherDate) и isBefore(otherDate) или проверку вхождения в диапазон. Объекты с эталонными датами вынеси
    // в приватные поля файла с методом identifyGeneration.
    LocalDate.of(1950, 5, 10).identifyGeneration()
    LocalDate.of(2005, 3, 1).identifyGeneration()
    LocalDate.of(1985, 6, 20).identifyGeneration()

    // 7 Создай два объекта даты: 25 февраля 2023 года и 25 февраля 2024 года. Создай форматтер, который форматирует
    // дату в месяц и день.
    val d2023 = LocalDate.of(2023, 2, 25)
    val d2024 = LocalDate.of(2024, 2, 25)
    val monthDayFormatter = DateTimeFormatter.ofPattern("MMMM d")

    // 8 Выведи первую отформатированную дату, прибавив к ней 10 дней.
    println("2023-02-25 + 10 days: ${d2023.plusDays(10).format(monthDayFormatter)}")

    // 9 Выведи вторую отформатированную дату, прибавив к ней 10 дней. Найди отличия)))
    println("2024-02-25 + 10 days: ${d2024.plusDays(10).format(monthDayFormatter)}")
    println("Difference: 2024 is leap year, so +10 days crosses Feb 29 and shifts result by 1 day vs 2023.")
}