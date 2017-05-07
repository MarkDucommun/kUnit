package io.ducommun.kUnit

import kotlin.reflect.full.declaredFunctions

class WasRun(val name: String) {

    private var wasRunPrivate: Boolean = false

    val wasRun: Boolean get() = wasRunPrivate

    fun testMethod(): Unit {
        wasRunPrivate = true
    }

    fun run(): Unit {
        this::class
                .declaredFunctions
                .find { it.name == name }
                ?.call(this)
                ?: throw RuntimeException("No method matching '$name' found")
    }
}