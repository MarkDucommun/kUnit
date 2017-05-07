package io.ducommun.kUnit

class WasRun : TestCase(name = "testMethod") {

    private var wasSetupInternal: Boolean = true
    private var wasRunInternal: Boolean = false
    private var logInternal: List<String> = listOf("setup")

    val wasSetup: Boolean get() = wasSetupInternal
    val wasRun: Boolean get() = wasRunInternal
    val log: List<String> get() = logInternal

    override fun setup(): Unit {
        wasSetupInternal = true
    }

    fun testMethod(): Unit {
        wasRunInternal = true
    }
}