package com.home.denis.webdevelopmentcheatbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        Intent intent = getIntent();
        int num = intent.getIntExtra("number", 0);

        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/number_" + num + ".html");

    }
}
