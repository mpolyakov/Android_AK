package com.kts.gb_mvp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kts.gb_mvp.R
import com.kts.gb_mvp.model.CountersModel
import com.kts.gb_mvp.presenter.MainPresenter
import com.kts.gb_mvp.view.MainView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainView {

    val presenter = MainPresenter(this, CountersModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener = View.OnClickListener {
            when(it.id){
                R.id.btn_counter1 -> {
                    presenter.counterClick1()
                }
                R.id.btn_counter2 -> {
                    presenter.counterClick2()
                }
                R.id.btn_counter3 -> {
                    presenter.counterClick3()
                }
            }
        }

        btn_counter1.setOnClickListener(listener)
        btn_counter2.setOnClickListener(listener)
        btn_counter3.setOnClickListener(listener)



    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //outState.putIntArray("counters", counters.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
//        savedInstanceState.getIntArray("counters")?.toList()?.let {
//            counters.clear()
//            counters.addAll(it)
//        }
    }

    override fun setButtonText(index: Int, text: String) {
        when(index){
            0 -> btn_counter1.text = text
            1 -> btn_counter2.text = text
            2 -> btn_counter3.text = text
        }
    }
}