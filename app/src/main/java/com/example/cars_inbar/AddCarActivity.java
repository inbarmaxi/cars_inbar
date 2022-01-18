package com.example.cars_inbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class AddCarActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText brand = findViewById(R.id.brand);
                EditText model = findViewById(R.id.model);
                EditText year = findViewById(R.id.year);
                EditText price = findViewById(R.id.price);
                int[] photos = {R.drawable.car1,R.drawable.car2,R.drawable.car3,R.drawable.car4,R.drawable.car5,R.drawable.car6,R.drawable.car7,R.drawable.car8};
                Random r = new Random ();

                Car car = new Car(photos[r.nextInt(photos.length)], brand.getText().toString(),model.getText().toString(),year.getText().toString(),price.getText().toString());

                Intent i = new Intent();
                i.putExtra("car",car);
                setResult(1,i);
                finish();



            }
        });

    }
}