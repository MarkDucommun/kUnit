package io.ducommun.kUnit

import kotlin.reflect.KFunction
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.primaryConstructor

abstract class TestCase(val name: String) : TestCaseInterface {

    override fun setup(): Unit {}

    override final fun run(result: TestResult): TestResult {

        result.testStarted()

        try {
            setup()
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