package io.ducommun.kUnit

class TestSuite(private val testCases: List<TestCase>) {

    val result: TestResult = testCases.fold(TestResult()) { result, it -> it.run(result) }
}