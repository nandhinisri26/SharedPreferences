package com.sonacollegeotechnology.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,age;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        save = findViewById(R.id.save);

        SharedPreferences details = getSharedPreferences("details",MODE_PRIVATE);
        String n = details.getString("name","");
        String a = details.getString("age","");

        if(!TextUtils.isEmpty(n) || !TextUtils.isEmpty(a)){
            name.setText(n);
            age.setText(a);
        }



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(name.getText().toString()) && TextUtils.isEmpty(age.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please fill in the values",Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences details = getSharedPreferences("details",MODE_PRIVATE);
                    SharedPreferences.Editor editor = details.edit();
                    editor.putString("name",name.getText().toString());
                    editor.putString("age",age.getText().toString());
                    editor.apply();
                }
            }
        });

    }
}
