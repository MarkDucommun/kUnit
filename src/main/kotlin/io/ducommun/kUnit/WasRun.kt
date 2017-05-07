package io.ducommun.kUnit

class WasRun : TestCase(name = "testMethod") {

    private var logInternal: List<String> = emptyList()

    val log: List<String> get() = logInternal

    override fun setup(): Unit {
        logInternal += "setup"
    }

    fun testMethod(): Unit {
        logInternal += "testMethod"
    }
}