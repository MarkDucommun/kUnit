package io.ducommun.kUnit

import kotlin.reflect.KClass
import kotlin.reflect.full.companionObject
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.primaryConstructor

inline fun <reified T: TestCase> KClass<T>.runTestCase(): TestResult {

    val suite = TestSuite()

    declaredFunctions.map { function ->

        function.findAnnotation<Test>()?.let {

            val instance = primaryConstructor?.call(function.name) ?: throw RuntimeException("No constructor?")

            suite.add(instance)
        }
    }

    return suite.run()
}