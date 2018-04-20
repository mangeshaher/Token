package com.example.mangeshaher.bookmytokens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    private EditText studentid;
    private EditText editTextPassword;
    private Button buttonSignin;
    private DatabaseReference mrootref,nrootref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        studentid =(EditText)findViewById(R.id.studentid);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSignin = (Button) findViewById(R.id.buttonSignin);
        final String url = "https://bookmytokens-a94d3.firebaseio.com/Users";
        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String key = studentid.getText().toString();
                final String val1 = editTextPassword.getText().toString();
                String urll = url.concat("/").concat(key).concat("/").concat("password");;
                nrootref = FirebaseDatabase.getInstance().getReferenceFromUrl(urll);
                nrootref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        try{
                            String pass = dataSnapshot.getValue().toString();
                            System.out.println(pass);
                            if((val1!= null && !val1.isEmpty())&&(key != null && !key.isEmpty())&&pass.equals(val1)){
                                Toast.makeText(getApplicationContext(), "Logged In Successfully!",
                                        Toast.LENGTH_LONG).show();
                                Intent i = new Intent(Login.this, Profile.class);
                                Bundle bun = new Bundle();
                                bun.putString("id",key);
                                i.putExtras(bun);
                                startActivity(i);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Error!",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                        catch (Exception e ){
                            String x = e.toString();
                            Toast.makeText(getApplicationContext(), "Logged In Error!"+x,
                                    Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
