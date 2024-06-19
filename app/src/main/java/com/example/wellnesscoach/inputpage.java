package com.example.wellnesscoach;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class inputpage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton add_customer;
    private databasewc myDB;  // make this a member variable
    private ArrayList<String> cname, cmob, ccity, cage, cw, ciw, cex, cls, cbf, cvf, crm, cbmi, cba, cwbs, ctf, caf, clf, csm, ctm, cam, clm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputpage);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize FloatingActionButton and set click listener
        add_customer = findViewById(R.id.add_customer);
        add_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("inputpage", "Add customer button clicked");
                Intent intent = new Intent(inputpage.this, Customer_value.class);
                startActivity(intent);
            }
        });

        // Initialize database and data arrays
        myDB = new databasewc(inputpage.this);
        cname = new ArrayList<>();
        cmob = new ArrayList<>();
        ccity = new ArrayList<>();
        cage = new ArrayList<>();
        cw = new ArrayList<>();
        ciw = new ArrayList<>();
        cex = new ArrayList<>();
        cls = new ArrayList<>();
        cbf = new ArrayList<>();
        cvf = new ArrayList<>();
        crm = new ArrayList<>();
        cbmi = new ArrayList<>();
        cba = new ArrayList<>();
        cwbs = new ArrayList<>();
        ctf = new ArrayList<>();
        caf = new ArrayList<>();
        clf = new ArrayList<>();
        csm = new ArrayList<>();
        ctm = new ArrayList<>();
        cam = new ArrayList<>();
        clm = new ArrayList<>();

        displayData();  // Call the method to display data
    }

    void displayData() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                cname.add(cursor.getString(0));
                cmob.add(cursor.getString(1));
                ccity.add(cursor.getString(2));
                cage.add(cursor.getString(3));
                cw.add(cursor.getString(4));
                ciw.add(cursor.getString(5));
                cex.add(cursor.getString(6));
                cls.add(cursor.getString(7));
                cbf.add(cursor.getString(8));
                cvf.add(cursor.getString(9));
                crm.add(cursor.getString(10));
                cbmi.add(cursor.getString(11));
                cba.add(cursor.getString(12));
                cwbs.add(cursor.getString(13));
                ctf.add(cursor.getString(14));
                caf.add(cursor.getString(15));
                clf.add(cursor.getString(16));
                csm.add(cursor.getString(17));
                ctm.add(cursor.getString(18));
                cam.add(cursor.getString(19));
                clm.add(cursor.getString(20));
            }
            // Bind the data to the RecyclerView using an adapter (not shown here)
        }
    }
}
