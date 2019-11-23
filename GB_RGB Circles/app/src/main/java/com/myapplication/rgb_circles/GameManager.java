package com.myapplication.rgb_circles;

import android.graphics.Canvas;
import android.graphics.Paint;

public class GameManager {

    private MainCircle mainCircle;
    private CanvasView canvasView;
    private static int width;
    private static int height;

    public GameManager(CanvasView canvasView, int w, int h) {
        width = w;
        height = h;
        this.canvasView = canvasView;
        initMainCircle();

    }



    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    public void onDraw(Canvas canvas) {
        canvasView.drawCircle(mainCircle);
    }
}
