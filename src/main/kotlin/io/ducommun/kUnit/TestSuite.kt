package io.ducommun.kUnit

class TestSuite {

    var testCases: List<TestCase> = emptyList()

    fun add(case: TestCase): Unit { testCases += case }

    fun run(): TestResult = testCases.fold(TestResult()) { result, it -> it.run(result) }
}