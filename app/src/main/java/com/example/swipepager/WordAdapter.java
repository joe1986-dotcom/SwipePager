package com.example.swipepager;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * RecyclerViewとWordをつなげる
 * RecyclerViewが何のデータを保持しているかも記述
 */
public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private ArrayList<Word> mWordList;

    public WordAdapter(ArrayList<Word> mWordList) {
        this.mWordList = mWordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_item,parent, false);
        WordViewHolder wordViewHolder = new WordViewHolder(itemView);

        return wordViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.name.setText(mWordList.get(position).getName());
        holder.contents.setText(mWordList.get(position).getContents());
    }

    @Override
    public int getItemCount() {
        return mWordList == null ? 0 : mWordList.size();
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder{
        TextView name,contents;
        LinearLayout view_container;

    public WordViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        contents = itemView.findViewById(R.id.contents);
        view_container = itemView.findViewById(R.id.container);
    }
}

}

