package io.ducommun.kUnit

import org.assertj.core.api.KotlinAssertions

class DummyTestCase(name: String): TestCase(name = name) {

    @Test
    fun working() { KotlinAssertions.assertThat(true).isTrue() }

    @Test
    fun failing() { throw RuntimeException() }
}
