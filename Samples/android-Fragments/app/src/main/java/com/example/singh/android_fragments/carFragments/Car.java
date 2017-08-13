package com.example.singh.android_fragments.carFragments;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by singh on 12-Aug-17.
 */

public class Car implements Parcelable{

    String model;
    String make;
    int year;
    String color;

    public Car(String model, String make, int year, String color) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.color = color;
    }

    protected Car(Parcel in) {
        model = in.readString();
        make = in.readString();
        year = in.readInt();
        color = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(model);
        parcel.writeString(make);
        parcel.writeInt(year);
        parcel.writeString(color);
    }
}
