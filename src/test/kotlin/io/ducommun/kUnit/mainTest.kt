package io.ducommun.kUnit

import org.assertj.core.api.KotlinAssertions.assertThat


fun main(args: Array<String>) {
    TestCaseTest("it tracks whether the setup method was run").run()
    TestCaseTest("it tracks whether the test method was run").run()
}

class TestCaseTest(name: String) : TestCase(name = name) {

    fun `it tracks whether the setup method was run`() {

        val test = WasRun()

        assertThat(test.wasSetup).isFalse()

        test.run()

        assertThat(test.wasSetup).isTrue()
    }

    fun `it tracks whether the test method was run`() {

        val test = WasRun()

        assertThat(test.wasRun).isFalse()

        test.run()

        assertThat(test.wasRun).isTrue()
    }
}

class Test