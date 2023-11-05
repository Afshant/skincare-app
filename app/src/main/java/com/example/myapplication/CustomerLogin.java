package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
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

public class CustomerLogin extends Activity {
	Button b1,b2;
	EditText t1,t2;
	SQLiteDatabase mydb=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_login);
		
		t1=(EditText)findViewById(R.id.txtUserName);
		t2=(EditText)findViewById(R.id.txtPassword);
		b1=(Button)findViewById(R.id.btnLogin);
		b2=(Button)findViewById(R.id.btnBack);
		myListener1 m=new myListener1();
		b1.setOnClickListener((OnClickListener) m);
		b2.setOnClickListener((OnClickListener) m);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.customer_login, menu);
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
	// TODO Auto-generated method stub
switch(v.getId())
{
case R.id.btnLogin:

	String s1=t1.getText().toString();
	String s2=t2.getText().toString();
	mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
	Cursor cr=mydb.rawQuery("Select Count(*) from Customer Where CustomerId='" +s1 + "' and Password='" + s2 + "'",null);
	cr.moveToFirst();
	int count=cr.getInt(0);
	cr.close();
	mydb.close();
	if(count>0)
		{

		cls.LoggedUserId=s1;
		cls.LoggedUserType="Customer";
		Intent i = new Intent(getApplicationContext(),CustomerMenu.class);
	    startActivity(i);
		}
		else
		{
			Toast.makeText(getApplicationContext(), "Invalid Customer Id/Password", Toast.LENGTH_LONG).show();
		}
	break;
	
	case R.id.btnBack:
		finish();
		break;
	}
	}
}
}
