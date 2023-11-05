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

public class AdminLogin extends Activity {
	Button b1,b2;
	EditText t1,t2;
	SQLiteDatabase mydb=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_login);
		

		try
		{
		 mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
		mydb.execSQL("Create Table If not Exists Admin(UserName Varchar(15),Password Varchar(15))");
				
		mydb.execSQL("Delete From Admin");
		mydb.execSQL("insert into Admin values('Admin','Admin')");
		mydb.execSQL("insert into Admin values('cake','cake')");
		mydb.execSQL("insert into Admin values('a','a')");
		mydb.execSQL("insert into Admin values('admin','admin')");
		Cursor cr=mydb.rawQuery("Select Count(*) from Admin",null);
		cr.moveToFirst();
		int count=cr.getInt(0);
		cr.close();
		if(count==0)
		{
			
			mydb.execSQL("insert into Admin values('Admin','Admin')");
			mydb.execSQL("insert into Admin values('a','a')");
		}
	
		}
		catch(Exception ex)
		{
			mydb.execSQL("Create Table If not Exists Admin(UserName Varchar(15),Password Varchar(15))");
	
			mydb.execSQL("insert into Admin values('Admin','Admin')");
			mydb.execSQL("insert into Admin values('a','a')");
			
		}
		b1=(Button)findViewById(R.id.btnLogin);
		b2=(Button)findViewById(R.id.btnBack);
		t1=(EditText)findViewById(R.id.txtUserName);
		t2=(EditText)findViewById(R.id.txtPassword);
		myListener1 m=new myListener1();
		b1.setOnClickListener((OnClickListener) m);
		b2.setOnClickListener((OnClickListener) m);
		mydb.close();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.admin_login, menu);
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
	mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
	Cursor cr=mydb.rawQuery("Select Count(*) from Admin Where UserName='" +s1 + "' and Password='" + s2 + "'",null);
	cr.moveToFirst();
	int count=cr.getInt(0);
	cr.close();
	mydb.close();
	if(count>0)
		{
		cls.LoggedUserId=s1;
		cls.LoggedUserType="Admin";
		Intent i = new Intent(getApplicationContext(),AdminMenu.class);
	    startActivity(i);
		}
		else
		{
		Toast.makeText(getApplicationContext(), "UserName/Password is Wrong", Toast.LENGTH_LONG).show();
		}
	break;
	case R.id.btnBack:
		finish();
		break;
	}
	}
	}
}
