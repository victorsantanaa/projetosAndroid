package com.jamalicia.carros.kotlin.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.jamalicia.carros.R
import com.jamalicia.carros.java.constants.CarrosConstantsOriginal
import com.jamalicia.carros.java.constants.CarrosConstantsOriginal.CARRO_ID
import com.jamalicia.carros.kotlin.constants.CarrosConstants

import com.jamalicia.carros.kotlin.data.CarMock
import com.jamalicia.carros.kotlin.entities.Car

class DetailsActivity : AppCompatActivity() {
    private var mCarMock: CarMock? = null
    private val mViewHolder =
        ViewHolder()
    private var mCar: Car? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        mCarMock = CarMock()
        mViewHolder.textModel =
            findViewById<View>(R.id.text_modelo_2) as TextView
        mViewHolder.textHorsePower =
            findViewById<View>(R.id.text_cavalos_2) as TextView
        mViewHolder.textPrice =
            findViewById<View>(R.id.text_preco_2) as TextView
        dataFromActivity
        setData()
    }

    private fun setData() {
        mViewHolder.textModel!!.text = mCar!!.model
        mViewHolder.textHorsePower!!.text = mCar!!.horsePower.toString()
        mViewHolder.textPrice!!.text = mCar!!.price.toString()
    }

    private val dataFromActivity: Unit
        private get() {
            val extras = intent.extras
            if (extras != null) {
                mCar = mCarMock!![extras.getInt(CarrosConstantsOriginal.CARRO_ID)]
            }
        }

    private class ViewHolder {
        var textModel: TextView? = null
        var textHorsePower: TextView? = null
        var textPrice: TextView? = null
    }
}
