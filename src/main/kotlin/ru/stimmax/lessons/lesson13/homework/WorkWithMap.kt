package ru.stimmax.lessons.lesson13.homework

fun main() {
// 1. Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах.
// Определите среднее время выполнения теста.

    val times = mapOf("test1" to 5, "test2" to 15, "test3" to 10)
    val avg = times.values.average()
    println(avg)

// 2. Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов,
// а значения - строка с метаданными. Выведите список всех тестовых методов.

    val metadata = mapOf("testLogin" to "...", "testLogout" to "...")
    val testNames = metadata.keys
    println(testNames)

// 3. В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.

    val results = mutableMapOf("test1" to "passed")
    results["test2"] = "failed"

// 4. Посчитайте количество успешных тестов в словаре с результатами
// (ключ - название, значение - результат из passed, failed, skipped).

    val testResults = mapOf("t1" to "passed", "t2" to "failed", "t3" to "passed")
    val count = testResults.values.count { it == "passed" }
    println(count)

// 5. Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен
// (ключ - название, значение - статус исправления).

    val bugs = mutableMapOf("bug1" to "fixed", "bug2" to "open")
    bugs.remove("bug1")

// 6. Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа),
// выведите сообщение о странице и статусе её проверки.

    val results2 = mapOf("site.ru" to "ok", "page.com" to "failed")
    for ((url, status) in results2) println("Страница $url проверена: $status")

// 7. Найдите в словаре с названием и временем ответа сервисов только те,
// время ответа которых превышает заданный порог.

    val responses = mapOf("serviceA" to 12, "serviceB" to 4)
    val threshold = 10
    val slow = responses.filter { it.value > threshold }
    println(slow.keys)

// 8. В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки).
// Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.

    val api = mapOf("/user" to "200 OK", "/post" to "404 Not Found")
    val endpoint = "/profile"
    val status = api[endpoint] ?: "Не протестирован"
    println(status)

// 9. Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации,
// значение - сама конфигурация), получите значение для "browserType". Ответ не может быть null.

    val config = mapOf("browserType" to "Chrome", "timeout" to "10")
    val browserType = config.getValue("browserType")

// 10. Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.

    val versions = mapOf("v1" to "stable")
    val newVersions = versions + ("v2" to "beta")

// 11. Используя словарь с настройками тестирования для различных мобильных устройств
// (ключ — модель устройства, значение - строка с настройками), получите настройки для конкретной
// модели или верните настройки по умолчанию.

    val settings = mapOf("Xiaomi" to "configA")
    val model = "Samsung"
    val deviceSettings = settings[model] ?: "defaultConfig"

// 12. Проверьте, содержит ли словарь с ошибками тестирования
// (ключ - код ошибки, значение - описание ошибки) определенный код ошибки.

    val errors = mapOf(101 to "desc1", 102 to "desc2")
    val code = 101
    val hasError = errors.containsKey(code)

// 13. Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version",
// а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped"). Отфильтруйте словарь,
// оставив только те сценарии, идентификаторы которых соответствуют определённой версии тестов,
// то-есть в ключе содержится требуемая версия.

    val tests = mapOf("Test1_v2" to "Passed", "Test3_v1" to "Failed")
    val version = "v2"
    val filtered = tests.filterKeys { it.contains(version) }
    println(filtered)

// 14. У вас есть словарь, где ключи — это названия функциональных модулей приложения,
// а значения — результаты их тестирования. Проверьте, есть ли модули с неудачным тестированием.

    val modules = mapOf("Auth" to "Passed", "Log" to "Failed")
    val failedModules = modules.containsValue("Failed")

// 15. Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.

    val env = mutableMapOf("timeout" to "10")
    val extra = mapOf("browser" to "Chrome")
    env.putAll(extra)

// 16. Объедините два неизменяемых словаря с данными о багах.

    val a = mapOf("b1" to "open")
    val b = mapOf("b2" to "closed")
    val result = a + b

// 17. Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.

    val data = mutableMapOf("run1" to "ok")
    data.clear()

// 18. Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены
// (имеют статус “skipped”). Ключи - название теста, значения - статус.

    val report = mapOf("t1" to "skipped", "t2" to "passed", "t3" to "failed")
    val filtered3 = report.filterValues { it != "skipped" }

// 19. Создайте копию словаря с конфигурациями тестирования удалив из него несколько конфигураций.

    val config2 = mapOf("c1" to "v1", "c2" to "v2", "c3" to "v3")
    val toRemove = listOf("c2", "c3")
    val copy = config2.filterKeys { it !in toRemove }

// 20. Создайте отчет о тестировании, преобразовав словарь с результатами тестирования
// (ключ — идентификатор теста, значение — результат) в список строк формата "Test ID: результат".

    val testResults2 = mapOf("T1" to "Passed", "T2" to "Failed")
    val report2 = testResults2.map { "${it.key}: ${it.value}" }

// 21. Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.

    val results3 = mutableMapOf("test1" to "ok")
    val immutable = results3.toMap()

// 22. Преобразуйте словарь, содержащий числовой ID теста и данные о времени выполнения тестов,
// заменив идентификаторы тестов на их строковый аналог (например через toString()).

    val times2 = mapOf(1 to 10, 2 to 20)
    val converted = times2.mapKeys { it.key.toString() }

// 23. Для словаря с оценками производительности различных версий приложения (ключи - строковая версия, значения -
// дробное число времени ответа сервера) увеличьте каждую оценку на 10%, чтобы учесть новые условия тестирования.

    val perf = mapOf("v1" to 1.0, "v2" to 2.0)
    val newPerf = perf.mapValues { it.value * 1.1 }

// 24. Проверьте, пуст ли словарь с ошибками компиляции тестов.

    val compileErrors = mapOf<String, String>()
    val isEmpty = compileErrors.isEmpty()

// 25. Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.

    val loadResults = mapOf<String, String>("t1" to "ok")
    val notEmpty = loadResults.isNotEmpty()

// 26. Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.

    val testResults3 = mapOf("test1" to "Passed", "test2" to "Passed")
    val allPassed = testResults3.values.all { it == "Passed" }

// 27. Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.

    val testResults4 = mapOf("test1" to "Passed", "test2" to "Failed")
    val hasFailed = testResults4.values.any { it == "Failed" }

// 28. Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты,
// которые не прошли успешно и содержат в названии “optional”.

    val serviceResults = mapOf("srv1_optional" to "Failed", "srv2_main" to "Passed")
    val filtered2 = serviceResults.filter {
        it.key.contains("optional") && it.value != "Passed"
    }
}