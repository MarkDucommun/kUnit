package io.ducommun.kUnit

class WasRun(name: String = "testMethod") : TestCase(name = name) {

    private var logInternal: List<String> = emptyList()

    val log: List<String> get() = logInternal

    override fun setup(): Unit {
        logInternal += "setup"
    }

    fun testMethod(): Unit {
        logInternal += "testMethod"
    }

    fun testBrokenMethod(): Unit {
        throw RuntimeException()
    }

    override fun teardown() {
        logInternal += "teardown"
    }
}