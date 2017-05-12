package com.iteso.caravans;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iteso.caravans.Beans.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maritza on 11/05/2017.
 */

public class AdapterVehicles extends RecyclerView.Adapter<AdapterVehicles.ViewHolder> {

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Context context;

    public AdapterVehicles(ArrayList<Vehicle> vehicles, Context context){
        this.vehicles = vehicles;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_car, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Vehicle vehicle = vehicles.get(position);
        holder.name.setText(vehicle.getName());
        holder.model.setText(vehicle.getModel());
        holder.year.setText(vehicle.getYear());
        holder.enrollment.setText(vehicle.getEnrollment());
        switch (vehicle.getColor()){
            case("Rojo"):
                holder.color.setBackgroundColor(Color.RED);
                break;
            case("Verde"):
                holder.color.setBackgroundColor(Color.GREEN);
                break;
            case("Amarillo"):
                holder.color.setBackgroundColor(Color.YELLOW);
                break;
            case("Morado"):
                holder.color.setBackgroundColor(Color.rgb(163, 73, 164));
                break;
            case("Azul"):
                holder.color.setBackgroundColor(Color.BLUE);
                break;
            case("Café"):
                holder.color.setBackgroundColor(Color.rgb(146, 90, 61));
                break;
            case("Negro"):
                holder.color.setBackgroundColor(Color.BLACK);
                break;
            case("Rosa"):
                holder.color.setBackgroundColor(Color.rgb(254, 63, 250));
                break;
            case("Naranja"):
                holder.color.setBackgroundColor(Color.rgb(255, 127, 39));
                break;
            default:
                holder.color.setBackgroundColor(Color.MAGENTA);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return vehicles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView enrollment;
        public TextView year;
        public TextView model;
        public ImageView color;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            enrollment = (TextView) itemView.findViewById(R.id.enrollment);
            model = (TextView) itemView.findViewById(R.id.model);
            year = (TextView) itemView.findViewById(R.id.year);
            color = (ImageView) itemView.findViewById(R.id.color);
        }
    }
}
