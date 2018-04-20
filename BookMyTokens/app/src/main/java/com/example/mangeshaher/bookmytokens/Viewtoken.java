package com.example.mangeshaher.bookmytokens;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Viewtoken extends AppCompatActivity {


    private DatabaseReference dr ;
    ImageView qrCode;
    public String urll,date,stid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtoken);
        qrCode=(ImageView)findViewById(R.id.qrimage);
        java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("dd MMMM yyyy");
        long dt = System.currentTimeMillis();
        Date d1 = new Date(dt+86400000);
        date = sf.format(d1);
        Bundle bun = getIntent().getExtras();
        stid = bun.getString("id");
        String url = "https://bookmytokens-a94d3.firebaseio.com/Admin/";
        urll = url.concat(stid).concat("/").concat(date);
        dr = FirebaseDatabase.getInstance().getReferenceFromUrl(urll);
    }

    @Override
    protected void onStart(){
        super.onStart();
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Container to_it1 = dataSnapshot.getValue(Container.class);
                String to_pass = stid.concat(",").concat(date).concat(",").concat(to_it1.getItem1()).concat(",").concat(to_it1.getItem2());
                System.out.println(to_pass);
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(to_pass, BarcodeFormat.QR_CODE,400,400);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    qrCode.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
