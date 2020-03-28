package com.kts.gb_mvp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kts.gb_mvp.R
import com.kts.gb_mvp.model.CountersModel
import com.kts.gb_mvp.presenter.MainPresenter
import com.kts.gb_mvp.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter : MainPresenter

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

    @ProvidePresenter
    fun providePresenter() : MainPresenter = MainPresenter(CountersModel())


    override fun setButtonOneText(text: String) {
    btn_counter1.text = text
    }

    override fun setButtonTwoText(text: String) {
        btn_counter2.text = text
    }

    override fun setButtonThreeText(text: String) {
        btn_counter3.text = text
    }
}