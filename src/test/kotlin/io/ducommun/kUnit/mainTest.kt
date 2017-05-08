package io.ducommun.kUnit

import org.assertj.core.api.KotlinAssertions.assertThat


fun main(args: Array<String>) {
    TestCaseTest("it tracks that the correct methods have been called in order").run().summarize()
    TestCaseTest("it reports the number of test cases run").run().summarize()
    TestCaseTest("it formats a failed result properly").run().summarize()
    TestCaseTest("it reports the number of failures in a run accurately").run().summarize()
    TestCaseTest("it catches exceptions in setup").run().summarize()
}

fun TestResult.summarize() = println(summary)

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

    fun `it catches exceptions in setup`() {

        val test = BrokenSetup()

        val result = test.run()

        assertThat(result.summary).isEqualTo("1 run, 1 failed")
    }
}