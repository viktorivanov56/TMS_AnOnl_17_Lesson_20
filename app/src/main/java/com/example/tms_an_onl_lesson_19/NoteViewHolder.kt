package com.example.tms_an_onl_lesson_19

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_an_onl_lesson_19.databinding.ItemNoteBinding

class NoteViewHolder (private val binding: ItemNoteBinding, private val listener: OnNoteClickListener):
    RecyclerView.ViewHolder(binding.root), View.OnClickListener{

    init {
        binding.root.setOnClickListener(this)
    }
    fun bind(note: Note){
        binding.titleTextview.text = note.title
        binding.textTextview.text = note.text
        binding.dateTextview.text = note.date

    }

    override fun onClick(v: View?) {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION){
            listener.onNoteClick(position)
        }
    }
}
