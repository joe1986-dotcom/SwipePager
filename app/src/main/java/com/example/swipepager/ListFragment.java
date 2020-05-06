package com.example.swipepager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListFragment extends Fragment {

    private static final String ARG_COUNT ="param1";

    DatabaseHelper databaseHelper = null;
    private SQLiteDatabase db;
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list,container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        WordAdapter wordAdapter = new WordAdapter(readData());
        mRecyclerView.setAdapter(wordAdapter);
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * List形式のフラグメントを返す
     * @param counter フラグメントの管理番号
     * @return 生成したフラグメント
     */
    public static ListFragment newInstance(Integer counter){
        ListFragment fragment = new ListFragment();
        Bundle args= new Bundle();
        args.putInt(ARG_COUNT, counter);
        fragment.setArguments(args);
        return fragment;
    }

    private ArrayList<Word> readData(){

        ArrayList<Word> data = new ArrayList<>();

        if(databaseHelper == null){
            databaseHelper = new DatabaseHelper( getActivity().getApplicationContext());
        }

        if(db == null){
            db = databaseHelper.getReadableDatabase();
        }
        //カーソルを移動して上から順に読み込んでるイメージ。
        Cursor cursor = db.query(
                "word",
                new String[] { "id", "name", "contents","tags" },
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cursor.getCount(); i++) {
            int wordId = cursor.getInt(0);
            String name = cursor.getString(1);
            String contents = cursor.getString(2);
            String tags = cursor.getString(3);

            Word word = new Word(wordId,name,contents,tags);
            data.add(word);

            cursor.moveToNext();
        }

        //カーソルは使ったらクローズを忘れない
        cursor.close();
        return data;
    }
}
