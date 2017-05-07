package io.ducommun.kUnit

class WasRun : TestCase(name = "testMethod") {

    private var wasRunPrivate: Boolean = false

    val wasRun: Boolean get() = wasRunPrivate
    val wasSetup: Boolean get() = false

    fun testMethod(): Unit {
        wasRunPrivate = true
    }
}