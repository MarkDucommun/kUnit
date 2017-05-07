package io.ducommun.kUnit

class TestResult{

    private var runCountInternal: Int = 0

    val summary: String get() = "$runCountInternal run, 0 failed"

    fun testStarted(): Unit {
        runCountInternal += 1
    }
}