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
    private ArrayList<String> cnum, cdate, cname, cmob, ccity, cage, cw, ciw, cex, cls, cbf, cvf, crm, cbmi, cba, cwbs, ctf, caf, clf, csm, ctm, cam, clm;

    CustomerAdapter customerAdapter;

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
        cnum = new ArrayList<>();
        cdate = new ArrayList<>();
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

        storeDataInArrays();  // Call the method to display data

        // Initialize and set the adapter
        customerAdapter = new CustomerAdapter(inputpage.this, cnum, cdate, cname, cmob,ccity, cage, cw, ciw, cex, cls, cbf, cvf, crm, cbmi, cba, cwbs, ctf, caf, clf, csm, ctm, cam, clm);
        recyclerView.setAdapter(customerAdapter);
    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                cnum.add(cursor.getString(0));
                cdate.add(cursor.getString(1));
                cname.add(cursor.getString(2));
                cmob.add(cursor.getString(3));
                ccity.add(cursor.getString(4));
                cage.add(cursor.getString(5));
                cw.add(cursor.getString(6));
                ciw.add(cursor.getString(7));
                cex.add(cursor.getString(8));
                cls.add(cursor.getString(9));
                cbf.add(cursor.getString(10));
                cvf.add(cursor.getString(11));
                crm.add(cursor.getString(12));
                cbmi.add(cursor.getString(13));
                cba.add(cursor.getString(14));
                cwbs.add(cursor.getString(15));
                ctf.add(cursor.getString(16));
                caf.add(cursor.getString(17));
                clf.add(cursor.getString(18));
                csm.add(cursor.getString(19));
                ctm.add(cursor.getString(20));
                cam.add(cursor.getString(21));
                clm.add(cursor.getString(22));
            }
            // Bind the data to the RecyclerView using an adapter (not shown here)
        }
    }
}
