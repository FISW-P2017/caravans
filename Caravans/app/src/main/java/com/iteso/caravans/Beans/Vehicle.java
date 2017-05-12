package com.iteso.caravans.Beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Maritza on 11/05/2017.
 */

public class Vehicle implements Parcelable{
    String name, enrollment, model, color;
    int year, type;


    public Vehicle(String name, String enrollment, String model, int year, int type, String color) {
        this.name = name;
        this.enrollment = enrollment;
        this.model = model;
        this.year = year;
        this.type = type;
        this.color = color;
    }


    protected Vehicle(Parcel in) {
        name = in.readString();
        enrollment = in.readString();
        model = in.readString();
        year = in.readInt();
        type = in.readInt();
        color = in.readString();
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static Creator<Vehicle> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(enrollment);
        parcel.writeString(model);
        parcel.writeInt(year);
        parcel.writeInt(type);
        parcel.writeString(color);
        int a = 0;
    }
}
