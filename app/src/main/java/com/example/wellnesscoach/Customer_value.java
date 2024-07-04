package com.example.wellnesscoach;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer_value extends AppCompatActivity {

    private static final String TAG = "Customer_value";

    EditText n_in, m_in, c_in, a_in, w_in, iw_in, e_in, l_in, bf_in, vf_in, rm_in, bmi_in, ba_in, wbs_in, tf_in, af_in, lf_in, sm_in, tm_in, am_in, lm_in;
    Button add_button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_value);

        // Initialize EditTexts
        n_in = findViewById(R.id.editTextText);
        m_in = findViewById(R.id.editTextPhone);
        c_in = findViewById(R.id.editTextText2);
        a_in = findViewById(R.id.editTextNumber);
        w_in = findViewById(R.id.editTextNumberDecimal);
        iw_in = findViewById(R.id.editTextDecimal1);
        e_in = findViewById(R.id.editTextDecimal2);
        l_in = findViewById(R.id.editTextDecimal3);
        bf_in = findViewById(R.id.editTextDecimal4);
        vf_in = findViewById(R.id.editTextDecimal5);
        rm_in = findViewById(R.id.editTextDecimal6);
        bmi_in = findViewById(R.id.editTextDecimal7);
        ba_in = findViewById(R.id.editTextDecimal8);
        wbs_in = findViewById(R.id.editTextDecimal9);
        tf_in = findViewById(R.id.editTextDecimal10);
        af_in = findViewById(R.id.editTextDecimal11);
        lf_in = findViewById(R.id.editTextDecimal12);
        sm_in = findViewById(R.id.editTextDecimal13);
        tm_in = findViewById(R.id.editTextDecimal14);
        am_in = findViewById(R.id.editTextDecimal15);
        lm_in = findViewById(R.id.editTextDecimal16);

        // Initialize Button
        add_button = findViewById(R.id.addbut);

        // Set OnClickListener for the button
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Get the current date
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    String currentDate = sdf.format(new Date());

                    databasewc myDB = new databasewc(Customer_value.this);
                    myDB.addCustomer(
                            n_in.getText().toString().trim(),
                            Integer.parseInt(m_in.getText().toString().trim()),
                            c_in.getText().toString().trim(),
                            Integer.parseInt(a_in.getText().toString().trim()),
                            Integer.parseInt(w_in.getText().toString().trim()),
                            Integer.parseInt(iw_in.getText().toString().trim()),
                            Integer.parseInt(e_in.getText().toString().trim()),
                            Integer.parseInt(l_in.getText().toString().trim()),
                            Integer.parseInt(bf_in.getText().toString().trim()),
                            Integer.parseInt(vf_in.getText().toString().trim()),
                            Integer.parseInt(rm_in.getText().toString().trim()),
                            Integer.parseInt(bmi_in.getText().toString().trim()),
                            Integer.parseInt(ba_in.getText().toString().trim()),
                            Integer.parseInt(wbs_in.getText().toString().trim()),
                            Integer.parseInt(tf_in.getText().toString().trim()),
                            Integer.parseInt(af_in.getText().toString().trim()),
                            Integer.parseInt(lf_in.getText().toString().trim()),
                            Integer.parseInt(sm_in.getText().toString().trim()),
                            Integer.parseInt(tm_in.getText().toString().trim()),
                            Integer.parseInt(am_in.getText().toString().trim()),
                            Integer.parseInt(lm_in.getText().toString().trim()),
                            currentDate  // Pass the current date
                    );

                    // Optional: Show a toast or perform any other action after adding to the database
                    Toast.makeText(Customer_value.this, "Customer added successfully", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e(TAG, "Error adding customer: " + e.getMessage());
                    Toast.makeText(Customer_value.this, "Failed to add customer", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
