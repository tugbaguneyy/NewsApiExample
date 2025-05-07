package com.example.newsapiexample.utils

import java.text.SimpleDateFormat
import java.util.*

fun String.formatDate(): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
        outputFormat.format(inputFormat.parse(this) ?: Date())
    } catch (e: Exception) {
        this
    }
}

fun String.cleanContent(): String {
    return this.replace(Regex("\\s*\\[\\+\\d+ chars\\]\\s*$"), "...")
}