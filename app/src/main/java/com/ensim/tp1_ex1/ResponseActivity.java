package com.ensim.tp1_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResponseActivity extends AppCompatActivity {

    private TextView mNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        mNameText = (TextView) findViewById(R.id.activity_response_name_text);
        Intent intent = getIntent();
        String nameTxt = intent.getStringExtra("name");
        String lastNameTxt = intent.getStringExtra("last_name");
        mNameText.setText(nameTxt + " " + lastNameTxt);


    }
}
