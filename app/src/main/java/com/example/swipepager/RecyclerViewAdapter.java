package com.example.swipepager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Word> mWordList;
    private LayoutInflater mInflater;
    private ViewPager2 viewPager2;


    private int[] colorArray = new int[]{android.R.color.black, android.R.color.holo_blue_dark, android.R.color.holo_green_dark, android.R.color.holo_red_dark};

    RecyclerViewAdapter(Context context, ArrayList<Word> wordList, ViewPager2 viewPager2) {
        this.mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
        this.viewPager2 = viewPager2;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.view_pager, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Word targetWord = mWordList.get(position);

        holder.textViewName.setText(targetWord.getName());
        holder.textViewContents.setText(targetWord.getContents());
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewContents;

        LinearLayout linearLayout;

        ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.name);
            textViewContents = itemView.findViewById(R.id.contents);
            linearLayout = itemView.findViewById(R.id.container);
        }
    }
}

