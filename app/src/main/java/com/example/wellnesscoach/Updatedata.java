package com.example.wellnesscoach;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Updatedata extends AppCompatActivity {

    EditText name_input, phone_input, city_input, age_input, weight_input, iweight_input, extra_input, less_input, bodyfat_input,
            visceral_fat_input, rest_metabolism_input, bmi_input, body_age_input, wbs_input, trunk_f_input, arm_f_input, leg_f_input,
            skeletal_muscle_input, trunk_m_input, arm_m_input, leg_m_input;
    Button update_button, deletebtn, downloadbtn;

    String n, m, c, a, w, iw, e, l, bf, vf, rm, bmi, ba, wbs, tf, af, lf, sm, tm, am, lm, d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_updatedata);

        // Initialize EditText fields
        name_input = findViewById(R.id.editTextText2);
        phone_input = findViewById(R.id.editTextPhone2);
        city_input = findViewById(R.id.editTextText222);
        age_input = findViewById(R.id.editTextNumber2);
        weight_input = findViewById(R.id.editTextNumberDecimal2);
        iweight_input = findViewById(R.id.editTextDecimal12);
        extra_input = findViewById(R.id.editTextDecimal22);
        less_input = findViewById(R.id.editTextDecimal32);
        bodyfat_input = findViewById(R.id.editTextDecimal42);
        visceral_fat_input = findViewById(R.id.editTextDecimal52);
        rest_metabolism_input = findViewById(R.id.editTextDecimal62);
        bmi_input = findViewById(R.id.editTextDecimal72);
        body_age_input = findViewById(R.id.editTextDecimal82);
        wbs_input = findViewById(R.id.editTextDecimal92);
        trunk_f_input = findViewById(R.id.editTextDecimal102);
        arm_f_input = findViewById(R.id.editTextDecimal112);
        leg_f_input = findViewById(R.id.editTextDecimal122);
        skeletal_muscle_input = findViewById(R.id.editTextDecimal132);
        trunk_m_input = findViewById(R.id.editTextDecimal142);
        arm_m_input = findViewById(R.id.editTextDecimal152);
        leg_m_input = findViewById(R.id.editTextDecimal162);

        getAndSetIntentData();
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(n);
        }

        update_button = findViewById(R.id.updatebut);
        deletebtn = findViewById(R.id.deletebtn);
        downloadbtn = findViewById(R.id.downloadbtn); // Initialize download button

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Collect data from EditText fields
                n = name_input.getText().toString();
                m = phone_input.getText().toString();
                c = city_input.getText().toString();
                a = age_input.getText().toString();
                w = weight_input.getText().toString();
                iw = iweight_input.getText().toString();
                e = extra_input.getText().toString();
                l = less_input.getText().toString();
                bf = bodyfat_input.getText().toString();
                vf = visceral_fat_input.getText().toString();
                rm = rest_metabolism_input.getText().toString();
                bmi = bmi_input.getText().toString();
                ba = body_age_input.getText().toString();
                wbs = wbs_input.getText().toString();
                tf = trunk_f_input.getText().toString();
                af = arm_f_input.getText().toString();
                lf = leg_f_input.getText().toString();
                sm = skeletal_muscle_input.getText().toString();
                tm = trunk_m_input.getText().toString();
                am = arm_m_input.getText().toString();
                lm = leg_m_input.getText().toString();
                d = getIntent().getStringExtra("date");

                // Validate data
                if (n.isEmpty() || m.isEmpty() || c.isEmpty() || a.isEmpty() || w.isEmpty() || iw.isEmpty() || e.isEmpty() || l.isEmpty() ||
                        bf.isEmpty() || vf.isEmpty() || rm.isEmpty() || bmi.isEmpty() || ba.isEmpty() || wbs.isEmpty() || tf.isEmpty() ||
                        af.isEmpty() || lf.isEmpty() || sm.isEmpty() || tm.isEmpty() || am.isEmpty() || lm.isEmpty() || d.isEmpty()) {
                    Toast.makeText(Updatedata.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    databasewc myDb = new databasewc(Updatedata.this);
                    myDb.updatedata(m, n, c, a, w, iw, e, l, bf, vf, rm, bmi, ba, wbs, tf, af, lf, sm, tm, am, lm, d);
                }
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog(); // Call the confirmDialog() method to show the confirmation dialog
            }
        });

        // Add click listener for download button
        downloadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Updatedata.this, Customer_report.class);
                intent.putExtra("EXTRA_NAME", n);
                startActivity(intent);
            }
        });
    }

    void getAndSetIntentData() {
        if (getIntent().hasExtra("num") &&
                getIntent().hasExtra("date") &&
                getIntent().hasExtra("name") &&
                getIntent().hasExtra("mobile") &&
                getIntent().hasExtra("city") &&
                getIntent().hasExtra("age") &&
                getIntent().hasExtra("weight") &&
                getIntent().hasExtra("iweight") &&
                getIntent().hasExtra("extra") &&
                getIntent().hasExtra("less") &&
                getIntent().hasExtra("bodyfat") &&
                getIntent().hasExtra("visceralfat") &&
                getIntent().hasExtra("restmeta") &&
                getIntent().hasExtra("bmi") &&
                getIntent().hasExtra("bodyage") &&
                getIntent().hasExtra("wholebodysub") &&
                getIntent().hasExtra("trunkfat") &&
                getIntent().hasExtra("armfat") &&
                getIntent().hasExtra("legfat") &&
                getIntent().hasExtra("skelmus") &&
                getIntent().hasExtra("trunkmus") &&
                getIntent().hasExtra("armmus") &&
                getIntent().hasExtra("legmus")) {

            n = getIntent().getStringExtra("name");
            m = getIntent().getStringExtra("mobile");
            c = getIntent().getStringExtra("city");
            a = getIntent().getStringExtra("age");
            w = getIntent().getStringExtra("weight");
            iw = getIntent().getStringExtra("iweight");
            e = getIntent().getStringExtra("extra");
            l = getIntent().getStringExtra("less");
            bf = getIntent().getStringExtra("bodyfat");
            vf = getIntent().getStringExtra("visceralfat");
            rm = getIntent().getStringExtra("restmeta");
            bmi = getIntent().getStringExtra("bmi");
            ba = getIntent().getStringExtra("bodyage");
            wbs = getIntent().getStringExtra("wholebodysub");
            tf = getIntent().getStringExtra("trunkfat");
            af = getIntent().getStringExtra("armfat");
            lf = getIntent().getStringExtra("legfat");
            sm = getIntent().getStringExtra("skelmus");
            tm = getIntent().getStringExtra("trunkmus");
            am = getIntent().getStringExtra("armmus");
            lm = getIntent().getStringExtra("legmus");
            d = getIntent().getStringExtra("date");

            // Set the data to EditText fields
            name_input.setText(n);
            phone_input.setText(m);
            city_input.setText(c);
            age_input.setText(a);
            weight_input.setText(w);
            iweight_input.setText(iw);
            extra_input.setText(e);
            less_input.setText(l);
            bodyfat_input.setText(bf);
            visceral_fat_input.setText(vf);
            rest_metabolism_input.setText(rm);
            bmi_input.setText(bmi);
            body_age_input.setText(ba);
            wbs_input.setText(wbs);
            trunk_f_input.setText(tf);
            arm_f_input.setText(af);
            leg_f_input.setText(lf);
            skeletal_muscle_input.setText(sm);
            trunk_m_input.setText(tm);
            arm_m_input.setText(am);
            leg_m_input.setText(lm);
        }
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + n + " ?");
        builder.setMessage("Are you sure you want to delete " + n + " ?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databasewc myDb = new databasewc(Updatedata.this);
                myDb.deleteOneRow(m);
                finish(); // Close activity after deletion
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do nothing
            }
        });
        builder.create().show();
    }
}
