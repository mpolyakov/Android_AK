//package com.kt.std.gb_mvp_moxy.mvp.presenter;
//
//import com.arellomobile.mvp.InjectViewState;
//import com.arellomobile.mvp.MvpPresenter;
//import com.kt.std.gb_mvp_moxy.mvp.view.MainView;
//import com.kt.std.gb_mvp_moxy.mvp.model.Model;
//
//@InjectViewState
//public class MainPresenterOld extends MvpPresenter<MainView> {
//    Model model = new Model();
//
//    @Override
//    protected void onFirstViewAttach() {
//        super.onFirstViewAttach();
//    }
//
//    public void button1IsPushed() {
//        int newValueButton1 = model.getElementValueAtIndex(0) + 1;
//        model.setElementValueAtIndex(0,newValueButton1);
//        getViewState().setTextToButton1(newValueButton1);
//    }
//
//    public void button2IsPushed() {
//        int newValueButton2 = model.getElementValueAtIndex(1) + 1;
//        model.setElementValueAtIndex(1,newValueButton2);
//        getViewState().setTextToButton2(newValueButton2);
//    }
//
//    public void button3IsPushed() {
//        int newValueButton3 = model.getElementValueAtIndex(2) + 1;
//        model.setElementValueAtIndex(2,newValueButton3);
//        getViewState().setTextToButton3(newValueButton3);
//    }
//}