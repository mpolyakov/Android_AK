package com.kts.mvp_example;

public class Presenter {
    private Model mModel;
    private MainView view;
    public Presenter(MainActivity view){
        this.mModel = new Model();
        this.view = view;
    }

    private int calcNewModelValue(int modelElementIndex){
        int currentValue = mModel.getElementValueAtIndex(modelElementIndex);
        return currentValue + 1;
    }

    public void buttonClick(int btnIndex){
        int newModelValue;
        switch (btnIndex){
            case R.id.button1:
                newModelValue = calcNewModelValue(0);
                mModel.setElementValueAtIndex(0, newModelValue);
                view.setButtonText(1, newModelValue);
                break;
            case R.id.button2:
                newModelValue = calcNewModelValue(1);
                mModel.setElementValueAtIndex(1, newModelValue);
                view.setButtonText(2, newModelValue);
                break;
            case R.id.button3:
                newModelValue = calcNewModelValue(2);
                mModel.setElementValueAtIndex(2, newModelValue);
                view.setButtonText(3, newModelValue);
                break;
        }
    }
}
