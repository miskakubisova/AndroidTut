package com.example.michaelakubisova.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView showMessage;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();

        showMessage = findViewById(R.id.textView);

        if(extras != null){
            String message = (String) extras.get("Message");

            showMessage.setText(message);
        }

        backButton = findViewById(R.id.button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData", "From Second Activity");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
