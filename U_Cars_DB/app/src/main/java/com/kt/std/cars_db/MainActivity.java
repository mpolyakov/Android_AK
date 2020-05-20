package com.kt.std.cars_db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.kt.std.cars_db.Data.DatabaseHandler;
import com.kt.std.cars_db.Model.Car;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        Log.d("CarsCount", String.valueOf(databaseHandler.getCarsCount()));

//        databaseHandler.addCar(new Car("Toyota", "30000 $"));
//        databaseHandler.addCar(new Car("Opel", "25000 $"));
//        databaseHandler.addCar(new Car("Mers", "50000 $"));
//        databaseHandler.addCar(new Car("Kia", "40000 $"));
//
//        List<Car> carList = databaseHandler.getAllCars();
//
//        for (Car car : carList) {
//            Log.d("CarInfo", "ID " + car.getId() + " , name " + car.getName() + " , price " + car.getPrice());
//        }

        Car car = databaseHandler.getCar(10);
        Log.d("CarInfo", "ID " + car.getId() + " , name " + car.getName() + " , price " + car.getPrice());

        car.setName("Tesla");
        car.setPrice("63251$");
        databaseHandler.updateCar(car);

        databaseHandler.deleteCar(car);

        List<Car> carList = databaseHandler.getAllCars();

        for (Car c : carList) {
            Log.d("CarInfo", "ID " + c.getId() + " , name " + c.getName() + " , price " + c.getPrice());
        }



    }
}
