package com.myapplication.rgb_circles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;

public class CanvasView extends View implements ICanvasView {
    private static int width;
    private static int height;
    private Paint paint;
    private Canvas canvas;

    private GameManager gameManager;


    public CanvasView(Context context) {
        super(context);
        initWidthAndHeight(context);
        initPaint();
        gameManager = new GameManager(this, width, height);
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initWidthAndHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        width = point.x;
        height = point.y;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        gameManager.onDraw(canvas);
    }

    @Override
    public void drawCircle(MainCircle circle) {
        canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(), paint);
    }
}
