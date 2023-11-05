package com.example.myapplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DeliveryDetails extends Activity {
    Button b1,b2;
    EditText t1,t2;
	Spinner spnOrderId;
	SQLiteDatabase mydb=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delivery_details);
		
		b1=(Button)findViewById(R.id.btnSave);
		b2=(Button)findViewById(R.id.btnBack);
		
		t1=(EditText)findViewById(R.id.txtDate);
		t2=(EditText)findViewById(R.id.txtRemarks);
		
		
		//datetime
		java.util.Date d=new java.util.Date();
		java.text.SimpleDateFormat sdf1=new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		//java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");
		t1.setText(sdf1.format(d));
		//datetime
		
		
		mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
		mydb.execSQL("Create Table If Not Exists FoodDelivery(OrderId Varchar(10),CustomerId Varchar(10),CustomerName Varchar(15),DeliveryDate Varchar(30),Remark Varchar(50))");
		mydb.close();
		
		spnOrderId = (Spinner) findViewById(R.id.spnOrderId);
		mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
		Cursor cc=null;
		//cc=mydb.rawQuery("Select OrderId,CustomerId,CustomerName From OrderDetails A,Customer B Where A.CustomerId=B.CustomerId",null);
		
		cc=mydb.rawQuery("Select OrderId,CustomerId From OrderDetails where OrderApproved='Approve'",null);
		cc.moveToFirst();
		ArrayList<String> CustId = new ArrayList<String>();
		CustId.add("Select");
		while(cc.isAfterLast()==false)
		{
			CustId.add(cc.getString(0) + ":" + cc.getString(1));	
			cc.moveToNext();
		}
	    ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, CustId);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnOrderId.setAdapter(dataAdapter1);
	    cc.close();
        mydb.close();
		
		
       
        
        myListener1 m=new myListener1();
		b1.setOnClickListener((OnClickListener) m);
		b2.setOnClickListener((OnClickListener) m);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.delivery_details, menu);
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
		try
		{
	switch(v.getId())
	{
	case R.id.btnSave:
String s2=t2.getText().toString();
		if(s2.equals(""))
		{
			t2.requestFocus();
			return;
		}
	String orderid=spnOrderId.getSelectedItem().toString().split(":")[0];
	String custid=spnOrderId.getSelectedItem().toString().split(":")[1];
	
	//String custname=spnOrderId.getSelectedItem().toString().split(":")[2];
	String custname="";
	mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
	Cursor c=mydb.rawQuery("Select CustomerName From Customer where CustomerId='" + custid + "'",null);
	c.moveToFirst();
	
	if(c.isAfterLast()==false)
	{
		custname=c.getString(0);
	}
	c.close();
	mydb.close();
	
	
	
	
	
	mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
	mydb.execSQL("Delete From FoodDelivery Where OrderId='" + orderid + "'");


	mydb.execSQL("Insert into FoodDelivery Values('" + orderid + "','" + custid + "','" + custname + "','" + t1.getText().toString() + "','" + t2.getText().toString()  + "')");
	Toast.makeText(getApplicationContext(), "Delivery Details Saved", Toast.LENGTH_LONG).show();
	mydb.close();
	
	break;
	case R.id.btnBack:
	finish();
	break;
	}
		}
		catch(Exception e)
		{
			Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}
	}
}
