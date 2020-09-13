package com.jamalicia.carros.java.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jamalicia.carros.R;
import com.jamalicia.carros.java.adapter.CarListAdapterOriginal;
import com.jamalicia.carros.java.constants.CarrosConstantsOriginal;
import com.jamalicia.carros.java.data.CarMockOriginal;
import com.jamalicia.carros.java.entities.CarOriginal;
import com.jamalicia.carros.java.listener.OnListClickInteractionListenerOriginal;
import com.jamalicia.carros.kotlin.adapter.CarListAdapter;
import com.jamalicia.carros.kotlin.views.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

public class MainActivityOriginal extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mContext = this;

        CarMockOriginal carMock = new CarMockOriginal();
        List<CarOriginal> carList = new ArrayList();
        carList.addAll(carMock.getList());

        //1- Obter a RecyclerView
        this.mViewHolder.recyclerCars = (RecyclerView) this.findViewById(R.id.recyclar_cars);

        OnListClickInteractionListenerOriginal listener = new OnListClickInteractionListenerOriginal() {
            @Override
            public void onClikc(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(CarrosConstantsOriginal.CARRO_ID, id);

                Intent intent = new Intent(mContext, DetailsActivityOriginal.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        };


        //Definir Adapter
        CarListAdapterOriginal carListAdapter = new CarListAdapterOriginal(carList, listener);
        this.mViewHolder.recyclerCars.setAdapter(carListAdapter);

        //Definir um Layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mViewHolder.recyclerCars.setLayoutManager(linearLayoutManager);

    }

     static class ViewHolder {
        RecyclerView recyclerCars;
    }
}
