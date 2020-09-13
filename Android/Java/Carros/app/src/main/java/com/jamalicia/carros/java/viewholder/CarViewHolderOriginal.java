package com.jamalicia.carros.java.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jamalicia.carros.R;
import com.jamalicia.carros.java.entities.CarOriginal;
import com.jamalicia.carros.java.listener.OnListClickInteractionListenerOriginal;

public class CarViewHolderOriginal extends RecyclerView.ViewHolder {

    private TextView mTextModel;

    public CarViewHolderOriginal(View itemView) {
        super(itemView);
        this.mTextModel = (TextView) itemView.findViewById(R.id.text_model);
    }

    public void bindData(final CarOriginal car, final OnListClickInteractionListenerOriginal listener){
        this.mTextModel.setText(car.model);
        this.mTextModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClikc(car.id);
            }
        });

    }
}
