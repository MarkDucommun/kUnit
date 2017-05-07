package io.ducommun.kUnit

import org.assertj.core.api.KotlinAssertions.assertThat


fun main(args: Array<String>) {
    TestCaseTest("it tracks that the correct methods have been called in order").run()
}

class TestCaseTest(name: String) : TestCase(name = name) {

    fun `it tracks that the correct methods have been called in order`() {

        val test = WasRun()

        test.run()

        assertThat(test.log).containsExactly("setup", "testMethod")
    }
}