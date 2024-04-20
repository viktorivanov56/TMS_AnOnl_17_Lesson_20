package com.example.tms_an_onl_lesson_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity(), OnNoteClickListener {
    private val noteList = ArrayList<Note>()
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        adapter = NoteAdapter(noteList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val addButton: Button = findViewById(R.id.add_button)
        addButton.setOnClickListener {
            addNote()
        }
    }

    private fun addNote() {
        val titelEditText: EditText = findViewById(R.id.title_edittext)
        val textEditText: EditText = findViewById(R.id.text_edittext)

        val title = titelEditText.text.toString().trim()
        val text = titelEditText.text.toString().trim()
        val  date = getCurrentDate()

        if (title.isNotEmpty() && text.isNotEmpty()){
            val note = Note(title, text, date)
            if (noteList.isEmpty()) {
                noteList.add(note)
                adapter.notifyDataSetChanged()
            } else {
                noteList.add(note)
                adapter.notifyItemInserted(noteList.size - 1)

            }
            titelEditText.text.clear()
            textEditText.text.clear()

        }else{
            Toast.makeText(this, "Поля пустые! Заполните", Toast.LENGTH_SHORT).show()
        }

    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
            return dateFormat.format(Date())


    }

    override fun onNoteClick(position: Int) {
        val note = noteList[position]
        Toast.makeText(this, "Заметка: ${note.title}", Toast.LENGTH_SHORT).show()
    }
}