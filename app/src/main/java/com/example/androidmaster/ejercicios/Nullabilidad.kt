package com.example.androidmaster.ejercicios

fun main() {
    var name:String? = "Alexis"

    print(name?.get(3) ?: "El valor es nulo")
}