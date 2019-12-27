package com.test.winter19app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText name,email,phoneNumber,requestText;
    Button btnSubmit;
    Spinner departmentSpinner;
    ArrayList<String> departmentList;
    ArrayAdapter<String> departmentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);
        phoneNumber = findViewById(R.id.editTextPhoneNumber);
        requestText = findViewById(R.id.editTextRequestText);
        btnSubmit = findViewById(R.id.submitButton);
        departmentSpinner = findViewById(R.id.departmentSpinner);
        departmentList = new ArrayList<>();
        departmentList.add("Select Department");

        for (int i=1; i<10; i++){
            departmentList.add("Department "+i);
        }

        departmentAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,departmentList);

        departmentSpinner.setAdapter(departmentAdapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameValue = name.getText().toString();
                String emailValue = email.getText().toString();
                String phoneValue = phoneNumber.getText().toString();
                String requesTextValue = requestText.getText().toString();
                int departmentValue = 0;

                if (departmentSpinner.getSelectedItemPosition() > 0 ){
                    departmentValue = departmentSpinner.getSelectedItemPosition();
                    Log.i("Form",nameValue+"\t"+emailValue+"\t"+phoneValue+"\t"+requesTextValue+"\t"+departmentList.get(departmentValue));
                    Toast.makeText(MainActivity.this,"Submitted",Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(MainActivity.this,"Please Select Department",Toast.LENGTH_LONG).show();
                }




            }
        });









    }
}

