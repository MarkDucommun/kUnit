package io.ducommun.kUnit

class WasRun {

    private var wasRunPrivate: Boolean = false

    val wasRun: Boolean get() = wasRunPrivate

    fun testMethod(): Unit {
        wasRunPrivate = true
    }
}