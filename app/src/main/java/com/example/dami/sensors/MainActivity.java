package com.example.dami.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager mSensorManager;
    public Sensor mSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL );
        mSensor = sensorList.get(0);

        mSensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.e("Tuts+", "Accuracy: " + sensorEvent.accuracy );
                Log.e("Tuts+", "Timestamp: " + sensorEvent.timestamp);
                Log.e("Tuts+", "Accelerometer X: " + sensorEvent.values[0]);
                Log.e("Tuts+", "Accelerometer Y: " + sensorEvent.values[1]);
                Log.e("Tuts+", "Accelerometer Z: " + sensorEvent.values[2]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        }, mSensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //mSensorManager.unregisterListener();
    }
}
