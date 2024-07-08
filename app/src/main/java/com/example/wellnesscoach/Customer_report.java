package com.example.wellnesscoach;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class Customer_report extends AppCompatActivity {

    TextView nametxt, mobtxt, citytxt, agetxt, weighttxt, idealwtxt, extratxt, lesstxt,
            bodyfattxt, visericaltxt, resttxt, bmitxt, bodyagetxt, wbstxt, trunkfattxt,
            armfattxt, legfattxt, skemustxt, trunkmustxt, armmustxt, legmustxt;
    Button savePdfButton;
    databasewc myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_report);

        // Initialize TextViews
        nametxt = findViewById(R.id.nameView);
        mobtxt = findViewById(R.id.mobileView);
        citytxt = findViewById(R.id.cityView);
        agetxt = findViewById(R.id.ageView);
        weighttxt = findViewById(R.id.weightView);
        idealwtxt = findViewById(R.id.idealwView);
        extratxt = findViewById(R.id.extraView);
        lesstxt = findViewById(R.id.lessView);
        bodyfattxt = findViewById(R.id.bodyfatView);
        visericaltxt = findViewById(R.id.viserialView);
        resttxt = findViewById(R.id.restView);
        bmitxt = findViewById(R.id.bmiView);
        bodyagetxt = findViewById(R.id.bodyageView);
        wbstxt = findViewById(R.id.wbsView);
        trunkfattxt = findViewById(R.id.trunkfatView);
        armfattxt = findViewById(R.id.armfatView);
        legfattxt = findViewById(R.id.legfatView);
        skemustxt = findViewById(R.id.skemusView);
        trunkmustxt = findViewById(R.id.trunkmusView);
        armmustxt = findViewById(R.id.armmusView);
        legmustxt = findViewById(R.id.legmusView);
        savePdfButton = findViewById(R.id.savePdfBtn);

        myDB = new databasewc(Customer_report.this);

        // Get the name passed from Updatedata
        String name = getIntent().getStringExtra("EXTRA_NAME");
        if (name != null) {
            fetchAndDisplayData(name);
        }

        savePdfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Capture the image and generate the PDF, and save the image to the gallery
                captureAndSavePdfAndImage();
            }
        });
    }

    @SuppressLint("Range")
    private void fetchAndDisplayData(String name) {
        Cursor cursor = myDB.readDataByName(name);
        if (cursor != null && cursor.moveToFirst()) {
            // Fetch data from cursor
            nametxt.setText(cursor.getString(cursor.getColumnIndex("name")));
            mobtxt.setText(cursor.getString(cursor.getColumnIndex("mobile")));
            citytxt.setText(cursor.getString(cursor.getColumnIndex("city")));
            agetxt.setText(cursor.getString(cursor.getColumnIndex("age")));
            weighttxt.setText(cursor.getString(cursor.getColumnIndex("weight")));
            idealwtxt.setText(cursor.getString(cursor.getColumnIndex("ideal_weight")));
            extratxt.setText(cursor.getString(cursor.getColumnIndex("extra")));
            lesstxt.setText(cursor.getString(cursor.getColumnIndex("less")));
            bodyfattxt.setText(cursor.getString(cursor.getColumnIndex("body_fat")));
            visericaltxt.setText(cursor.getString(cursor.getColumnIndex("visceral_fat")));
            resttxt.setText(cursor.getString(cursor.getColumnIndex("resting_metabolism")));
            bmitxt.setText(cursor.getString(cursor.getColumnIndex("bmi")));
            bodyagetxt.setText(cursor.getString(cursor.getColumnIndex("body_age")));
            wbstxt.setText(cursor.getString(cursor.getColumnIndex("whole_body_subcutaneous")));
            trunkfattxt.setText(cursor.getString(cursor.getColumnIndex("trunk_fat")));
            armfattxt.setText(cursor.getString(cursor.getColumnIndex("arm_fat")));
            legfattxt.setText(cursor.getString(cursor.getColumnIndex("leg_fat")));
            skemustxt.setText(cursor.getString(cursor.getColumnIndex("skeletal_muscle")));
            trunkmustxt.setText(cursor.getString(cursor.getColumnIndex("trunk_muscle")));
            armmustxt.setText(cursor.getString(cursor.getColumnIndex("arm_muscle")));
            legmustxt.setText(cursor.getString(cursor.getColumnIndex("leg_muscle")));
            cursor.close();
        } else {
            nametxt.setText("No data found");
        }
    }

    private void captureAndSavePdfAndImage() {
        // Hide the savePdfButton
        savePdfButton.setVisibility(View.INVISIBLE);

        // Capture the activity content as a bitmap
        View contentView = findViewById(R.id.main); // Correct layout ID
        contentView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(contentView.getDrawingCache());
        contentView.setDrawingCacheEnabled(false);

        // Show the savePdfButton
        savePdfButton.setVisibility(View.VISIBLE);

        // Create the WellnessCoach directory if it doesn't exist
        File wellnessCoachDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "WellnessCoach");
        if (!wellnessCoachDir.exists()) {
            wellnessCoachDir.mkdirs();
        }

        // Create a new PdfDocument
        PdfDocument pdfDocument = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(bitmap.getWidth(), bitmap.getHeight(), 1).create();
        PdfDocument.Page page = pdfDocument.startPage(pageInfo);

        // Draw the bitmap onto the page
        Canvas canvas = page.getCanvas();
        canvas.drawBitmap(bitmap, 0, 0, null);

        pdfDocument.finishPage(page);

        // Save the PDF to the WellnessCoach folder
        File pdfFile = new File(wellnessCoachDir, "CustomerReport_" + Calendar.getInstance().getTimeInMillis() + ".pdf");
        try {
            pdfDocument.writeTo(new FileOutputStream(pdfFile));
            pdfDocument.close();
            // Notify the user
            Toast.makeText(this, "PDF saved" , Toast.LENGTH_LONG).show();
            // Save the image to the gallery
            saveImageToGallery(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to save PDF", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveImageToGallery(Bitmap bitmap) {
        // Save the image to the gallery
        File imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "CustomerReportImage_" + Calendar.getInstance().getTimeInMillis() + ".png");
        try {
            FileOutputStream fos = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();

            // Add the image to the gallery
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.DATA, imageFile.getAbsolutePath());
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
            getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

            Toast.makeText(this, "Image saved to gallery", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
        }
    }
}
