package com.example.architecturecomp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architecturecomp.databinding.NoteItemBinding;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();
    private NoteItemBinding noteItemBinding;

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        noteItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),R.layout.note_item,parent, false
        );
        NoteHolder noteHolder = new NoteHolder(noteItemBinding);
        return noteHolder;
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.note_item, parent, false);
//        return new NoteHolder();
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        if(notes != null) {
            Note currentNote = notes.get(position);
            holder. noteItemBinding.setNote(currentNote);

//            holder.textViewTitle.setText(currentNote.getTitle());
//            holder.textViewDescription.setText(currentNote.getDescription());
//            holder.textViewDescription.setText(Integer.toString(currentNote.getPriority()));
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes){
        this.notes = notes;
        notifyDataSetChanged();

    }

    class NoteHolder extends RecyclerView.ViewHolder{
        NoteItemBinding noteItemBinding;
//        private TextView textViewTitle;
//        private TextView textViewDescription;
//        private TextView textViewPriority;

        public NoteHolder(@NonNull NoteItemBinding itemView) {
            super(itemView.getRoot());
            noteItemBinding = itemView;
//            textViewTitle = itemView.findViewById(R.id.text_view_title);
//            textViewDescription = itemView.findViewById(R.id.text_view_description);
//            textViewPriority= itemView.findViewById(R.id.text_view_priority);
        }
    }
}
