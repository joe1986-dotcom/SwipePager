package com.example.swipepager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper = null;
    private SQLiteDatabase db;
    private ArrayList<Word> wordList = new ArrayList<Word>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        readData();
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, wordList, viewPager);
        viewPager.setAdapter(recyclerViewAdapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText("OBJECT" + (position + 1))
        ).attach();
    }

    private void readData(){
        if(databaseHelper == null){
            databaseHelper = new DatabaseHelper(getApplicationContext());
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
            wordList.add(word);

            cursor.moveToNext();
        }

        //カーソルは使ったらクローズを忘れない
        cursor.close();
    }
}
