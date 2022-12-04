package com.example.diabet.ui.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.diabet.data.NoteRepository

class NotesViewModelFactory(private val noteRepository: NoteRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotesViewModel(noteRepository) as T
    }
}