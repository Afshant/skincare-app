
public class cls {
    public static String dbname="SmartHealthCare";
    public static String LoggedUserId="";
    public static String LoggedUserType="";
    public static int viewtype;
    public static String MobileNo="";

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
