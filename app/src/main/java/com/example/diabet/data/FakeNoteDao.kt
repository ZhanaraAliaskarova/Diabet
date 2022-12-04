package com.example.diabet.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeNoteDao {
    private val noteList = mutableListOf<Note>()
    private val notes = MutableLiveData<List<Note>>()

    init{
        notes.value = noteList
    }

    fun addNote(note: Note){
        noteList.add(note)
        notes.value = noteList
    }

    fun getNotes() = notes as LiveData<List<Note>>
}