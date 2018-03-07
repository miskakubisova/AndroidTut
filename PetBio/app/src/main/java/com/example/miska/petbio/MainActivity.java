package com.example.miska.petbio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView catView;
    private ImageView dogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catView = findViewById(R.id.catId);
        dogView = findViewById(R.id.dogId);

        catView.setOnClickListener(this);
        dogView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.catId:
                //Toast.makeText(MainActivity.this, "Cat touched", Toast.LENGTH_LONG).show();
                Intent catIntent = new Intent(MainActivity.this, BioActivity.class);
                catIntent.putExtra("name", "Jarvis");
                catIntent.putExtra("bio", "Great cat. Loves people and meows a lot.");
                startActivity(catIntent);
                break;
            case R.id.dogId:
                //Toast.makeText(MainActivity.this, "Dog touched", Toast.LENGTH_LONG).show();
                Intent dogIntent = new Intent(MainActivity.this, BioActivity.class);
                dogIntent.putExtra("name", "Hufky");
                dogIntent.putExtra("bio", "Great dog. Loves people and barks adn eats a lot.");
                startActivity(dogIntent);
                break;
        }
    }
}
