package com.example.lab5login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActvity extends AppCompatActivity {
    EditText username, password;
    Button signin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_actvity);
        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        signin = findViewById(R.id.btnsignin1);
        DB = new DBHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActvity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean check = DB.checkUsernamePassword(user, pass);
                    if (check){
                        Toast.makeText(LoginActvity.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),HomeActvity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActvity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}