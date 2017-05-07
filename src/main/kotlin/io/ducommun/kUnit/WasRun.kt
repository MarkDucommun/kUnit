package io.ducommun.kUnit

class WasRun : TestCase(name = "testMethod") {

    private var wasSetupPrivate: Boolean = false
    private var wasRunPrivate: Boolean = false

    val wasSetup: Boolean get() = wasSetupPrivate
    val wasRun: Boolean get() = wasRunPrivate

    override fun setup(): Unit {
        wasSetupPrivate = true
    }

    fun testMethod(): Unit {
        wasRunPrivate = true
    }
}