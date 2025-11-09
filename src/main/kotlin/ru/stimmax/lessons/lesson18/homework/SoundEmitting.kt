package ru.stimmax.ru.stimmax.lessons.lesson18.homework

import java.io.InputStream

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}