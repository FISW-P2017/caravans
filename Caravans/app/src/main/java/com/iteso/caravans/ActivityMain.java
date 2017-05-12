package com.iteso.caravans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMain extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
    }

    public void registerVehicle(View view){
        Intent intent = new Intent(this, ActivityRegisterVehicle.class);
        this.startActivity(intent);
    }
}
