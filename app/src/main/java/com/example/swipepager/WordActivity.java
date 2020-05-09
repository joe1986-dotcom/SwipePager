package com.example.swipepager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        // データを取得して画面にセット
        setData();

    }
    private void setData(){
        // view get
        TextView word_name = findViewById(R.id.name);
        TextView word_contents = findViewById(R.id.contents);
        TextView word_job = findViewById(R.id.job);
        TextView word_tags = findViewById(R.id.tags);

        // data get
        int id = getIntent().getExtras().getInt("id");
        String name = getIntent().getExtras().getString("name");
        String contents = getIntent().getExtras().getString("contents");
        String job = getIntent().getExtras().getString("job");
        String tags = getIntent().getExtras().getString("tags");

        // data set
        word_name.setText(name);
        word_contents.setText(contents);
        word_job.setText(job);
        word_tags.setText(tags);
    }
}
