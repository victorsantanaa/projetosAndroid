package com.jamalicia.carros

import com.jamalicia.carros.java.entities.CarOriginal
import com.jamalicia.carros.kotlin.data.CarMock
import com.jamalicia.carros.kotlin.entities.Car
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun devepegaroID(){

        var carro: Car = Car(1, "carro 1", 10, 10.0)

        val carId1: Int = CarMock().get(carro.id).id // o método get retorna algo do tipo Car, para pegar o id preciso add o id.1
        var carId: Int = carro.id

        assertEquals(1, carId1)

    }

    @Test
    fun devePegarOCarro(){

        val lista: MutableList<Car>
        lista = ArrayList<Car>()
        lista.add(Car(1, "carro 1", 10, 10.0))
        lista.add(Car(2, "carro 2", 20, 20.0))

        val car1: Car = CarMock().get(1)


        assertEquals(1 , car1)

    }


}
