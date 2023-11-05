package com.example.myapplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;



import android.app.Activity;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class OrderApproval extends Activity {
	Button b1,b2;
	
	Spinner spnOrderId,spnStatus;
	SQLiteDatabase mydb=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_approval);
		
		b1=(Button)findViewById(R.id.btnSave);
		b2=(Button)findViewById(R.id.btnBack);
		
		mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
		mydb.execSQL("Create Table If Not Exists FoodDelivery(OrderId Varchar(10),CustomerId Varchar(10),CustomerName Varchar(15),DeliveryDate Varchar(20),Remark Varchar(10))");
		mydb.close();
	
		
		spnOrderId = (Spinner) findViewById(R.id.spnOrderId);
		mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
		Cursor cc=null;
		cc=mydb.rawQuery("Select OrderId,CustomerName,TotalAmount From OrderDetails A,Customer B Where A.CustomerId=B.CustomerId",null);
		cc.moveToFirst();
		ArrayList<String> CustId = new ArrayList<String>();
		CustId.add("Select");
		while(cc.isAfterLast()==false)
		{
			CustId.add(cc.getString(0) + ":" + cc.getString(1) + ":" + cc.getString(2));	
			cc.moveToNext();
		}
	    ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, CustId);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnOrderId.setAdapter(dataAdapter1);
	    cc.close();
        mydb.close();
		
        spnOrderId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          @Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			

				mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
           		Cursor c=mydb.rawQuery("Select OrderId From FoodDelivery Where OrderId='" + arg0.getSelectedItem().toString().split(":")[0] + "'", null);
				c.moveToFirst();
				while(c.isAfterLast()==false)
				{
					Toast.makeText(getApplicationContext(), "This order already delivered", 1000).show();					
					
					c.moveToNext();
				}
				c.close();
				mydb.close();	
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
				
			}
        });
        
		
        
        
        
        spnStatus= (Spinner) findViewById(R.id.spnStatus);
		
		ArrayList<String> FoodId = new ArrayList<String>();
		FoodId.add("Select");
			FoodId.add("Approve");	
			FoodId.add("Reject");
			FoodId.add("Pending");
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, FoodId);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnStatus.setAdapter(dataAdapter2);
        
        
        myListener1 m=new myListener1();
		b1.setOnClickListener((OnClickListener) m);
		b2.setOnClickListener((OnClickListener) m);
	
	/*	mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
		mydb.execSQL("Create Table If Not Exists OrderDetails(OrderId Varchar(10),Date Varchar(10),CustomerId Varchar(10), FoodId Varchar(20),FoodName Varchar(20),Price Varchar(10),Quantity Varchar(10),TotalAmount Varchar(10),OrderApproved Varchar(10),ApprovalDate Date,Cancellation Varchar(10),CancellationApproved Varchar(10))");
		mydb.close();
		*/
		/*mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
		Cursor c=mydb.rawQuery("Select Max(OrderId) From OrderDetails",null);
		c.moveToFirst();
		int count=0;
		if(c.isAfterLast()==false)
		{
			count=c.getInt(0);
		}
		c.close();
		
		mydb.close();*/
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.order_approval, menu);
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

	
	String orderid=spnOrderId.getSelectedItem().toString().split(":")[0];
	String status=spnStatus.getSelectedItem().toString();

	
	
	mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
	//mydb.execSQL("Delete From OrderDetails Where OrderId='" + s1 + "'");
	String entrydate="";
	
	java.util.Date d=new java.util.Date();
	java.text.SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
	//java.text.SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");

entrydate= sdf1.format(d);

	mydb.execSQL("Update OrderDetails Set OrderApproved='" + status + "',ApprovalDate='" + entrydate + "' Where OrderId='" +orderid + "'");
	Toast.makeText(getApplicationContext(), "Approval Status Details Saved", Toast.LENGTH_LONG).show();
	mydb.close();
	
	
	break;
	case R.id.btnBack:
	finish();
	break;
	}
		}
		catch(Exception e)
		{
			Toast.makeText(getApplicationContext(), e.getMessage(), 1000).show();
		}
	}
	}
	
}
