package me.codeninja55.learningkotlin.kotlin

import me.codeninja55.learningkotlin.kotlin.ex1.Person

fun main(args: Array<String>) {
    var x: Int = 0

    println("While loop")
    while (x < 10) {
        print("${x++} ")
    }
    println()

    val people = ArrayList<Person>()
    people.add(Person("Mr", "Tony", "Stark", null))
    people.add(Person("Ms", "Natasha", "Romanoff", null))
    people.add(Person("Mr", "Steve", "Rogers", null))
    people.add(Person("Mr", "Peter", "Parker", null))

    println("Looping with range")
    for (i in 0..9) print("$i ")
    println()

    println("Lambda range")
    (0..9).forEach { i -> print("$i ") }
    println()

    println("Reverse lambda range")
    (9 downTo 0).forEach { i -> print("$i ")  }
    println()

    println("Looping internally with iterable")
    for (p: Person in people) {
        println("${p.id} : $p")
    }

    val colors: Array<String> = arrayOf("Red", "Black", "Blue", "Green")

    val peopleMap = HashMap<Int, Person>()
    for (p in people) {
        p.favouriteColor = colors[p.id.toInt() - 1]
        peopleMap[p.id.toInt()] = p
    }

    println("Looping with destructuring")
    // Destructuring in for-loop
    for ( (title, firstName, surname, _, id, age, favColor) in people) {
        println("$id : $title $firstName $surname is $age years old and has a favourite color $favColor")
    }

    println("Looping a map")
    for ( (key, value) in peopleMap) {
        println("$key => $value")
    }
}