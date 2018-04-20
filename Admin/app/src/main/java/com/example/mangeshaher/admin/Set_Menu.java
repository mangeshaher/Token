package com.example.mangeshaher.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Set_Menu extends AppCompatActivity {

    EditText it11,it12,it21,it22,it31,it32,it41,it42,it51,it52,it61,it62,it71,it72;
    Button ibtn;
    private DatabaseReference root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set__menu);
        it11 = (EditText) findViewById(R.id.it11);
        it21 = (EditText) findViewById(R.id.it21);
        it31 = (EditText) findViewById(R.id.it31);
        it41 = (EditText) findViewById(R.id.it41);
        it51 = (EditText) findViewById(R.id.it51);
        it61 = (EditText) findViewById(R.id.it61);
        it71 = (EditText) findViewById(R.id.it71);
        it12 = (EditText) findViewById(R.id.it12);
        it22 = (EditText) findViewById(R.id.it22);
        it32 = (EditText) findViewById(R.id.it32);
        it42 = (EditText) findViewById(R.id.it42);
        it52 = (EditText) findViewById(R.id.it52);
        it62 = (EditText) findViewById(R.id.it62);
        it72 = (EditText) findViewById(R.id.it72);
        ibtn = (Button) findViewById(R.id.ibtn);
        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day1");
                DatabaseReference ch11 = root.child("Item1");
                DatabaseReference ch12 = root.child("Item2");
                ch11.setValue(it11.getText().toString());
                ch12.setValue(it12.getText().toString());
                root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day2");
                DatabaseReference ch21 = root.child("Item1");
                DatabaseReference ch22 = root.child("Item2");
                ch21.setValue(it21.getText().toString());
                ch22.setValue(it22.getText().toString());
                root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day3");
                DatabaseReference ch31 = root.child("Item1");
                DatabaseReference ch32 = root.child("Item2");
                ch31.setValue(it31.getText().toString());
                ch32.setValue(it32.getText().toString());
                root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day4");
                DatabaseReference ch41 = root.child("Item1");
                DatabaseReference ch42 = root.child("Item2");
                ch41.setValue(it41.getText().toString());
                ch42.setValue(it42.getText().toString());
                root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day5");
                DatabaseReference ch51 = root.child("Item1");
                DatabaseReference ch52 = root.child("Item2");
                ch51.setValue(it51.getText().toString());
                ch52.setValue(it52.getText().toString());
                root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day6");
                DatabaseReference ch61 = root.child("Item1");
                DatabaseReference ch62 = root.child("Item2");
                ch61.setValue(it61.getText().toString());
                ch62.setValue(it62.getText().toString());
                root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day7");
                DatabaseReference ch71 = root.child("Item1");
                DatabaseReference ch72 = root.child("Item2");
                ch71.setValue(it71.getText().toString());
                ch72.setValue(it72.getText().toString());
                Toast.makeText(getApplicationContext(), "Menu Set Successfully!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
