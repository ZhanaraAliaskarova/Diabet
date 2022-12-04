package com.example.diabet.data

class NoteRepository private constructor(private val noteDao: FakeNoteDao){

    fun addNote(note: Note){
        noteDao.addNote(note)
    }

    fun getNotes() = noteDao.getNotes()

    companion object{
        @Volatile private var instance: NoteRepository? = null

        fun getInstance(noteDao: FakeNoteDao) =
            instance ?: synchronized(this){
                instance?: NoteRepository(noteDao).also { instance = it }
            }
    }
}