package com.example.diabet.utilities

import com.example.diabet.data.FakeDatabase
import com.example.diabet.data.NoteRepository
import com.example.diabet.ui.notes.NotesViewModelFactory

object InjectorUtils {

    fun provideNotesViewModelFactory(): NotesViewModelFactory{
        val noteRepository = NoteRepository.getInstance(FakeDatabase.getInstance().noteDao)
        return NotesViewModelFactory(noteRepository)
    }
}