package com.example.myapplication;


public class cls {
	public static String dbname="CakeOrderApp";
	public static String LoggedUserId="";
	public static String LoggedUserType="";
	public static String selectedproductcode="";
/////////////////////isNum
public static boolean isNum(String strNum)
{
boolean ret=true;
try
{
Double.parseDouble(strNum);
}catch(NumberFormatException e)
{
ret=false;	
}
return ret;
}
////////////////isNum
}

