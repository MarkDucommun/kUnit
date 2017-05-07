package io.ducommun.kUnit

import kotlin.reflect.KFunction
import kotlin.reflect.full.declaredFunctions

class WasRun : TestCase(name = "testMethod") {

    private var wasRunPrivate: Boolean = false

    val wasRun: Boolean get() = wasRunPrivate

    fun testMethod(): Unit {
        wasRunPrivate = true
    }
}