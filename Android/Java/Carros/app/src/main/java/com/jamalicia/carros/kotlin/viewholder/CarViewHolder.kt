package com.jamalicia.carros.kotlin.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.jamalicia.carros.R
import com.jamalicia.carros.java.entities.CarOriginal
import com.jamalicia.carros.java.listener.OnListClickInteractionListenerOriginal
import com.jamalicia.carros.kotlin.entities.Car
import com.jamalicia.carros.kotlin.listener.OnListClickInteractionListener

class CarViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {



    var mTextModel: TextView = itemView.findViewById<View>(R.id.text_model) as TextView

    fun bindData(
        car: Car?
      //  listener: OnListClickInteractionListener?
    ) {
        mTextModel.text = car?.model
       // mTextModel.setOnClickListener { listener?.onClikc(car!!.id) }
        with(itemView) {
            setOnClickListener{

            }
        }
    }
}