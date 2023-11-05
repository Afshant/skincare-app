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

public class CustomerRegister extends Activity {
	EditText t1,t2,t3,t4,t5;
	 Button b1,b2;
	 SQLiteDatabase mydb=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_register);
		
		t1=(EditText)findViewById(R.id.txtCustomerId);
		t2=(EditText)findViewById(R.id.txtCustomerName);
		t3=(EditText)findViewById(R.id.txtMobileNo);
		t4=(EditText)findViewById(R.id.txtAddress);
		t5=(EditText)findViewById(R.id.txtPassword);
		

		b1=(Button)findViewById(R.id.btnSave);
		b2=(Button)findViewById(R.id.btnBack);
		
			
		myListener1 m=new myListener1();
		b1.setOnClickListener((OnClickListener) m);
		b2.setOnClickListener((OnClickListener) m);
		

		mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
		mydb.execSQL("Create Table If Not Exists Customer(CustomerId Varchar(10),CustomerName Varchar(15),MobileNo Varchar(10),Address Varchar(10),Password Varchar(10))");

		Cursor c=mydb.rawQuery("Select Count(*) From Customer",null);
		c.moveToFirst();
		int count=0;
		if(c.isAfterLast()==false)
		{
			count=c.getInt(0);
		}
		c.close();

		t1.setText(new Integer(count+1).toString());

		mydb.close();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.customer_register, menu);
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
	if (s3.toString().length()!=10 || cls.isNum(s3.toString())==false) 
	{
	Toast.makeText(getApplicationContext(), "Must enter 10 digits & Numeric Values to Mobile No. ", Toast.LENGTH_LONG).show();
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
	
	mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
	mydb.execSQL("Delete From Customer Where CustomerId='" + s1 + "'");

//Cursor c=mydb.rawQuery("Select Count(*) From Customer",null);
//c.moveToFirst();
//int count=0;
//if(c.isAfterLast()==false)
//{
//	count=c.getInt(0);
//}
//c.close();
//t1.setText(new Integer(count+1).toString());
//s1=t1.getText().toString();

	mydb.execSQL("Insert into Customer Values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "')");
	Toast.makeText(getApplicationContext(), "Customer Details Saved", Toast.LENGTH_LONG).show();
	mydb.close();
	break;
	
	case R.id.btnBack:
	finish();
	break;
	}
	}
	}
}
