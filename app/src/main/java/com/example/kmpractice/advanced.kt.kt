package com.example.kmpractice

// 1. lambda
// value 처럼 다룰수 있는 익명함수
// 1) 메소드의 파라미터로 넘겨줄 수 있다. fun maxBy(a: Int)
// 2) 리턴 값으로 사용할 수가  있다.

// 람다의 기본정의
// val lambdaName : Type = {argumentList -> codeBody}

val square : (Int) -> (Int) = {number: Int -> number*number}

// 타입 추론이 가능하도록 해야한다.


val nameAge: (String, Int) -> String = {name: String, age : Int ->
    "my name is ${name} I'm ${age}"
}


fun main(){
    println(square(12))
    println(nameAge("Joyce", 99))

    val a = "joyce said"
    val b = "mac said"
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(extendString("ariana", age = 27))

    println(calculateGrade(97))
    println(calculateGrade(998))

    val lambda = {number: Double -> number==4.3213}

    println(invokeLambda(lambda))
    println(invokeLambda{ it > 3.22 })
    println(invokeLambda({ it > 3.22 })) // 위와 같다.
}

// 확장함수
// 클래스에서 함수를 조금 더 추가하고 싶을 때
// String 클래스에 함수를 추가하고 싶을 때를 예로 들어보자
val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString(name: String, age: Int) : String{
    val introduceMyself : String.(Int) -> String = {
        "I am ${this} and ${it} years old" // this는 String, it는 age
    }

    return name.introduceMyself(age)
}

// 람다의 리턴
// 람다는 마지막 한줄이 리턴값을 의미..?

val calculateGrade : (Int) -> String = {
    when(it) {
        in 0..40 -> "fali"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 람다를 표현하는 여러가지 방법

fun invokeLambda(lambda: (Double) -> Boolean) : Boolean {
    return lambda(5.234)
}

