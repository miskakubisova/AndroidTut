package com.example.michaelakubisova.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button goToSecondActivity;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToSecondActivity = findViewById(R.id.go_to_button);
        goToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Message", "Hello from first activity");
                intent.putExtra("SecondMessage", "Hello again");
                intent.putExtra("Value", 123);

                //startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                String result = data.getStringExtra("returnData");
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        }
    }
}
