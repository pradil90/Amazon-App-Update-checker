/**
     * Programmed by PRADEEP IVAN BOSCO
     * Programming language:Java
     * App/Tool name:Amazon Version checker
     */

package checker;

import java.io.*;
import java.io.ObjectInputStream.GetField;
import java.lang.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
import java.util.StringTokenizer;

import static java.lang.System.exit;
/**
 *
 * @author pradeep Ivan Bosco
 */

public class Amazon {
     
    
	 String Latestversion="";
	static String data;
	static String inputLine;
	static String lineresult="";
	static String updateflag="";
	static URLhandler facebook,netflix,roku,youtube,twitter,pandora,mailer;
	static String facebookresult,netflixresult,youtuberesult,rokuresult,twitterresult,pandoraresult;
	 static boolean result;
	 static String facebookver,facebookcurrent,Latestfacebook;
	 static String netflixver, netflixcurrent,Latestneflix;
	 static String rokuver, rokucurrent,latestroku;
	 static String youtubever,youtubecurrent,latestyoutube;
	 static String twitterver,twittercurrent,latesttwitter;
	 static String pandoraver,pandoracurrent,latestpandora;
	 static String updatecheck;
	 
	 

	
//    public static void main(String[] args) {
        
	 public static void tasker(){
    	
       
                System.out.println("List of Amazon Apps supported by Amazon Version Checker tool Version.1.2:");
              
                System.out.println("[1] FACEBOOK : http://www.amazon.com/Facebook/dp/B0094BB4TW");
                facebook=new URLhandler("http://www.amazon.com/Facebook/dp/B0094BB4TW","facebook");
                facebookver="Version: 18.0.0.24.14";
           
                
                System.out.println("[2] NETFLIX  : http://www.amazon.com/Netflix-Inc/dp/B005ZXWMUS");
                netflix=new URLhandler("http://www.amazon.com/Netflix-Inc/dp/B005ZXWMUS","netflix");
                netflixver="Version: 3.7.2";
                
                System.out.println("[3] You Tube  : http://www.amazon.com/youtube-com-YouTube/dp/B00I0GS2SS");
                youtube=new URLhandler("http://www.amazon.com/youtube-com-YouTube/dp/B00I0GS2SS","YouTube");
                youtubever="Version: 1.0.6";
                
                System.out.println("[4] ROKU  : http://www.amazon.com/Roku-Inc/dp/B007K8RFJ4");
                roku=new URLhandler("http://www.amazon.com/Roku-Inc/dp/B007K8RFJ4","Roku");
                rokuver="Version: 3.1.4.2117542";
                
                System.out.println("[5] Twitter  : http://www.amazon.com/Twitter-Inc/dp/B004SOR4H6");
                twitter=new URLhandler("http://www.amazon.com/Twitter-Inc/dp/B004SOR4H6","twitter");
                twitterver="Version: 5.29.0";
                
                
                System.out.println("[6] Pandora  : http://www.amazon.com/Pandora-Media/dp/B005V1N71W");
                pandora=new URLhandler("http://www.amazon.com/Pandora-Media/dp/B005V1N71W","Pandora");
                pandoraver="Version: 5.4";
                
                //Running version check for App-Facebook//
                while(Latestfacebook==null){
                Latestfacebook=connector(facebook.getAppURL());
                }
                facebook=new URLhandler(facebook.getAppName(),facebook.getAppURL(),Latestfacebook);
                facebookcurrent=facebook.getLatestVersion();
                 updateflag=comparator(facebookver,facebookcurrent);
                 
                	 
                
                facebookresult="App name:" + facebook.getAppName() + "  " +  facebook.getLatestVersion() + "  " +  updateflag;
                System.out.println( facebookresult );
               
                //Running version check for App-Netflix//
                while(Latestneflix==null){
                Latestneflix=connector(netflix.getAppURL());
                }
                netflix=new URLhandler(netflix.getAppName(),netflix.getAppURL(),Latestneflix);
                netflixcurrent=netflix.getLatestVersion();
                 updateflag=comparator(netflixver,netflixcurrent);
                netflixresult="App name:" + netflix.getAppName() + "  " +  netflix.getLatestVersion() + "  " +  updateflag;
                System.out.println( netflixresult );

                //Running version check for App-You tube//
                while(latestyoutube==null){
                latestyoutube=connector(youtube.getAppURL());
                }
                youtube=new URLhandler(youtube.getAppName(),youtube.getAppURL(),latestyoutube);
                youtubecurrent=youtube.getLatestVersion();
                 updateflag=comparator(youtubever,youtubecurrent);
                youtuberesult="App name:" + youtube.getAppName() + "  " +  youtube.getLatestVersion() + "  " +  updateflag;
                System.out.println( youtuberesult );
         
                //Running version check for App-Roku//
                while(latestroku==null){
                latestroku=connector(roku.getAppURL());
                }
                roku=new URLhandler(roku.getAppName(),roku.getAppURL(),latestroku);
                rokucurrent=roku.getLatestVersion();
                 updateflag=comparator(rokuver,rokucurrent);
                rokuresult="App name:" + roku.getAppName() + "  " +  roku.getLatestVersion() + "  " +  updateflag;
                System.out.println( rokuresult );
                
                //Running version check for App-Twitter//
                while(latesttwitter==null){
                latesttwitter=connector(twitter.getAppURL());
                }
                twitter=new URLhandler(twitter.getAppName(),twitter.getAppURL(),latesttwitter);
                twittercurrent=twitter.getLatestVersion();
                 updateflag=comparator(twitterver,twittercurrent);
                twitterresult="App name:" + twitter.getAppName() + "  " +  twitter.getLatestVersion() + "  " +  updateflag;
                System.out.println( twitterresult );
                
                //Running version check for App-Pandora//
                while(latestpandora==null){
                latestpandora=connector(pandora.getAppURL());
                }
                pandora=new URLhandler(pandora.getAppName(),pandora.getAppURL(),latestpandora);
                pandoracurrent=pandora.getLatestVersion();
                 updateflag=comparator(pandoraver,pandoracurrent);
                pandoraresult="App name:" + pandora.getAppName() + "  " +  pandora.getLatestVersion() + "  " +  updateflag;
                System.out.println( pandoraresult );
               
                facebook.checkalert();
                  
    }         
                 
     public static String connector(String URLinput)
     {            
                 
		try 
		{
			//Opening a socket connection to Amazon web server//
		
                        URL myURL = new URL(URLinput);
                        
			//printing the values parsed from the new created object 
			System.out.println("Host = " + myURL.getHost());
			System.out.println("File = " + myURL.getFile());
			System.out.println("protocol = " + myURL.getProtocol());
            
            //creating an open stream object to stream the contents of the URL directly.
            BufferedReader dis = new BufferedReader(new InputStreamReader(myURL.openStream()));
			
            
			while ((inputLine = dis.readLine()) != null)
			{
                                String searchStr = inputLine;
                                
                            int indexOf = searchStr.indexOf("Version:");
                            if (indexOf > 0)
                                break;
			}
                        System.out.println();
                        System.out.println();
                        lineresult=inputLine;
                        data=trimmer(lineresult);
                  	dis.close();
		}//Error handling for URL and IO exceptions//
        catch (MalformedURLException me)
		{
			System.out.println("MalformedURLException: " + me);
		}
		catch (IOException ioe)
		{
			System.out.println("IOException: " + ioe);
			data=null;
		}
		
		
		
		return data;
    }	
     
     //Function to extract version details from the buffer//
     public static String trimmer(String lineresult){
                
		String result=lineresult.replaceAll("\\<.*?>","");
				//Removing extra white spaces//
				String result2=result.trim();
                System.out.println("Latest "+result.trim());
               
                return result2;
     }      
       
     //Function to check version change//
	public static String comparator(String inp1,String inp2)
	{
		
		System.out.println(inp1);
		System.out.println(inp2);
		if(inp2!=null){
		result=inp1.equals(inp2);
		System.out.println(result);
		}else{
			updatecheck="Server error:check in next run";
			return updatecheck;
		}
		
		if(result){
			updatecheck="Upto date!!";
		}else{
			updatecheck="New version AVAILABLE!!";
		}
		return updatecheck;
	}
}//End of class Amazon//



	
	



