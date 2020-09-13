package com.jamalicia.carros.kotlin.data

import com.jamalicia.carros.kotlin.entities.Car
import java.lang.Double
import java.util.*

class CarMock {
    private val mListCars: MutableList<Car>
    val list: List<Car>
        get() = mListCars

    operator fun get(id: Int): Car {
        return mListCars[id]
    }

    init {
        mListCars = ArrayList<Car>()
        for (i in 0..100) {
            mListCars.add(
                Car(
                    i,
                    i.toString(),
                    i * 10,
                    Double.valueOf(i * 100.toDouble())
                )
            )
        }
    }
}