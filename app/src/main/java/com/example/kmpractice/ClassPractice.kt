package com.example.kmpractice


//8. class

//class Human {
//    val name = "joyce"
//    fun eatingCake(){
//        println("This is so Yummy.")
//    }
//}
//
//fun main(){
//    val human = Human()
//    human.eatingCake()
//
//    println("this human's nam is  ${human.name}")
//}

// 생성자를 사용하고 싶은 경우
//class Human constructor(name: String) {
//    val name : String = name
//    fun eatingCake(){
//        println("This is so Yummy.")
//    }
//}

// 다음과 같이 해주는 것이 더 좋다.
//class Human(val name : String = "Anonymous") {
//    fun eatingCake(){
//        println("This is so Yummy.")
//    }
//}

// 초기화 코드블럭 넣기
//class Human(val name : String = "Anonymous") {
//    init { // 주생성자
//        println("New human has been born!!")
//    }
//    fun eatingCake(){
//        println("This is so Yummy.")
//    }
//}

// 부생성자
//class Human(val name : String = "Anonymous") {
//    constructor(name : String, age : Int) : this(name){ // 부생성자
//        println("my name is ${name}, ${age}years old")
//    }
//
//    init { // 주생성자
//        println("New human has been born!!")
//    }
//    fun eatingCake(){
//        println("This is so Yummy.")
//    }
//} // 유의할점. 주생성자 먼저 생성됨

// 클래스 상속
open class Human(val name : String = "Anonymous") {
    constructor(name : String, age : Int) : this(name){
        println("my name is ${name}, ${age}years old")
    }

    init {
        println("New human has been born!!")
    }
    fun eatingCake(){
        println("This is so Yummy.")
    }

    open fun singASong(){
        println("lalala")
    }
}

class Korean : Human() { // 부모 클래스 앞에 오픈이 있어야 상속 가능
    override fun singASong(){
        super.singASong() // 부모함수 까지 사용하기 위해
        println("라라라")

        print("my name is : ${name}")
    }
}

fun main(){
    val human = Human("minsu")
    val stranger = Human()
    human.eatingCake()

    val mom = Human(name = "Kury", age=52)

    println("this human's name is  ${mom.name}")

    val korean = Korean()
    korean.singASong()
}