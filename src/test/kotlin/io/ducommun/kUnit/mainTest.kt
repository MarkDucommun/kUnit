package io.ducommun.kUnit

import org.assertj.core.api.KotlinAssertions.assertThat


fun main(args: Array<String>) {
    TestCaseTest("it tracks that the correct methods have been called in order").run()
    TestCaseTest("it reports the results of the test run").run()
}

class TestCaseTest(name: String) : TestCase(name = name) {

    fun `it tracks that the correct methods have been called in order`() {

        val test = WasRun()

        test.run()

        assertThat(test.log).containsExactly("setup", "testMethod", "teardown")
    }

    fun `it reports the results of the test run`() {

        val test = WasRun()

        val result = test.run()

        assertThat(result.summary).isEqualTo("1 run, 0 failed")
    }
}