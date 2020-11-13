package com.ensim.tp1_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

import com.ensim.tp1_ex1.model.User;

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingText;
    private EditText mNameInput;
    private EditText mLastNameInput;
    private Button mPlayButton;

    boolean EmptyLastName = true;
    boolean EmptyName = true;

    public static String Name;
    public static String LName;

    public User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingText = (TextView) findViewById(R.id.activity_main_greeting_txt);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        mLastNameInput = (EditText) findViewById(R.id.activity_main_lastname_input);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);

        mPlayButton.setEnabled(false);

        mUser = new User();

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EmptyName = !(s.toString().length() != 0);
                Name = new String(s.toString());
                mPlayButton.setEnabled(!EmptyLastName && !EmptyName);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mLastNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EmptyLastName = !(s.toString().length() != 0);
                LName = new String(s.toString());
                mPlayButton.setEnabled(!EmptyLastName && !EmptyName);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ouvrir une pop-up
                //openDialog();
                
                //Ouvrir une activité

                mUser.setName(mNameInput.getText().toString());
                mUser.setLastName(mLastNameInput.getText().toString());

                Intent responseActivity = new Intent(MainActivity.this, ResponseActivity.class);
                responseActivity.putExtra("name", Name);
                responseActivity.putExtra("last_name", LName);

                startActivity(responseActivity);

            }
        });
    }

    public void openDialog(){
        NameDialog nameDialog = new NameDialog();
        nameDialog.show(getSupportFragmentManager(), "example dialog");
    }
}
