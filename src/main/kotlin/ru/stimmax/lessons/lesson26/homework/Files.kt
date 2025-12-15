package ru.stimmax.ru.stimmax.lessons.lesson26.homework

import java.io.File

fun main() {
    // Общий корень
    val workspace = File("workspace").apply { mkdirs() }

    // =========================
    // Задача 1
    // =========================
    File("workspace/task1/example.txt").apply {
        parentFile?.mkdirs()
        writeText("Hello, Kotlin!")
    }.also { file ->
        println("Task1 exists: ${file.exists()}")
    }

    // =========================
    // Задача 2
    // =========================
    File("workspace/task2/testDir").apply { mkdirs() }
        .also { dir ->
            println("Task2 isDirectory: ${dir.isDirectory}")
            println("Task2 absolutePath: ${dir.absolutePath}")
        }

    // =========================
    // Задача 3
    // =========================
    File("workspace/task3/structure").apply { mkdirs() }.also { structure ->
        structure.resolve("myDir").apply { mkdirs() }.also { myDir ->
            myDir.resolve("subDir1").apply { mkdirs() }
            myDir.resolve("subDir2").apply { mkdirs() }

            val ok = myDir.resolve("subDir1").isDirectory && myDir.resolve("subDir2").isDirectory
            println("Task3 myDir contains subDir1 & subDir2: $ok")
        }
    }

    // =========================
    // Задача 4
    // =========================
    File("workspace/task4/temp").apply { mkdirs() }.also { temp ->
        temp.resolve("a.txt").writeText("A")
        temp.resolve("b.txt").writeText("B")
        temp.resolve("inner").apply { mkdirs() }.resolve("c.txt").writeText("C")
        temp.resolve("inner2").apply { mkdirs() }

        val deleted = File("workspace/task4").deleteRecursively()
        println("Task4 deleted workspace/task4 recursively: $deleted")
    }

    // =========================
    // Задача 5
    // =========================
    File("workspace/task5/config/config.txt").apply {
        parentFile?.mkdirs()
        writeText(
            """
            host=localhost
            port=5432
            user=admin
            password=secret
            """.trimIndent()
        )
    }.also { cfg ->
        cfg.readLines()
            .mapNotNull { line ->
                if (line.isBlank() || !line.contains("=")) null else line.substringAfter("=")
            }
            .forEach { value -> println("Task5 value: $value") }
    }

    // =========================
    // Задача 6
    // =========================
    File("workspace").walkTopDown()
        .filter { it.isDirectory }
        .forEach { println("Task6 dir: ${it.path}") }

    File("workspace").walkTopDown()
        .filter { it.isFile }
        .forEach { println("Task6 file: ${it.path}") }

    // =========================
    // Задача 7
    // =========================
    File("workspace/task7/docs").apply { mkdirs() }
        .resolve("readme.md")
        .also { readme ->
            if (!readme.exists()) readme.writeText("This is a README file.")
            val text = readme.readText()
            println("Task7 text ok: ${text == "This is a README file."}")
        }

    // =========================
    // Задача 8
    // =========================
    val dataBase = File("workspace/task8/data").apply { mkdirs() }

    listOf(
        "1/4/prod/data14.mysql",
        "2/3/prod/data23.mysql",
        "5/2/prod/data52.mysql",
    ).forEach { rel ->
        dataBase.resolve(rel).apply {
            parentFile?.mkdirs()
            writeText("dummy content for $name")
        }
    }

    val backupBase = File("workspace/task8/backup").apply { mkdirs() }

    dataBase.walkTopDown()
        .filter { it.isFile }
        .forEach { src ->
            val relative = src.relativeTo(dataBase)
            val dst = backupBase.resolve(relative.path)
            dst.parentFile?.mkdirs()
            src.copyTo(dst, overwrite = true)
        }

    println("Task8 copied files to backup preserving structure.")
}


