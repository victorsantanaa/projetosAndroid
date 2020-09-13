package com.jamalicia.carros.java.data;

import com.jamalicia.carros.java.entities.CarOriginal;

import java.util.ArrayList;
import java.util.List;

public class CarMockOriginal {

    private List<CarOriginal> mListCars;

    public CarMockOriginal(){
        this.mListCars = new ArrayList<>();
        for (int i = 0; i<=100; i++){
            this.mListCars.add(new CarOriginal(i, String.valueOf(i), i*10, (double) (i * 100)));
        }
    }

    public List<CarOriginal> getList() {
        return this.mListCars;
    }

    public CarOriginal get(int id){
        return this.mListCars.get(id);
    }
}
