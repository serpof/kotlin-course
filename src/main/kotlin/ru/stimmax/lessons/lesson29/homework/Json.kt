package ru.stimmax.ru.stimmax.lessons.lesson29.homework

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import org.gradle.internal.impldep.com.google.api.client.json.Json
import java.io.File

// Задание 1 Создай дата класс сотрудника компании Employee, содержащий: имя, статус трудоустройства (булево),
// дата рождения (строка), должность CharacterTypes, список подчинённых с типом Employee
@Serializable
data class Employee(
    val name: String,
    val employed: Boolean,
    val birthDate: String,
    val position: CharacterTypes,
    val subordinates: List<Employee> = emptyList()
)

// Задание 1 enum class CharacterTypes { CTO, UX_UI, CRM, FRONTEND_DEV, TEAM_LEAD, BACKEND_DEV, PM, SYSADMIN, QA }
@Serializable
enum class CharacterTypes {
    CTO,
    UX_UI,
    CRM, // Customer Relationship Manager
    FRONTEND_DEV,
    TEAM_LEAD,
    BACKEND_DEV,
    PM,
    SYSADMIN,
    QA
}

// Задание 2 Создай объекты рабочей группы так, чтобы у CTO был PM и CRM, у PM было два тим-лида (на фронт и бэк)
// и у каждого было по группе сотрудников подходящего для его стека профиля.
fun buildCompanyTree(): Employee {
    val frontendTeamLead = Employee(
        name = "Mila",
        employed = true,
        birthDate = "1991-04-12",
        position = CharacterTypes.TEAM_LEAD,
        subordinates = listOf(
            Employee("Ivan", true, "1996-02-10", CharacterTypes.FRONTEND_DEV),
            Employee("Sofija", true, "1994-09-03", CharacterTypes.UX_UI),
            Employee("Nina", true, "1998-11-21", CharacterTypes.QA),
        )
    )

    val backendTeamLead = Employee(
        name = "Marko",
        employed = true,
        birthDate = "1989-07-19",
        position = CharacterTypes.TEAM_LEAD,
        subordinates = listOf(
            Employee("Pavel", true, "1993-01-25", CharacterTypes.BACKEND_DEV),
            Employee("Olga", true, "1992-06-14", CharacterTypes.SYSADMIN),
            Employee("Dusan", true, "1997-03-30", CharacterTypes.QA),
        )
    )

    val pm = Employee(
        name = "Ana",
        employed = true,
        birthDate = "1990-12-05",
        position = CharacterTypes.PM,
        subordinates = listOf(frontendTeamLead, backendTeamLead)
    )

    val crm = Employee(
        name = "Jelena",
        employed = true,
        birthDate = "1995-05-08",
        position = CharacterTypes.CRM
    )

    val cto = Employee(
        name = "Sergey",
        employed = true,
        birthDate = "1988-10-15",
        position = CharacterTypes.CTO,
        subordinates = listOf(pm, crm)
    )

    return cto
}

// Задание 3 Создай функцию в которой: сериализуй CTO в текст с настройкой prettyPrinting, текст запиши в файл в
// корне проекта.
fun saveCtoToFile(cto: Employee, fileName: String = "cto.json") {
    val json = Json {
        prettyPrint = true
        encodeDefaults = true
    }
    val text = json.encodeToString(cto)
    File(fileName).writeText(text)
}

// Задание 4 Создай функцию в которой: прочитай текст из файла, десериализуй его в объект класса Employee,
// распечатай в консоль
fun readCtoFromFileAndPrint(fileName: String = "cto.json") {
    val json = Json {
        ignoreUnknownKeys = true
    }
    val text = File(fileName).readText()
    val cto = json.decodeFromString<Employee>(text)
    println(cto)
}
