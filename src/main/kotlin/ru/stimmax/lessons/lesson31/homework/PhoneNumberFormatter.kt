package ru.stimmax.ru.stimmax.lessons.lesson31.homework

class PhoneNumberFormatter {

    fun formatPhoneNumber(input: String): String {
        val digits = input.replace("\\D".toRegex(), "")
        if (digits.length != 10 && digits.length != 11) {
            throw IllegalArgumentException("Невалидная длина номера: ${digits.length}")
        }

        val normalized = if (digits.length == 11) {
            val first = digits[0]
            if (first != '8' && first != '7') {
                throw IllegalArgumentException("Невалидный код страны/префикс: $first")
            }
            digits.substring(1) // убираем 8 или 7
        } else {
            digits
        }

        // normalized теперь ровно 10 цифр
        val code = normalized.substring(0, 3)
        val part1 = normalized.substring(3, 6)
        val part2 = normalized.substring(6, 8)
        val part3 = normalized.substring(8, 10)

        return "+7 ($code) $part1-$part2-$part3"
    }
}