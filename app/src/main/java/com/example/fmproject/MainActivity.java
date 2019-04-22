package com.example.fmproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteHelper myDb;
    EditText editsite, editlocation, editcontact, edittel, editdescription;
    Button editbtnAdd, editbtnList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new SQLiteHelper(this);

        editsite=(EditText)findViewById(R.id.site);
        editlocation=(EditText)findViewById(R.id.location);
        editcontact=(EditText)findViewById(R.id.contact);
        edittel=(EditText)findViewById(R.id.tel);
        editdescription=(EditText)findViewById(R.id.description);
        editbtnAdd=(Button) findViewById(R.id.btnAdd);
        editbtnList=(Button) findViewById(R.id.btnList);
        AddData();
    }

    public void AddData(){
        editbtnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            boolean isInserted= myDb.insertData(editlocation.getText().toString(),
                                    editsite.getText().toString(),
                                    editcontact.getText().toString(),
                                    edittel.getText().toString(),
                                    editdescription.getText().toString() ) ;
                            if (isInserted =true)
                                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                 Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();


                    }
                }
        );
    }
}
