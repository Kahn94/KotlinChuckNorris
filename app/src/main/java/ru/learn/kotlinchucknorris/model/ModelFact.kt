package ru.learn.kotlinchucknorris.model

import kotlin.reflect.KProperty

data class ModelFact (
    val type : String,
    val value : ModelValueFact
)

data class ModelValueFact (
    val id : Int,
    val joke : String?,
    val categories : List<String>?
)