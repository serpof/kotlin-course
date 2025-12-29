
package com.yourpackage

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.*
import ru.stimmax.ru.stimmax.lessons.lesson31.homework.PhoneNumberFormatter
import java.util.stream.Stream

class PhoneNumberFormatterTest {

    private val formatter = PhoneNumberFormatter()

    // ---------- Валидные номера: CSV источник ----------

    @ParameterizedTest(name = "Valid: ''{0}'' -> ''{1}''")
    @CsvSource(
        "8 (922) 941-11-11, +7 (922) 941-11-11",
        "79229411111, +7 (922) 941-11-11",
        "+7 922 941 11 11, +7 (922) 941-11-11",
        "9229411111, +7 (922) 941-11-11",
        "abc +7 922 941 11 11, +7 (922) 941-11-11"
    )
    fun `formatPhoneNumber formats valid inputs`(input: String, expected: String) {
        assertEquals(expected, formatter.formatPhoneNumber(input))
    }

    // ---------- Валидные номера: MethodSource (доп. кейсы) ----------

    @ParameterizedTest(name = "Valid extra: ''{0}'' -> ''{1}''")
    @MethodSource("validNumbersProvider")
    fun `formatPhoneNumber formats more valid inputs`(input: String, expected: String) {
        assertEquals(expected, formatter.formatPhoneNumber(input))
    }

    companion object {
        @JvmStatic
        fun validNumbersProvider(): Stream<Arguments> = Stream.of(
            // много “мусора”, но цифр ровно 11 и начинается на 8/7
            Arguments.of("8-922-941-11-11", "+7 (922) 941-11-11"),
            Arguments.of("7(999)0000011", "+7 (999) 000-00-11"),
            Arguments.of("  +7(495)123-45-67  ", "+7 (495) 123-45-67")
        )

        @JvmStatic
        fun invalidNumbersProvider(): Stream<String> = Stream.of(
            "12345",                    // слишком короткий
            "922941111",                // 9 цифр
            "922941111111",             // 12 цифр
            "+1 (922) 941-11-11",        // 11 цифр, но начинается с 1
            "61234567890",              // 11 цифр, но начинается с 6
            "7",                         // 1 цифра
            "abcdefgh",                  // 0 цифр
            "+7 922 941 11 11 00"        // 13 цифр
        )
    }

    // ---------- Невалидные номера: MethodSource ----------

    @ParameterizedTest(name = "Invalid: ''{0}'' -> throws IllegalArgumentException")
    @MethodSource("invalidNumbersProvider")
    fun `formatPhoneNumber throws on invalid inputs`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            formatter.formatPhoneNumber(input)
        }
    }

    // ---------- Невалидные номера: ValueSource (отдельно длины) ----------

    @ParameterizedTest(name = "Invalid length: ''{0}''")
    @ValueSource(strings = ["", "1", "12", "123456789", "123456789012", "0000000000000"])
    fun `formatPhoneNumber throws on invalid length after cleanup`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            formatter.formatPhoneNumber(input)
        }
    }

    // ---------- Невалидные 11-значные: first digit not 7 or 8 ----------

    @ParameterizedTest(name = "Invalid prefix in 11 digits: ''{0}''")
    @ValueSource(strings = ["19229411111", "09229411111", "69229411111"])
    fun `formatPhoneNumber throws when 11 digits but invalid first digit`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            formatter.formatPhoneNumber(input)
        }
    }
}