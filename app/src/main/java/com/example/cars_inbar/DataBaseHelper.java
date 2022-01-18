package com.example.cars_inbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper {
    public static Context Context;

    public static void StoreData(List<Car> carslist)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        SharedPreferences.Editor editor = sp.edit();
        String json = new Gson().toJson(carslist );
        editor.putString("carslist", json);
        editor.commit();
    }

    public static List<Car> LoadData()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        String json = sp.getString("carslist",null);
        if (json != null)
        {
            Type type = new TypeToken<List<Car>>(){}.getType();
            return new Gson().fromJson(json,type);
        }
        else {
            List<Car> carslist = new ArrayList<Car>();
            carslist.add(new Car(R.drawable.car1, "BMW", "V1", "2021", "200,000"));
            carslist.add(new Car(R.drawable.car2, "Tesla", "V2", "2019", "100,000"));
            carslist.add(new Car(R.drawable.car3, "Ferary", "V3", "2020", "150,000"));
            carslist.add(new Car(R.drawable.car4, "Pursh", "V4", "2021", "1,000,000"));
            carslist.add(new Car(R.drawable.car5, "Mazda", "V5", "2016", "50,000"));
            carslist.add(new Car(R.drawable.car6, "Golf", "V6", "2012", "20,000"));
            carslist.add(new Car(R.drawable.car7, "Audi", "V7", "2020", "80,000"));
            carslist.add(new Car(R.drawable.car8, "Hndai", "V8", "2019", "50,000"));
            return carslist;
        }
    }

}
