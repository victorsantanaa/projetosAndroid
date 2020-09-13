package com.jamalicia.carros.java.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jamalicia.carros.R;
import com.jamalicia.carros.java.entities.CarOriginal;
import com.jamalicia.carros.java.listener.OnListClickInteractionListenerOriginal;
import com.jamalicia.carros.java.viewholder.CarViewHolderOriginal;
import com.jamalicia.carros.kotlin.adapter.CarListAdapter;

import java.util.List;

public class CarListAdapterOriginal extends RecyclerView.Adapter<CarViewHolderOriginal> {

    private List<CarOriginal> mListCars;
    private OnListClickInteractionListenerOriginal mOnListClickInteractionListener;

    public CarListAdapterOriginal(List<CarOriginal> cars, OnListClickInteractionListenerOriginal listener){
        this.mListCars = cars;
        this.mOnListClickInteractionListener = listener;
    }
    @NonNull
    @Override
    public CarViewHolderOriginal onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

       View carView =  inflater.inflate(R.layout.row_car_list, viewGroup, false);
       return new CarViewHolderOriginal(carView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolderOriginal carViewHolderOriginal, int position) {
        CarOriginal car = this.mListCars.get(position);
        carViewHolderOriginal.bindData(car, this.mOnListClickInteractionListener);
    }

    @Override
    public int getItemCount() {
        return this.mListCars.size();
    }
}
