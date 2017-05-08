package io.ducommun.kUnit

interface TestCaseInterface {

    fun setup(): Unit

    fun run(testResult: TestResult = TestResult()): TestResult

    fun teardown(): Unit
}
