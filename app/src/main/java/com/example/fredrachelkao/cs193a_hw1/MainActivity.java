package com.example.fredrachelkao.cs193a_hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picknumber();
    }

    private void picknumber() {
        Random rand = new Random();
        num = rand.nextInt((1000 - 1) + 1) + 1;
    }

    public void enterPressed(View view) {
        final EditText curEntered =  (EditText) findViewById(R.id.enteredNum);
        int curNum = Integer.parseInt(curEntered.getText().toString());
        if (curNum > num) {
            ((TextView)findViewById(R.id.hint)).setText("The target number is smaller.");
        } else if (curNum < num) {
            ((TextView)findViewById(R.id.hint)).setText("The target number is larger.");
        } else { //curNum == num
            ((TextView)findViewById(R.id.hint)).setText("You got it right! A new round has started.");
            picknumber();
        }
    }
}

