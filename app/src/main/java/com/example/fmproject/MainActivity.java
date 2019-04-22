package com.example.fmproject;

import android.app.AlertDialog;
import android.database.Cursor;
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
        listAll();
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

    public void listAll(){
          editbtnList.setOnClickListener(
                  new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          Cursor res = myDb.getAllData();
                            if (res.getCount()==0){
                                // show message
                                showMessage ("Error", "nothign foud");
                                return ;
                            }

                            StringBuffer buffer =new StringBuffer();
                            while (res.moveToNext()){
                                buffer.append("id:"+res.getString(0)+"\n");
                                buffer.append("location:"+res.getString(1)+"\n");
                                buffer.append("site:"+res.getString(2)+"\n");
                                buffer.append("contact:"+res.getString(3)+"\n");
                                buffer.append("tel:"+res.getString(4)+"\n");
                                buffer.append("description:"+res.getString(5)+"\n\n");

                            }

                            // show all data
                          showMessage("data", buffer.toString());


                      }
                  }
          );
    }

    public void showMessage (String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
      }

}
