package io.ducommun.kUnit

import org.assertj.core.api.KotlinAssertions.assertThat


fun main(args: Array<String>) {

    TestCaseTest::class.runTestCase().summarize()
}

fun TestResult.summarize() = println(summary)

class TestCaseTest(name: String) : TestCase(name = name) {

    @Test
    fun `it tracks that the correct methods have been called in order`() {

        val test = WasRun()

        test.run()

        assertThat(test.log).containsExactly("setup", "testMethod", "teardown")
    }

    @Test
    fun `it reports the number of test cases run`() {

        val test = WasRun()

        val result = test.run()

        assertThat(result.summary).isEqualTo("1 run, 0 failed")
    }

    @Test
    fun `it reports the number of failures in a run accurately`() {

        val test = WasRun(name = "testBrokenMethod")

        val result = test.run()

        assertThat(result.summary).isEqualTo("1 run, 1 failed")
    }

    @Test
    fun `it formats a failed result properly`() {

        val result = TestResult()

        result.testStarted()

        result.testFailed()

        assertThat(result.summary).isEqualTo("1 run, 1 failed")
    }

    @Test
    fun `it catches exceptions in setup`() {

        val test = BrokenSetup()

        val result = test.run()

        assertThat(result.summary).isEqualTo("1 run, 1 failed")
    }

    @Test
    fun `it can run a suite and report the results`() {

        val suite = TestSuite(listOf(
                WasRun("testMethod"),
                WasRun("testBrokenMethod")
        ))

        assertThat(suite.result.summary).isEqualTo("2 run, 1 failed")
    }

    @Test
    fun `it can populate a suite automatically using Test annotations`() {

        val result = DummyTestCase::class.runTestCase()

        assertThat(result.summary).isEqualTo("2 run, 1 failed")
    }
}