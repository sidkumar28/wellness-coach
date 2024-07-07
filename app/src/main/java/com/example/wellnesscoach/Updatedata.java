package com.example.wellnesscoach;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Updatedata extends AppCompatActivity {

    EditText name_input, phone_input, city_input, age_input, weight_input, iweight_input, extra_input, less_input, bodyfat_input,
            visceral_fat_input, rest_metabolism_input, bmi_input, body_age_input, wbs_input, trunk_f_input, arm_f_input, leg_f_input,
            skeletal_muscle_input, trunk_m_input, arm_m_input, leg_m_input;
    Button update_button, download_button;

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

        update_button= findViewById(R.id.updatebut);
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        getAndSetIntentData();


    }
    void getAndSetIntentData() {
        if (
                getIntent().hasExtra("num") &&
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
                        getIntent().hasExtra("legmus")
        ) {
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
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

}
