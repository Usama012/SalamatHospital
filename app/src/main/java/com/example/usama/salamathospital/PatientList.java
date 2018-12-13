package com.example.usama.salamathospital;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import static com.example.usama.salamathospital.R.layout.list_layout;

public class PatientList extends ArrayAdapter<Patient> {
    private Activity context;
    private List<Patient> patientList;
    public PatientList(Activity context,List<Patient> patientList) {
        super(context, R.layout.list_layout, patientList);
        this.context=context;
        this.patientList = patientList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listPatient=inflater.inflate(R.layout.list_layout,null,true);
        TextView textViewcnic=(TextView)listPatient.findViewById(R.id.textViewcnic);
        TextView textViewName=(TextView)listPatient.findViewById(R.id.textViewName);
        TextView textViewAge=(TextView)listPatient.findViewById(R.id.textViewAge);
        TextView textViewdoctorName=(TextView)listPatient.findViewById(R.id.textViewdoctorName);
        TextView textViewcharges=(TextView)listPatient.findViewById(R.id.textViewcharges);
        TextView textViewdate=(TextView)listPatient.findViewById(R.id.textViewdate);
        TextView textViewsentStatus=(TextView)listPatient.findViewById(R.id.textViewsentStatus);
        TextView textViewreciveStatus=(TextView)listPatient.findViewById(R.id.textViewreciveStatus);
        Button update = (Button)listPatient.findViewById(R.id.update);
        final Patient patient=patientList.get(position);

        textViewcnic.setText("CNIC : "+patient.getPatientCnic());
        textViewName.setText("Name : "+patient.getPatientName());
        textViewAge.setText("Age : "+patient.getPatientAge());
        textViewdoctorName.setText("Dr.Name : "+patient.getDoctorName());
        textViewcharges.setText("Charges : "+patient.getTotalCharges());
        textViewdate.setText("Date : "+patient.getDateOfDay());
        textViewsentStatus.setText("Send : "+patient.getSend());
        textViewreciveStatus.setText("Recived : "+patient.getRecive());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,MainActivity.class).putExtra("patient","").putExtra("nic",patient.getPatientCnic()).putExtra("name",patient.getPatientName()).putExtra("age",patient.getPatientAge()).putExtra("Date",patient.getDateOfDay()).putExtra("dname",patient.getDoctorName()).putExtra("send",patient.getSend()).putExtra("rec",patient.getRecive()));
            }
        });

        return listPatient;

    }

    @Override
    public int getCount() {
        return patientList.size();
    }

}
