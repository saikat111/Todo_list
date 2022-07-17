package com.code.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DataAddActivity extends AppCompatActivity {
    EditText title,text;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_add);
        title = findViewById(R.id.t);
        text = findViewById(R.id.te);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title", title.getText());
                intent.putExtra("text", text.getText());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}