package com.kts.githubclient.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kts.githubclient.R
import com.kts.githubclient.mvp.presenter.MainPresenter
import com.kts.githubclient.mvp.view.MainView
import com.kts.githubclient.ui.App
import com.kts.githubclient.ui.BackButtonListener
import com.kts.githubclient.ui.adapter.RepositoriesRVAdapter
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(), MainView {

    val navigator = SupportAppNavigator(this, R.id.container)

    @InjectPresenter
    lateinit var presenter: MainPresenter

    var adapter: RepositoriesRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @ProvidePresenter
    fun providePresenter() = MainPresenter(App.instance.getRouter())

    override fun init() {

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.getNavigatorHolder().removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListener && it.backClicked()){
                return
            }
        }
        presenter.backClicked()
    }


}
