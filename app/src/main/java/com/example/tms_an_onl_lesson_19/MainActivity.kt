package com.example.tms_an_onl_lesson_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_an_onl_lesson_19.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity(), OnNoteClickListener {
    private val noteList = ArrayList<Note>()
    private lateinit var adapter: NoteAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NoteAdapter(noteList, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.addButton.setOnClickListener {
            addNote()
        }
    }

    private fun addNote() {

        val title = binding.titleEdittext.text.toString().trim()
        val text = binding.textEdittext.text.toString().trim()
        val date = getCurrentDate()

        if (title.isNotEmpty() && text.isNotEmpty()) {
            val note = Note(title, text, date)
            if (noteList.isEmpty()) {
                noteList.add(note)
                adapter.notifyDataSetChanged()
            } else {
                noteList.add(note)
                adapter.notifyItemInserted(noteList.size - 1)

            }
            binding.titleEdittext.text.clear()
            binding.textEdittext.text.clear()

        } else {
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