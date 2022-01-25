package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Switch;

@SuppressLint("UseSwitchCompatOrMaterialCode")
public class ModoNoche extends AppCompatActivity {
    Handler handler = new Handler();
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_noche);
        aSwitch = findViewById(R.id.switch1);

        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                aSwitch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (aSwitch.isClickable())
                        {
                            Intent i = new Intent(ModoNoche.this,MainActivity.class);
                            startActivity(i);
                        }
                    }
                });
            }
        },1000);
    }
}