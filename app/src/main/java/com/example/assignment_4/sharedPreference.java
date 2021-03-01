package com.example.assignment_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class sharedPreference extends AppCompatActivity {
    EditText userName;
    EditText passWord;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        userName = (EditText) findViewById(R.id.userName);
        passWord = (EditText) findViewById(R.id.passWord);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        findViewById(R.id.btn_signIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Storing data into SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

                // Creating an Editor object to edit(write to the file)
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                // Storing the key and its value as the data fetched from edittext
                myEdit.putString("Username", userName.getText().toString());
                myEdit.putString("Password", passWord.getText().toString());
                boolean checked = checkBox.isChecked();
                myEdit.putBoolean("checkbox",checked);

                myEdit.commit();

                Toast.makeText(sharedPreference.this, "Data saved", Toast.LENGTH_SHORT).show();
            }
        });

            setData_to_edittext();




    }
    public void setData_to_edittext(){
            SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

            String Name = sh.getString("Username", "");
            String pWord = sh.getString("Password", "");
            Boolean status = sh.getBoolean("checkbox",false);
            // Setting the fetched data
            // in the EditTexts
            if (status==true)
            {
                userName.setText(Name);
                passWord.setText(pWord);
                checkBox.setChecked(true);
            }

    }
}