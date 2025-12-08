package ru.stimmax.ru.stimmax.lessons.lesson25.homework

// 1. Функция высшего порядка.
// Создайте функцию timeTracker, которая принимает другую функцию в качестве
// аргумента и измеряет время её выполнения. Возвращает время в миллисекундах.
// Использовать System.currentTimeMillis().

fun timeTracker(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - start
}

     class Person(val name: String, val age: Int) {
         var email: String = ""
     }

     class Employee(val name: String, val age: Int, val position: String) {
         var email: String = ""
         var department: String = "General"
     }

// 2. Использование apply для инициализации объекта Employee
// Создайте объект Employee и используйте apply для установки:
// email и department.

     fun task2(): Employee {
         return Employee("Alice", 28, "Designer").apply {
             email = "alice@example.com"
             department = "Creative"
         }
     }

// 3. Использование also и with.
//
// 1) Создать функцию, принимающую Person и печатающую данные в формате.
//    Использовать with(person) внутри функции.
// 2) Создать Person и использовать also для:
//    - добавления email
//    - вызова функции печати
// ============================================================================

     fun logPerson(person: Person) {
         with(person) {
             println(
                 """
            --- PERSON INFO ---
            Name: $name
            Age: $age
            Email: $email
            -------------------
        """.trimIndent()
             )
         }
     }

     fun task3(): Person {
         return Person("Bob", 32).also {
             it.email = "bob@example.com"
             logPerson(it)
         }
     }

// 4. Использование with для преобразования Person → Employee
// Использовать with(person), создать Employee внутри блока.
// Вернуть новый Employee.

     fun task4(person: Person): Employee {
         return with(person) {
             Employee(name, age, "Developer").apply {
                 email = this@with.email
             }
         }
     }

// 5. Использование run для преобразования Person → Employee
// То же самое, что и задание 4, но вместо with использовать run.

     fun task5(person: Person): Employee {
         return person.run {
             Employee(name, age, "Developer").apply {
                 email = this@run.email
             }
         }
     }

// 6. Использование let для безопасного преобразования Person → Employee
// Создать функцию-расширение Person?, которая:
// - использует let если объект не null
// - возвращает Employee или null

     fun Person?.toEmployee(position: String): Employee? {
         return this?.let {
             Employee(it.name, it.age, position).apply {
                 email = it.email
             }
         }
     }



