package io.ducommun.kUnit

class TestResult{

    private var runCountInternal: Int = 0
    private var failureCountInternal: Int = 0

    val summary: String get() = "$runCountInternal run, $failureCountInternal failed"

    fun testStarted(): Unit {
        runCountInternal += 1
    }

    fun testFailed(): Unit {
        failureCountInternal += 1
    }
}