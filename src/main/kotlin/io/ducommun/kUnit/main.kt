package io.ducommun.kUnit

import kotlin.reflect.KFunction
import kotlin.reflect.full.declaredFunctions

class WasRun(val name: String) {

    private var wasRunPrivate: Boolean = false

    val wasRun: Boolean get() = wasRunPrivate

    fun testMethod(): Unit {
        wasRunPrivate = true
    }

    fun run(): Unit {
        invokeOnSelf(method = findMethod(name))
    }

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