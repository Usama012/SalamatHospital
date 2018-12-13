package com.example.usama.salamathospital;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class First_Activity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

    }

    public void ViewRecord(View view) {

        Intent obj = new Intent(this, ViewRecord.class);
        startActivity(obj);
//        startActivity(new Intent(this,ViewRecord.class));
    }


    public void addRecord(View view) {
        Intent obj1 = new Intent(this, MainActivity.class);
        startActivity(obj1);

    }
}
