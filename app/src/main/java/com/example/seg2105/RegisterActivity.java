package com.example.seg2105;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    ImageButton btn1;
    Button btn2, btn3;
    TextInputEditText email, password, username, age, phonenumber;
    DBHelper DB;
    CheckBox check;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn1 = findViewById(R.id.back_button_r);
        btn2 = findViewById(R.id.login_r);
        btn3 = findViewById(R.id.register_r);
        email = findViewById(R.id.enterEmail_r);
        password = findViewById(R.id.enterPassword_r);
        username = findViewById(R.id.enterUsername_r);
        age = findViewById(R.id.enterAge_r);
        phonenumber = findViewById(R.id.enterPhoneNum_r);
        check = findViewById(R.id.check);
        DB = new DBHelper(this);
        AddData();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);

            }
        });

    }

    public boolean isInteger(String s) {

        try {

            Integer.parseInt(s);

        }   catch (NumberFormatException e) {

            return false;

        }   catch (NullPointerException e) {

            return false;

        }

        return true;

    }

    public void AddData() {

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean insert = DB.insertData(username.getText().toString(), password.getText().toString()
                        , email.getText().toString());
                if(insert) {

                    Toast.makeText(RegisterActivity.this, "Succeed", Toast.LENGTH_LONG).show();

                }   else {

                    Toast.makeText(RegisterActivity.this, "Failed", Toast.LENGTH_LONG).show();

                }

            }
        });

    }

}


