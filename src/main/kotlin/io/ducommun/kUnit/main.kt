package io.ducommun.kUnit

class WasRun(var wasRun: Boolean = false) {

    fun testMethod(): Unit {
        wasRun = true
    }
}