package com.example.diabet.data

data class Note(val noteText: String, val symptoms: String ) {
    override fun toString(): String {
        return "$noteText = $symptoms"
    }
}