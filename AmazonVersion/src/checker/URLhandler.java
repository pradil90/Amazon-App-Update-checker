package checker;

public class URLhandler {
	
	public String AppURl;
	public String Appname;
	public String currentVersion;
	
	
	URLhandler()
	{
		AppURl="";
		Appname="";
	}
		
	URLhandler(String URLname,String appName)
	{
		AppURl=URLname;
		Appname=appName;
	}
	
	
	URLhandler(String URLname,String appname,String Latestversion)
	{
		AppURl=appname;
		Appname=URLname;
		currentVersion=Latestversion;
	}
	
	
	public void checkalert()
	{
		 SendEmail connector=new SendEmail();
		 connector.mail();
	}
	
	
	
	public String getAppName(){
		return Appname;
	}
	
	public String getAppURL(){
		return AppURl;
	}
	
	public String getLatestVersion(){
		return currentVersion;
	}
	
	
}//End of class URLhandler//



