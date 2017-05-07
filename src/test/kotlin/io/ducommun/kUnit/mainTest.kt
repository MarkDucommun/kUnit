package io.ducommun.kUnit

fun main(args: Array<String>) {
    TestCaseTest().run()
}

class TestCaseTest : TestCase(name = "it tracks whether the test method was run") {

    fun `it tracks whether the test method was run`() {
        val test = WasRun()

        // Should print false
        println(test.wasRun)

        test.run()

        // Should print true
        println(test.wasRun)
    }
}