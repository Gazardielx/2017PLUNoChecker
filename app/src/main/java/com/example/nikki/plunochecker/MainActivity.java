package com.example.nikki.plunochecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewAdd = (TextView) findViewById(R.id.textViewAdd);
        TextView textViewSearch = (TextView) findViewById(R.id.textViewSearch);

        textViewAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this , AddActivity.class);
                startActivity(intent);
            }
        });

        textViewSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this , SearchActivity.class);
                startActivity(intent);
            }
        });

    }
}
