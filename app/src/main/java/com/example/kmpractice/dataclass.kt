package com.example.kmpractice

// 2. 데이터 클래스
data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int)
// 데이터클래스를 사용하면 toString(), hashCode(), equals(), copy() 함수 등이 자동으로 만들어진다. 편하다.

class TicketNormal(val companyName : String, val name : String, var date : String, var seatNumber : Int)

fun main() {
    val ticketA = Ticket(companyName = "koreanAir", name = "joiceHong", date="2020-02-16", seatNumber = 14)
    val ticketB = TicketNormal(companyName = "koreanAir", name = "joiceHong", date="2020-02-16", seatNumber = 14)

    println(ticketA) // 데이터를 확인하기 편하다.
    println(ticketB)
}