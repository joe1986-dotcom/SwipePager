package com.example.swipepager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class WordActivity extends AppCompatActivity {


    private int wordId = -1;
    DatabaseHelper databaseHelper = null;
    private SQLiteDatabase db;

    private Button buttonRegistory;
    private Button buttonUnregistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        buttonRegistory = findViewById(R.id.favoriteButtonRegistory);
        buttonUnregistory = findViewById(R.id.favoriteButtonUnregister);

        // データを取得して画面にセット
        setData();



        buttonRegistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // db取得
                if(databaseHelper == null){
                    databaseHelper = new DatabaseHelper( getApplicationContext());
                }

                if(db == null){
                    db = databaseHelper.getReadableDatabase();
                }
                db.execSQL("INSERT INTO " + "favorite(wordId)" + "" + " VALUES("+ wordId + ");");
                // 登録ボタン非表示
                buttonRegistory.setVisibility(View.INVISIBLE);
                // 解除ボタン表示
                buttonUnregistory.setVisibility(View.VISIBLE);
            }
        });
        buttonUnregistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // db取得
                if(databaseHelper == null){
                    databaseHelper = new DatabaseHelper( getApplicationContext());
                }

                if(db == null){
                    db = databaseHelper.getReadableDatabase();
                }
                db.execSQL(" DeLETE FROM "  + " favorite " + " WHERE wordId = " + wordId + ";");
                // 登録ボタン表示
                buttonRegistory.setVisibility(View.VISIBLE);
                // 解除ボタン非表示
                buttonUnregistory.setVisibility(View.INVISIBLE);
            }
        });
    }
    private void setData(){
        // view get
        TextView word_name = findViewById(R.id.name);
        TextView word_contents = findViewById(R.id.contents);
        TextView word_job = findViewById(R.id.job);
        TextView word_tags = findViewById(R.id.tags);

        // data get
        wordId = getIntent().getExtras().getInt("id");
        String name = getIntent().getExtras().getString("name");
        String contents = getIntent().getExtras().getString("contents");
        String job = getIntent().getExtras().getString("job");
        String tags = getIntent().getExtras().getString("tags");

        // data set
        word_name.setText(name);
        word_contents.setText(contents);
        word_job.setText(job);
        word_tags.setText(tags);

        // button set
        if(databaseHelper == null){
            databaseHelper = new DatabaseHelper( getApplicationContext());
        }

        if(db == null){
            db = databaseHelper.getReadableDatabase();
        }

        ArrayList<Favorite> data = new ArrayList<Favorite>();

        Cursor cursor = db.query(
                "favorite",
                new String[]{"id", "wordId"},
                null,
                null,
                null,
                null,
                null
        );

        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            int id = cursor.getInt(0);
            int wordId = cursor.getInt(1);


            Favorite favorite = new Favorite(id, wordId);
            data.add(favorite);

            cursor.moveToNext();

        }
        //カーソルは使ったらクローズを忘れない
        cursor.close();


        boolean buttonFlg = false;

        for(int i = 0; i < data.size(); i++){
            if(data.get(i).getWordId() == wordId){
                buttonFlg = true;
            }
        }

        if(buttonFlg){
            buttonUnregistory.setVisibility(View.VISIBLE);
            buttonRegistory.setVisibility(View.INVISIBLE);
        }
        else{
            buttonUnregistory.setVisibility(View.INVISIBLE);
            buttonRegistory.setVisibility(View.VISIBLE);
        }
    }
}
