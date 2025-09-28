package com.example.kmpractice

// 4. object class

// Singleton Pattern : 객체가 한번만 생성된다. 불필요한 낭비 예방
object CarFactory {
    val cars : MutableList<Car> = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower : Int)

fun main() {
    val car : Car = CarFactory.makeCar(horsePower = 10)

    val car2 : Car = CarFactory.makeCar(200)

    println(car)
    println(car2)
    println(CarFactory.cars.size.toString())
}