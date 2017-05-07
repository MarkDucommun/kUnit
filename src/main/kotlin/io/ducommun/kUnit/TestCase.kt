package io.ducommun.kUnit

import kotlin.reflect.KFunction
import kotlin.reflect.full.declaredFunctions

abstract class TestCase(val name: String) : TestCaseInterface {

    override fun setup(): Unit {}

    override final fun run(): TestResult {

        val result = TestResult()

        setup()

        result.testStarted()

        try {
            invokeOnSelf(method = findMethod(name))
        } catch (e: Exception) {
            result.testFailed()
        }

        teardown()

        return result
    }

    override fun teardown() {}

    private fun invokeOnSelf(method: KFunction<*>): Unit {
        method.call(this)
    }

    private fun findMethod(name: String): KFunction<*> {
        return this::class
                .declaredFunctions
                .find { it.name == name }
                ?: throw RuntimeException("No method matching '$name' found")
    }
}