package com.example.diabet.data

class FakeDatabase private constructor() {

    var noteDao = FakeNoteDao()
    private set

    companion object{
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(this){
                instance?: FakeDatabase().also { instance = it }
            }
    }
}