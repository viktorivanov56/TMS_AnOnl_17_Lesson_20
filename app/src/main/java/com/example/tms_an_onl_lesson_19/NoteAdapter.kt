package com.example.tms_an_onl_lesson_19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_an_onl_lesson_19.databinding.ItemNoteBinding

class NoteAdapter(private val noteList: List<Note>, private val listener: OnNoteClickListener):
 RecyclerView.Adapter<NoteViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNoteBinding.inflate(inflater,parent,false)
        return NoteViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = noteList[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

}
