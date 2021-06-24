package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    TextView txtName;
    EditText edtName, edtPasswd;
    Button btnSubmit;
    CheckBox isCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtName = findViewById(R.id.edt_name);
        edtPasswd = findViewById(R.id.edt_passwd);
        btnSubmit = findViewById(R.id.btn_submit);
        txtName = findViewById(R.id.txt_output);
        isCheck=findViewById(R.id.is_check);
        Boolean checking=isCheck.isChecked();
        if(checking)
        {
            btnSubmit.setVisibility(View.VISIBLE);
        }
        else{
            btnSubmit.setVisibility(View.INVISIBLE);
        }


        Intent intent = getIntent();
        edtName.setText(intent.getStringExtra("usr_name"));
        edtPasswd.setText(intent.getStringExtra("usr_passwd"));

        Log.d("Signing in", "Sign up by "+edtName.getText().toString());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String passwd = edtPasswd.getText().toString();
                Toast.makeText(getApplicationContext(), name+" "+passwd, Toast.LENGTH_SHORT).show();
                txtName.setText("Name: "+name+"\nPassword: "+passwd);
                /*Intent intent = new Intent(getApplicationContext(), Signup.class);
                intent.putExtra("username", name);
                intent.putExtra("password", passwd);
                startActivity(intent);*/
            }
        });
    }

}