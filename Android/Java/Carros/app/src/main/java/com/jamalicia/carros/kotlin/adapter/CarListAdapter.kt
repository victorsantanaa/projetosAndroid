package com.jamalicia.carros.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jamalicia.carros.R
import com.jamalicia.carros.kotlin.data.CarMock
import com.jamalicia.carros.kotlin.entities.Car
import com.jamalicia.carros.kotlin.listener.OnListClickInteractionListener
import com.jamalicia.carros.kotlin.viewholder.CarViewHolder
import com.jamalicia.carros.kotlin.viewholder.onClick

class CarListAdapter( cars: MutableList<Car>?
                    ) :
    RecyclerView.Adapter<CarViewHolder>() {


    var mListCars: List<Car>? = cars
  //  var mOnListClickInteractionListener: OnListClickInteractionListener? = listener


    private var mCarMock: CarMock? = null


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CarViewHolder {
        val context = viewGroup.context
        val inflater = LayoutInflater.from(context)
        val carView = inflater.inflate(R.layout.row_car_list, viewGroup, false)
        return CarViewHolder(carView).onClick {carView, position, type ->
            val car = mListCars?.get(position)

        }
    }

    override fun onBindViewHolder(
        carViewHolder: CarViewHolder,
        position: Int
    ) {
        val car = mListCars?.get(position)
        carViewHolder.mTextModel.text = car?.model
        carViewHolder.bindData(car)
    }

    var onItemClick: ((Int) -> Unit)? = null

    override fun getItemCount(): Int {
       return if (mListCars?.size != null) mListCars!!.size else throw NullPointerException("Tamanho da lista está dando nulo")

    }
}