package com.jamalicia.carros.java.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jamalicia.carros.R;
import com.jamalicia.carros.java.constants.CarrosConstantsOriginal;
import com.jamalicia.carros.java.data.CarMockOriginal;
import com.jamalicia.carros.java.entities.CarOriginal;
import com.jamalicia.carros.kotlin.entities.Car;

public class DetailsActivityOriginal extends AppCompatActivity {

    private CarMockOriginal mCarMock;
    private ViewHolder mViewHolder = new ViewHolder();
    private CarOriginal mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mCarMock = new CarMockOriginal();

        this.mViewHolder.textModel = (TextView) this.findViewById(R.id.text_modelo_2);
        this.mViewHolder.textHorsePower = (TextView) this.findViewById(R.id.text_cavalos_2);
        this.mViewHolder.textPrice = (TextView) this.findViewById(R.id.text_preco_2);

        this.getDataFromActivity();

        this.setData();
    }

    private void setData(){
        this.mViewHolder.textModel.setText(this.mCar.model);
        this.mViewHolder.textHorsePower.setText(String.valueOf(this.mCar.horsePower));
        this.mViewHolder.textPrice.setText(String.valueOf(this.mCar.price));
    }

    private void getDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if( extras != null){
            this.mCar = this.mCarMock.get(extras.getInt(CarrosConstantsOriginal.CARRO_ID));
        }
    }

    private static class ViewHolder{
        TextView textModel;
        TextView textHorsePower;
        TextView textPrice;
    }
}