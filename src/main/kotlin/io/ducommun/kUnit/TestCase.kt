package io.ducommun.kUnit

import kotlin.reflect.KFunction
import kotlin.reflect.full.declaredFunctions

abstract class TestCase(val name: String) : TestCaseInterface {

    override fun setup(): Unit {}

    override final fun run(): TestResult {

        setup()

        invokeOnSelf(method = findMethod(name))

        teardown()

        TODO()
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

interface TestCaseInterface {

    fun setup(): Unit

    fun run(): TestResult

    fun teardown(): Unit
}

data class TestResult(val summary: String)