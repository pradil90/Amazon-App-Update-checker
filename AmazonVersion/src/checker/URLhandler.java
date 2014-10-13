package checker;


public class URLhandler {
	
	private String AppURl;
	private String Appname;
	private String currentVersion;
	
	//Default constructor initialized with default values//
	URLhandler()
	{
		AppURl="";
		Appname="";
	}
		
	//Initializing constructor with arguments//
	URLhandler(String URLname,String appName)
	{
		AppURl=URLname;
		Appname=appName;
	}
	
	//Constructor initialized when three arguments is used//
	URLhandler(String URLname,String appname,String Latestversion)
	{
		AppURl=appname;
		Appname=URLname;
		currentVersion=Latestversion;
	}
	
	//Function to send the report to mail//
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



