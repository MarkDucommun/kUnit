package io.ducommun.kUnit

import kotlin.reflect.KClass
import kotlin.reflect.full.companionObject
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.primaryConstructor

inline fun <reified T: TestCase> KClass<T>.runTestCase(): TestResult {

    return TestSuite(declaredFunctions.map { function ->

        function.findAnnotation<Test>()?.let { primaryConstructor?.call(function.name) }

    }.filterNotNull()).result
}