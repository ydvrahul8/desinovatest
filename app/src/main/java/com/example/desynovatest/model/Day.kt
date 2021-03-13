package com.example.desynovatest.model

data class Day(
    val index: Int,
    val inprogress: Int,
    val name: String,
    val pending: Int,
    val processed: Int,
    val total: Int,
    val value: String
)