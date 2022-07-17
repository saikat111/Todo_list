package com.code.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.code.todolist.databinding.ItemBinding;

public class RVAdapter extends ListAdapter<Note,RVAdapter.viewHolder > {
    public RVAdapter(){
        super(CALLBACK);
    }
    private static final DiffUtil.ItemCallback<Note> CALLBACK= new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId()== newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle())
                    && oldItem.getDescription().equals(newItem.getDescription());
        }
    };

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Note note =getItem(position);
        holder.binding.title.setText(note.getTitle());
        holder.binding.text.setText(note.getDescription());
    }
    public Note getNode(int positon){
        return  getItem(positon);
    }

    public class viewHolder extends RecyclerView.ViewHolder{
         ItemBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemBinding.bind(itemView);
        }
    }
}
