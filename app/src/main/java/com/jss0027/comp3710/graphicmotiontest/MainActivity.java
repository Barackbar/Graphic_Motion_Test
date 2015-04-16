package com.jss0027.comp3710.graphicmotiontest;

import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {
    Timer myTimer;
    ImageView imageView1;
    Handler mHandler;
    Canvas canvas;
    ViewThing view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //imageView1 = (ImageView) findViewById(R.id.imageView1);
        //canvas = new Canvas();
        view = new ViewThing(this);
        setContentView(view);
        //update.changeImageView(imageView1);

    }

    @Override
    protected void onResume() {
        super.onResume();

        mHandler = new Handler() {
            public void handleMessage(Message msg) {
                Log.i("TEST", "view.invalidate()");
                view.invalidate();
            }
        };

        myTimer = new Timer("myTimer", false);
        myTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mHandler.obtainMessage(1).sendToTarget();
            }
        }, 0, 300);
    }

    @Override
    protected void onPause() {
        super.onPause();
        myTimer.cancel();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

class Delay extends AsyncTask<Integer, Void, Void> {

    @Override
    protected Void doInBackground(Integer... params) {
        try {
            Log.i("TEST", "Delaying");
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        Log.i("TEST", "onPostExecute");

        super.onPostExecute(result);
    }
}