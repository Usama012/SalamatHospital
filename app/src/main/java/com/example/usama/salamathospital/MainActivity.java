package com.example.usama.salamathospital;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTextcnic;
    EditText editTextpatientName;
    EditText editTextAge;
    EditText editTextdoctorName;
    EditText editTextcharges;
    EditText editTextdate;
    EditText editTextSend;
    EditText editTextRecive;
    Button buttonAddArtist;
    DatabaseReference databasePatient;

    /////////////////////////////////////////
//    ListView listViewPatient;
    List<Patient> patientList;

    ////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databasePatient = FirebaseDatabase.getInstance().getReference("Patient");
        editTextcnic = (EditText) findViewById(R.id.editTextcnic);
        editTextpatientName = (EditText) findViewById(R.id.editTextpatientName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        editTextdoctorName = (EditText) findViewById(R.id.editTextdoctorName);
        editTextcharges = (EditText) findViewById(R.id.editTextcharges);
        editTextdate = (EditText) findViewById(R.id.editTextdate);
        editTextSend = (EditText) findViewById(R.id.editTextSend);
        editTextRecive = (EditText) findViewById(R.id.editTextRecive);
        buttonAddArtist = (Button) findViewById(R.id.buttonAddArtist);


        ////////////////////////
//        listViewPatient=(ListView)findViewById(R.id.listViewPatient);
        patientList = new ArrayList<>();
        ////////////////////////


        Intent intent = getIntent();
        final Bundle args = intent.getExtras();
        if (args.containsKey("patient")) {
            editTextcnic.setText(args.getString("nic"));
            editTextpatientName.setText(args.getString("name"));
            editTextAge.setText(args.getString("age"));
            editTextdate.setText(args.getString("Date"));
            editTextdoctorName.setText(args.getString("dname"));
            editTextSend.setText(args.getString("send"));
            editTextRecive.setText(args.getString("rec"));

            buttonAddArtist.setText("Update");
        }

        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //it will call addArtist method on click

                addPatient();


            }
        });
    }

//    private void update() {
//        String patientCnic = editTextcnic.getText().toString().trim();
//        String patientName = editTextpatientName.getText().toString().trim();
//        String patientAge = editTextAge.getText().toString().trim();
//        String doctorName = editTextdoctorName.getText().toString().trim();
//        String totalCharges = editTextcharges.getText().toString().trim();
//        String dateOfDay = editTextdate.getText().toString().trim();
//        String Send = editTextSend.getText().toString().trim();
//        String Recive = editTextRecive.getText().toString().trim();
//
//        //implementmethods for name if the name is not empty then save it into firebase
//        if (!TextUtils.isEmpty(patientCnic)) {
//            //for generting and getting the key of artist and store in String Id
////            String id = databaseArtists.push().getKey();
//            //creating artist
//
//            Patient patient = new Patient(patientCnic, patientName, patientAge, doctorName, totalCharges, dateOfDay, Send, Recive);
//            //use setValue method to store this patient into firebase database
//            //child(id) method is used to so that we can store the patient in cnic which is unique key
//            databasePatient.child("Panel").child(patientCnic).setValue(patient);
//            Toast.makeText(MainActivity.this, "Patient Added", Toast.LENGTH_LONG).show();
//
//
//        } else {
//            Toast.makeText(MainActivity.this, "Please Enter the name", Toast.LENGTH_LONG).show();
//        }
//
//    }
    //////////////////////


    @Override
    protected void onStart() {
        super.onStart();
//        databasePatient.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for(DataSnapshot patientSnapshot: dataSnapshot.getChildren())
//                {
//                    patientList.clear();
//                    Patient patient=patientSnapshot.getValue(Patient.class);
//                    patientList.add(patient);
//
//                }
//                PatientList adapter=new PatientList(MainActivity.this,patientList);
//                listViewPatient.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }
    ///////////////////////

    private void addPatient() {
        //getting artist name
        String patientCnic = editTextcnic.getText().toString().trim();
        String patientName = editTextpatientName.getText().toString().trim();
        String patientAge = editTextAge.getText().toString().trim();
        String doctorName = editTextdoctorName.getText().toString().trim();
        String totalCharges = editTextcharges.getText().toString().trim();
        String dateOfDay = editTextdate.getText().toString().trim();
        String Send = editTextSend.getText().toString().trim();
        String Recive = editTextRecive.getText().toString().trim();

        //implementmethods for name if the name is not empty then save it into firebase
        if (!TextUtils.isEmpty(patientCnic)) {
            //for generting and getting the key of artist and store in String Id
//            String id = databaseArtists.push().getKey();
            //creating artist

            Patient patient = new Patient(patientCnic, patientName, patientAge, doctorName, totalCharges, dateOfDay, Send, Recive);
            //use setValue method to store this patient into firebase database
            //child(id) method is used to so that we can store the patient in cnic which is unique key
            databasePatient.child("Panel").child(patientCnic).setValue(patient);
            Toast.makeText(MainActivity.this, "Patient Added", Toast.LENGTH_LONG).show();


        } else {
            Toast.makeText(MainActivity.this, "Please Enter the name", Toast.LENGTH_LONG).show();
        }
    }
}
