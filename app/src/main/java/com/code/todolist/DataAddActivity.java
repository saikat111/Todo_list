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
        binding.submit.setBackgroundColor(0xFFFF0000);
        String type = getIntent().getStringExtra("type");

        if(type.equals("update")){
            setTitle("Update Note");
            String title = getIntent().getStringExtra("title");
            String text = getIntent().getStringExtra("text");
            binding.t.setText(title);
            binding.te.setText(text);
            int id = getIntent().getIntExtra("id",0);
            binding.submit.setText("Update note");
            binding.submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title",binding.t.getText().toString());
                    intent.putExtra("text", binding.te.getText().toString());
                    intent.putExtra("id",id);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            });
        }
        else{
            setTitle("Add Note");
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataAddActivity.this,MainActivity.class));
    }
}