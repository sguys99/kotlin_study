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

    forAndWhile()

    nullcheck()

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
    var result = list2.get(0)

    // 뮤터블 리스트를 만들어보자.
    var arrayList : ArrayList<Int> = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
    arrayList[0] = 20
}

// 6. 반복문: for, while

fun forAndWhile(){
    val students: ArrayList<String> = arrayListOf("joyce", "james", "jenny", "jennifer")

    for (name: String in students){
        println("${name}")
    }

    var sum: Int = 0
    for (i: Int in 1..10){
        sum += i
    }
    println(sum)

    var stepSum: Int = 0
    for (i: Int in 1..10 step 2){
        stepSum += i
    }
    println(stepSum)

    var downSum: Int = 0
    for (i: Int in 10 downTo 1){
        downSum += i
    }
    println(downSum)

    var untilSum: Int = 0
    for (i: Int in 1 until 10){ // 100을 포함하지 않는다.
        untilSum += i
    }
    println(untilSum)

    var index =0

    while(index < 10){
        println("current index: ${index}")
        index++
    }

    // index와 함께 array list 사용하기
    for ((index: Int, name: String) in students.withIndex()){
        println("${index+1}번째 학생 : ${name}")
    }
}

// 7. Nullable/ NonNull
fun nullcheck(){
    // NPE: Null pointer Exception

    var name: String = "Joyce" // string은 Nonnull type이다
    //var nullName: String = null
    var nullName: String? = null //  널타입을 사용하려면 ?를 추가하면 됨. 따라서 타입을 추가해야한다.

    // 다음의 경우 논널 타입만 사용가능
    var nameInUpperCase: String = name.uppercase()

    //var nullNameInUpperCase: String? = nullName.uppercase() 불가
    // 다음과 같이 수정해야함. 널이 아니면 uppercase로 널이면 널을 반환하라는 의미
    var nullNameInUpperCase: String? = nullName?.uppercase()

    // 엘비스 프레슬리 연산자
    // ?:
    val lastName: String? = null
    val fullName = name + " " + (lastName?: "No lastName")
    println(fullName)

    //!! 연산자
    // 컴파일에게 널이 아니라고 명시해주는것

}

// !! 연산자 예시
fun ignoreNulls(str : String?){
    val mNotNull : String = str!! // 개발자가 절대 null이 아님을 컴파일러에게 명시

    val upper : String = mNotNull.uppercase() // 이후 코딩에서는 ? 사용하지 않아도 됨

// let함수
    val email : String = "joycehongXXXX@nana.vom"
    email?.let{// 널이 아니면 수행
        println("my email is ${email}")
    }
}