package com.example.kmpractice

// 3. companion object

class BookOld private constructor(var id : Int, val name : String){ // 다른 곳에서는 생성 못하게 private으로
}
//class Book private constructor(var id : Int, val name : String){ // 다른 곳에서는 생성 못하게 private으로
//
//    companion object{// private 요소를 읽어오는 기능??
//
//        val myBook = "new book"
//        fun create() : Book = Book(0, myBook)
//    }
//}

// 상속 받는 것도 가능하고 이름을 주어지는것도 가능하다.

class Book private constructor(var id : Int, val name : String){ // 다른 곳에서는 생성 못하게 private으로

    companion object BookFactory : IdProvider{
        override fun getId() : Int {
            return 444
        }
        val myBook = "new book"
        fun create() : Book = Book(getId(), myBook)
    }
}

interface IdProvider {
    fun getId() : Int
}

fun main() {
    //val book = BookOld() // 사용불가

//    val book : Book = Book.Companion.create()
//    println("${book.id} ${book.name}")

    val book : Book = Book.create()
    val bookId : Int = Book.BookFactory.getId()
    println("${book.id} ${book.name}")
}