package com.example.nikki.plunochecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private SQLiteHelper sQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        sQLiteHelper = new SQLiteHelper(AddActivity.this);

        final EditText editTextBrand = (EditText) findViewById(R.id.editTextBrand);
        final EditText editTextProductName = (EditText) findViewById(R.id.editTextProductName);
        final EditText editTextSKU = (EditText) findViewById(R.id.editTextSKU);
        final EditText editTextPLU = (EditText) findViewById(R.id.editTextPLU);
        Button buttonAdd = (Button) findViewById(R.id.buttonadd);

        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String Brand = editTextBrand.getText().toString();
                String ProductName = editTextProductName.getText().toString();
                String SKU = editTextSKU.getText().toString();
                String PLU = editTextPLU.getText().toString();

                Fresh Product = new Fresh(Brand,ProductName, SKU, PLU);

                sQLiteHelper.insertRecord(Product);
        }

        });



    }
}
