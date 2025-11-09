package ru.stimmax.ru.stimmax.lessons.lesson18.homework

// Создай абстрактные классы устройств, используя эти интерфейсы. Реализовывать методы не нужно.
// 1. Холодильник
abstract class Refrigerator : Powerable, TemperatureRegulatable, WaterConnection, Cleanable

// 2. Стиральная машина
abstract class WashingMachine :
    Powerable,
    WaterConnection,
    Drainable,
    Timable,
    Programmable,
    AutomaticShutdown,
    Cleanable

// 3. Умная лампа
abstract class SmartLamp :
    Powerable,
    LightEmitting,
    Programmable,
    Rechargeable

// 4. Электронные часы
abstract class DigitalClock :
    Powerable,
    Timable,
    LightEmitting,
    Programmable

// 5. Робот-пылесос
abstract class RobotVacuumCleaner :
    Powerable,
    Movable,
    Cleanable,
    Rechargeable,
    Programmable,
    AutomaticShutdown

// 6. Механические часы
abstract class MechanicalClock :
    Mechanical,
    Timable

// 7. Фонарик
abstract class Flashlight :
    Powerable,
    LightEmitting,
    BatteryOperated

// 8. Кофемашина
abstract class CoffeeMachine :
    Powerable,
    WaterContainer,
    TemperatureRegulatable,
    Programmable,
    Drainable,
    AutomaticShutdown,
    Cleanable

// 9. Умная колонка
abstract class SmartSpeaker :
    Powerable,
    SoundEmitting,
    Programmable,
    Timable,
    Rechargeable