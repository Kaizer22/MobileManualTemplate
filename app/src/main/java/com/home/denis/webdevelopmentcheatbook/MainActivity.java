package com.home.denis.webdevelopmentcheatbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArticlesAdapter articlesAdapter = new ArticlesAdapter(this);

        ListView listView = findViewById(R.id.listView);

        listView.setAdapter(articlesAdapter);
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ArticleActivity.class);

                intent.putExtra("number", position);

                startActivity(intent);
            }
        });
    }
}

