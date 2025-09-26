package com.example.kmpractice

fun main(){
    helloWorld()

    println(add(4, 5))

    // 3. String Template
    val name = "kmyu"
    println("My name is ${name} I'm 45.")

    val lastName = "Yu"
    println("My name is ${name+lastName} I'm 45.")

    println("this is 2\$.")

    // 주석
    // 한줄 주석
    /*
    여러줄 주석
     */

    // 전체 주석은 cmd + /

    //
    checkNum(1)

}

// 1. 함수
fun helloWorld() : Unit{
    println("Hello World")
}

fun add(a: Int, b: Int) : Int{
    return a+b
}

// 2. val vs var
// val = value, 값이 바뀌지 않는다, 상수
// var = variable, 변할수가 있음

fun hi() {
    val a : Int = 10
    var b : Int = 9

    b = 100

    // 타입 지정을 안해도 된다.
    val c = 100
    var d = 100

    var name : String = "km"
    var my_name = "kkk" // 생략가능, 타입 자동 추론 가능

    // 단 초기화 할때는 타입 지정 필요

    var e : String
}

// 4. 조건식
fun maxBy(a: Int, b: Int) : Int {
    if(a>b){
        return a
    }else{
        return b
    }
}
// 훨씬 간결한 표현
fun maxBy2(a: Int, b: Int) : Int = if(a>b) a else b

// when: switch와 유사
fun checkNum(score: Int) {
    when(score) {
        0 -> println("this is 0.")
        1 -> println("this is 1.")
        2, 3 -> println("this is 2 or 3")
        else -> println("I don't know") // 생략가능
    }

    // 하지만 다음 경우는 else 필요
    var b: Int = when(score){
        1 -> 1
        2 -> 2
        else -> 3
    }

    print("b: ${b}")

    // 범위 설정 관련
    when(score){
        in 90..100 -> println("You are genius")
        in 10..80 -> println("not bad")
        else -> println("okay")
    }
}

// 5. Array and List
fun array(){
    val array : Array<Int> = arrayOf(1, 2, 3)
    val list : List<Int> = listOf(1, 2, 3)

    val array2 : Array<Any> = arrayOf(1, "d", 3.4f)
    val list2 : List<Any> = listOf(1, "c", 11L)

    // 기본적으로 array는 뮤터블임. 값 변경 가능, 사이즈 변경 불가
    array[0] = 3
    // list 는 기본적으로 Immutable, get만있다. 변경하려면 Mutable list를 사용해야
}
