package com.iteso.caravans;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.iteso.caravans.Beans.Vehicle;

/**
 * Created by Maritza on 11/05/2017.
 */

public class ActivityRegisterVehicle extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String typeS;
    EditText year;
    EditText model;
    EditText name;
    EditText enrollment;
    Spinner type;
    Spinner color;
    String colorS;

    int typeI;
    Color colorC;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_vehicle);
        year = (EditText) findViewById(R.id.year);
        model = (EditText) findViewById(R.id.model);
        name = (EditText) findViewById(R.id.name);
        enrollment = (EditText) findViewById(R.id.enrollment);
        type = (Spinner) findViewById(R.id.sp_type_car);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter);
        type.setOnItemSelectedListener(this);
        color = (Spinner) findViewById(R.id.color);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.color, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color.setAdapter(adapter2);
        color.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (view.getId()){
            case(R.id.sp_type_car):
                typeS = adapterView.getSelectedItem().toString();
                switch (typeS){
                    case("Carro privado"):
                        typeI = 0;
                        break;
                    case("Carro público"):
                        typeI = 1;
                        break;
                    case("Camión público"):
                        typeI = 2;
                        break;
                    case("Camión privado"):
                        typeI = 3;
                        break;
                    default: typeI = 4;
                }
                break;
            case(R.id.color):
                 colorS = adapterView.getSelectedItem().toString();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //Crear el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_register_vehicle, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.save:
                Vehicle vehicle = new Vehicle(name.getText().toString(), enrollment.getText().toString(),
                        model.getText().toString(), Integer.parseInt(year.getText().toString()), typeI, colorS);
                Intent intent = new Intent(this, Vehicles.class);
                intent.putExtra("vehicle", vehicle);
                this.startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
