package io.ducommun.kUnit

class BrokenSetup : TestCase(name = "method") {

    override fun setup(): Unit {
        throw RuntimeException()
    }

    fun method(): Unit {}
}