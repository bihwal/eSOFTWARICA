package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {

    EditText word, meaning;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        word = findViewById(R.id.etWord);
        meaning = findViewById(R.id.etMeaning);
        add = findViewById(R.id.btnAddWord);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    PrintStream printStream=new PrintStream(openFileOutput("words.txt",MODE_PRIVATE|MODE_APPEND));
                    printStream.println(word.getText().toString()+"->"+meaning.getText().toString());
                    Toast.makeText(MainActivity.this, "saved to "+getFilesDir(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Log.d("Dictionary app","Error"+e.toString());
                    e.printStackTrace();
                }
            }
        });
    }
}