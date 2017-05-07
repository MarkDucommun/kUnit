package io.ducommun.kUnit

import org.assertj.core.api.KotlinAssertions.assertThat


fun main(args: Array<String>) {
    TestCaseTest("it tracks whether the setup method was run").run()
    TestCaseTest("it tracks whether the test method was run").run()
}

class TestCaseTest(name: String) : TestCase(name = name) {

    lateinit var test: WasRun

    override fun setup() {
        test = WasRun()
    }

    fun `it tracks whether the setup method was run`() {

        test.run()

        assertThat(test.log).containsExactly("setup")
    }

    fun `it tracks whether the test method was run`() {

        assertThat(test.wasRun).isFalse()

        test.run()

        assertThat(test.wasRun).isTrue()
    }
}

class Test