package com.example.cars_inbar;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {

    private List<Car> carsList;
    public CarAdapter(List<Car> carList)
    {
        this.carsList = carList;
    }

    public void AddCar(Car car)
    {
        carsList.add(car);
        notifyDataSetChanged();
        DataBaseHelper.StoreData(carsList);
    }

    public void DeleteCar(int position)
    {
        carsList.remove(position);
        notifyDataSetChanged();
        DataBaseHelper.StoreData(carsList);
    }
    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        CarViewHolder vh = new CarViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = carsList.get(position);

        holder.avatar.setImageResource(car.getPhoto());
        holder.brand.setText(car.getBrand());
        holder.model.setText(car.getModel());
        holder.year.setText(car.getYear());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),CarsDisplayActivity.class);
                i.putExtra("car",car);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(),
                                holder.avatar,
                                "avatarTrasnition"
                        );
                v.getContext().startActivity(i,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }
}
