package io.ducommun.kUnit

fun main(args: Array<String>) {

    val test = WasRun("testMethod")

    // Should print false
    println(test.wasRun)

    test.run()

    // Should print true
    println(test.wasRun)
}
