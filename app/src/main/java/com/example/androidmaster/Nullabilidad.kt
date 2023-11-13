package com.example.androidmaster

fun main() {
    var name:String? = "Alexis"

    print(name?.get(3) ?: "El valor es nulo")
}