package com.code.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.code.todolist.databinding.ActivityDataAddBinding;
import com.code.todolist.databinding.ActivityMainBinding;

public class DataAddActivity extends AppCompatActivity {
    ActivityDataAddBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title",binding.t.getText().toString());
                intent.putExtra("text", binding.te.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}