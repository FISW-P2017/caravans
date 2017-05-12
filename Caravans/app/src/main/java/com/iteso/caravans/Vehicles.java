package com.iteso.caravans;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.iteso.caravans.Beans.Vehicle;

import java.util.ArrayList;

/**
 * Created by Maritza on 11/05/2017.
 */

public class Vehicles extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);

        Vehicle vehicle = getIntent().getParcelableExtra("vehicle");


        rv = (RecyclerView) findViewById(R.id.rv);

        vehicles.add(new Vehicle("Popeye", "MD492342", "yeta", 2010, 0, "Rojo"));
        vehicles.add(new Vehicle("Billy & Mandy", "ER4932442", "aveo", 2008, 0, "Azul"));
        vehicles.add(new Vehicle("Homero", "ZP32443332", "mazda", 2012, 0, "Negro"));
        vehicles.add(vehicle);

        AdapterVehicles adapterVehicles = new AdapterVehicles(vehicles, this);
        rv.setAdapter(adapterVehicles);
    }
}
