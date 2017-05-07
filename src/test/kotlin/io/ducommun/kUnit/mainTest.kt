package io.ducommun.kUnit

import org.assertj.core.api.KotlinAssertions.assertThat


fun main(args: Array<String>) {
    TestCaseTest().run()
}

class TestCaseTest : TestCase(name = "it tracks whether the test method was run") {

    fun `it tracks whether the test method was run`() {

        val test = WasRun()

        assertThat(test.wasRun).isFalse()

        test.run()

        assertThat(test.wasRun).isTrue()
    }
}