package com.example.usama.salamathospital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewRecord extends AppCompatActivity {

    List<Patient> patientList;
    DatabaseReference databasePatient;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);
        patientList=new ArrayList<>();

        databasePatient= FirebaseDatabase.getInstance().getReference().child("Patient").child("Panel");
        listView = (ListView)findViewById(R.id.list);

    }

    @Override
    protected void onStart() {
        super.onStart();
        databasePatient.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                patientList.clear();
                for(DataSnapshot patientSnapshot: dataSnapshot.getChildren())
                {

                    Patient patient=patientSnapshot.getValue(Patient.class);
                    patientList.add(patient);

                }
                PatientList adapter=new PatientList(ViewRecord.this,patientList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
