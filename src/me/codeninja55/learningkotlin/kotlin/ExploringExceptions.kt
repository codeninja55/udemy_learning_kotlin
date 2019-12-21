package me.codeninja55.learningkotlin.kotlin

import java.io.FileInputStream
import java.lang.Exception

@Throws(InterruptedException::class)
fun divide(a: Int, b: Int) : Double {
    Thread.sleep(1000)
    return (a.toDouble() / b)
}

fun printFile() : Unit {
    val input = FileInputStream("file.txt")
    input.use {
        // Try with resources
        // Similar to try(resources...) in Java or
        // with open() as f: in Python
        // Automatically closes the stream
    }
}

fun main(args: Array<String>) {
    val result = try {
        divide(25, 5)
    } catch (e: Exception) {
        0
    }

    println(result)
}