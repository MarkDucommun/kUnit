package io.ducommun.kUnit

import org.assertj.core.api.KotlinAssertions.assertThat


fun main(args: Array<String>) {
    TestCaseTest("it tracks that the correct methods have been called in order").run()
    TestCaseTest("it reports the number of test cases run").run()
    TestCaseTest("it formats a failed result properly").run()
    TestCaseTest("it reports the number of failures in a run accurately").run()
}

class TestCaseTest(name: String) : TestCase(name = name) {

    fun `it tracks that the correct methods have been called in order`() {

        val test = WasRun()

        test.run()

        assertThat(test.log).containsExactly("setup", "testMethod", "teardown")
    }

    fun `it reports the number of test cases run`() {

        val test = WasRun()

        val result = test.run()

        assertThat(result.summary).isEqualTo("1 run, 0 failed")
    }

    fun `it reports the number of failures in a run accurately`() {

        val test = WasRun(name = "testBrokenMethod")

        val result = test.run()

        assertThat(result.summary).isEqualTo("1 run, 1 failed")
    }

    fun `it formats a failed result properly`() {

        val result = TestResult()

        result.testStarted()

        result.testFailed()

        assertThat(result.summary).isEqualTo("1 run, 1 failed")
    }
}