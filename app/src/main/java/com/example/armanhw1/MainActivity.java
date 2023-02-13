package com.example.armanhw1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        TextView result = findViewById(R.id.result);
        TextInputLayout input = findViewById(R.id.numberInput);

        button.setOnClickListener(v -> {
            String inputtedText = input.getEditText().getText().toString();
            result.setText(Helper.integerToEnglish(inputtedText));
        });
    }
}
