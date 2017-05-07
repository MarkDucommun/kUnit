package io.ducommun.kUnit

interface TestCaseInterface {

    fun setup(): Unit

    fun run(): TestResult

    fun teardown(): Unit
}
