package com.example.androidlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail);

        Intent originalIntent = getIntent();
        Bundle params = originalIntent.getExtras();
        if (params != null) {
            TextView titleText = findViewById(R.id.activity_view_title);
            TextView subTitleText = findViewById(R.id.activity_view_subtitle);
            ImageView imageView = findViewById(R.id.activity_view_image);
            titleText.setText(params.getString("title"));
            subTitleText.setText(params.getString("subTitle"));
            imageView.setImageResource(params.getInt("image"));
        }
    }
}