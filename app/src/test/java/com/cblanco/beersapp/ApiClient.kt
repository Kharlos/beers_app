package com.cblanco.beersapp

import kotlin.reflect.KAnnotatedElement
import kotlin.reflect.KClass

interface ApiClient {
    fun <T : Any, R : KAnnotatedElement> create(
        service: KClass<T>,
        method: R
    ): T

}