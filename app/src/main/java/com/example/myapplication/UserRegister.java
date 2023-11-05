package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityUserRegisterBinding;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UserRegister extends AppCompatActivity {
    EditText t1,t2,t3,t4,t5,t6,t7,t9,t10,t11,t12;
    Button b1,b2;
    SQLiteDatabase mydb=null;

    private AppBarConfiguration appBarConfiguration;
    private ActivityUserRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_user_register);

        t1=(EditText)findViewById(R.id.txtUserId);
        t2=(EditText)findViewById(R.id.txtUserName);
        t3=(EditText)findViewById(R.id.txtAge);
        t4=(EditText)findViewById(R.id.txtDoorNo);
        t5=(EditText)findViewById(R.id.txtStreet);
        t6=(EditText)findViewById(R.id.txtCity);
        t7=(EditText)findViewById(R.id.txtLandMark);

        t9=(EditText)findViewById(R.id.txtZipCode);
        t10=(EditText)findViewById(R.id.txtMailId);
        t11=(EditText)findViewById(R.id.txtMobileNo);
        t12=(EditText)findViewById(R.id.txtPassword);

        b1=(Button)findViewById(R.id.btnSave);
        b2=(Button)findViewById(R.id.btnBack);

        myListener1 m=new myListener1();
        b1.setOnClickListener((OnClickListener) m);
        b2.setOnClickListener((OnClickListener) m);


        mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
        mydb.execSQL("Create Table If Not Exists User(UserId Varchar(10),UserName Varchar(15),Age Varchar(50),DoorNo Varchar(50),Street Varchar(50),City Varchar(50),LandMark Varchar(50),ZipCode Varchar(50),MailId Varchar(50),Mobile Varchar(50),Password Varchar(50))");

        Cursor c=mydb.rawQuery("Select Count(*) From User",null);
        c.moveToFirst();
        int count=0;
        if(c.isAfterLast()==false)
        {
            count=c.getInt(0);
        }
        c.close();
//mydb.close();
        t1.setText(new Integer(count+1).toString());

        mydb.close();

/*        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_register);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
  */
    }

    @Override
    public boolean onSupportNavigateUp() {
        return true;
      /*  NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_register);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    */}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.user_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    class myListener1 implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            //TODO Auto-generated method stub

            switch(v.getId())
            {
                case R.id.btnSave:



                    String s1=t1.getText().toString();
                    String s2=t2.getText().toString();
                    String s3=t3.getText().toString();
                    String s4=t4.getText().toString();
                    String s5=t5.getText().toString();
                    String s6=t6.getText().toString();
                    String s7=t7.getText().toString();

                    String s9=t9.getText().toString();
                    String s10=t10.getText().toString();
                    String s11=t11.getText().toString();
                    String s12=t12.getText().toString();





                    if(s1.equals(""))
                    {
                        t1.requestFocus();
                        return;
                    }
                    if(s2.equals(""))
                    {
                        t2.requestFocus();
                        return;
                    }
                    if(s3.equals(""))
                    {
                        t3.requestFocus();
                        return;
                    }
                    if(s4.equals(""))
                    {
                        t4.requestFocus();
                        return;
                    }

                    if(s5.equals(""))
                    {
                        t5.requestFocus();
                        return;
                    }

                    if(s6.equals(""))
                    {
                        t6.requestFocus();
                        return;
                    }
                    if(s7.equals(""))
                    {
                        t7.requestFocus();
                        return;
                    }

                    if(s9.equals(""))
                    {
                        t9.requestFocus();
                        return;
                    }

                    if (s11.toString().length()!=10 || cls.isNum(s11.toString())==false)
                    {
                        Toast.makeText(getApplicationContext(), "Must enter 10 digits & Numeric Values to Mobile No. ", Toast.LENGTH_LONG).show();
                        t11.requestFocus();
                        return;
                    }
                    if(s11.equals(""))
                    {
                        t11.requestFocus();
                        return;
                    }
                    if (s12.toString().length()< 8 )
                    {
                        Toast.makeText(getApplicationContext(), "Must enter minimum 8 digits to Password", Toast.LENGTH_LONG).show();
                        t12.requestFocus();
                        return;
                    }
                    mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
                    mydb.execSQL("Delete From User Where UserId='" + s1 + "'");

                    Cursor c=mydb.rawQuery("Select Count(*) From User",null);
                    c.moveToFirst();
                    int count=0;
                    if(c.isAfterLast()==false)
                    {
                        count=c.getInt(0);
                    }
                    c.close();
//mydb.close();
                    t1.setText(new Integer(count+1).toString());
                    s1=t1.getText().toString();
//mydb.execSQL("Delete From User Where UserId='1'");
//mydb.execSQL("Delete From User Where UserId='2'");
                    mydb.execSQL("Insert into User Values('" + s1 + "','" + s2 + "','" + s3 + "','" +s4 +"','" +s5 +"','" +s6 +"','" + s7 + "','" + s9 + "','" +s10 +"','" +s11 +"','" +s12 +"')");
                    Toast.makeText(getApplicationContext(), "User Details Saved", Toast.LENGTH_LONG).show();
                    mydb.close();
                    break;
                case R.id.btnBack:
                    finish();
                    break;
            }
        }
    }

}