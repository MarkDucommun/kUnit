package io.ducommun.kUnit

import org.assertj.core.api.KotlinAssertions.assertThat


fun main(args: Array<String>) {

    val suite = TestSuite()

    suite.add(TestCaseTest("it tracks that the correct methods have been called in order"))
    suite.add(TestCaseTest("it reports the number of test cases run"))
    suite.add(TestCaseTest("it formats a failed result properly"))
    suite.add(TestCaseTest("it reports the number of failures in a run accurately"))
    suite.add(TestCaseTest("it catches exceptions in setup"))
    suite.add(TestCaseTest("it can run a suite and report the results"))

    suite.run().summarize()
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

    fun `it can run a suite and report the results`() {

        val suite = TestSuite()

        suite.add(WasRun("testMethod"))
        suite.add(WasRun("testBrokenMethod"))

        val result = suite.run()

        assertThat(result.summary).isEqualTo("2 run, 1 failed")
    }
}