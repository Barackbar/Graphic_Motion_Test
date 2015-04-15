package com.jss0027.comp3710.graphicmotiontest;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.TimerTask;

/**
 * Created by JDSS on 14/4/15.
 */
public class ViewThing extends View {
    float x;
    float y;

    public ViewThing(Context context) {
        super(context);
        x = 50;
        y = 50;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x += 50;
        y += 50;
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.frog1), x, y, new Paint());
        Log.i("viewThing", "canvas draw bitmap called");
    }
}
