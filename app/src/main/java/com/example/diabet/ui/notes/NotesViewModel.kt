package com.example.diabet.ui.notes

import androidx.lifecycle.ViewModel
import com.example.diabet.data.Note
import com.example.diabet.data.NoteRepository

class NotesViewModel(private val noteRepository: NoteRepository): ViewModel() {

    fun getNotes() = noteRepository.getNotes()

    fun addNote(note: Note) = noteRepository.addNote(note)
}