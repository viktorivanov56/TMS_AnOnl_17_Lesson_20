package com.example.tms_an_onl_lesson_19

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteViewHolder (itemView: View, private val listener: OnNoteClickListener):
    RecyclerView.ViewHolder(itemView), View.OnClickListener{
    private val titel: TextView = itemView.findViewById(R.id.title_textview)
    private val text: TextView = itemView.findViewById(R.id.text_textview)
    private val date: TextView = itemView.findViewById(R.id.date_textview)

    init {
        itemView.setOnClickListener(this)
    }
    fun bind(note: Note){
        titel.text = note.title
        text.text = note.text
        date.text = note.date

    }

    override fun onClick(v: View?) {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION){
            listener.onNoteClick(position)
        }
    }
}
