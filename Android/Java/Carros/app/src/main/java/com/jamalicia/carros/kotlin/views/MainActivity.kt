package com.jamalicia.carros.kotlin.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.jamalicia.carros.R
import com.jamalicia.carros.java.constants.CarrosConstantsOriginal
import com.jamalicia.carros.kotlin.adapter.CarListAdapter
import com.jamalicia.carros.kotlin.data.CarMock
import com.jamalicia.carros.kotlin.entities.Car
import com.jamalicia.carros.kotlin.listener.OnListClickInteractionListener

class MainActivity : AppCompatActivity() {

    var mViewHolder: ViewHolder = ViewHolder()
    private val mContext: Context? = null
    private lateinit var adapter:CarListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val carMock = CarMock()
        val carList: MutableList<Car>? =
            ArrayList()
        carList?.addAll(carMock.list)

        //1- Obter a RecyclerView

//        val recy
        mViewHolder.recyclerCars =
            findViewById<View>(R.id.recyclar_cars) as RecyclerView

        val listener =
            object : OnListClickInteractionListener {
                override fun onClikc(id: Int) {
                    val bundle = Bundle()
                    bundle.putInt(CarrosConstantsOriginal.CARRO_ID, id)
                    val intent = Intent(
                        mContext,
                        DetailsActivity::class.java
                    )
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            }


        //Definir Adapter
        adapter = CarListAdapter(carList)
        val carListAdapter:CarListAdapter = CarListAdapter(carList)

        adapter.onItemClick = {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }

        mViewHolder.recyclerCars!!.adapter = carListAdapter

        //Definir um Layout
        val linearLayoutManager = LinearLayoutManager(this)
        mViewHolder.recyclerCars!!.layoutManager = linearLayoutManager


    }

    class ViewHolder {
        var recyclerCars: RecyclerView? = null
    }


}
