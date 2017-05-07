package io.ducommun.kUnit

fun main(args: Array<String>) {

    val test = WasRun()

    // Should print false
    println(test.wasRun)

    test.testMethod()

    // Should print true
    println(test.wasRun)
}
