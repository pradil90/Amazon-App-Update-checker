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
import java.util.Scanner;
import java.util.regex.*;
import java.util.StringTokenizer;

import static java.lang.System.exit;
/**
 *
 * @author pradeep Ivan Bosco
 */

public class Amazon {
     
    
	static String Latestversion;
	static String data;
	static String inputLine;
	static String lineresult="";
	static String updateflag="";
	static URLhandler facebook,netflix,roku,youtube,twitter,pandora,mailer;
	static String facebookresult,netflixresult,youtuberesult,rokuresult,twitterresult,pandoraresult;
	 static boolean result;
	 static String facebookver,facebookcurrent;
	 static String netflixver, netflixcurrent;
	 static String rokuver, rokucurrent;
	 static String youtubever,youtubecurrent;
	 static String twitterver,twittercurrent;
	 static String pandoraver,pandoracurrent;
	 static String updatecheck;
	
    public static void main(String[] args) {
        
        
        
       
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
                twitter=new URLhandler("http://www.amazon.com/Twitter-Inc/dp/B004SOR4H6","netflix");
                twitterver="Version: 5.29.0";
                
                
                System.out.println("[6] Pandora  : http://www.amazon.com/Pandora-Media/dp/B005V1N71W");
                pandora=new URLhandler("http://www.amazon.com/Pandora-Media/dp/B005V1N71W","Pandora");
                pandoraver="Version: 5.4";
                
                //Facebook//
                Latestversion=connector(facebook.getAppURL());
                facebook=new URLhandler(facebook.getAppName(),facebook.getAppURL(),Latestversion);
                facebookcurrent=facebook.getLatestVersion();
                 updateflag=comparator(facebookver,facebookcurrent);
                facebookresult="App name:" + facebook.getAppName() + "  " +  facebook.getLatestVersion() + "  " +  updateflag;
                System.out.println( facebookresult );
               
                //Netflix//
                Latestversion=connector(netflix.getAppURL());
                netflix=new URLhandler(netflix.getAppName(),netflix.getAppURL(),Latestversion);
                netflixcurrent=netflix.getLatestVersion();
                 updateflag=comparator(netflixver,netflixcurrent);
                netflixresult="App name:" + netflix.getAppName() + "  " +  netflix.getLatestVersion() + "  " +  updateflag;
                System.out.println( netflixresult );

                //You tube//
                Latestversion=connector(youtube.getAppURL());
                youtube=new URLhandler(youtube.getAppName(),youtube.getAppURL(),Latestversion);
                youtubecurrent=youtube.getLatestVersion();
                 updateflag=comparator(youtubever,youtubecurrent);
                youtuberesult="App name:" + youtube.getAppName() + "  " +  youtube.getLatestVersion() + "  " +  updateflag;
                System.out.println( youtuberesult );
         
                //Roku//
                Latestversion=connector(roku.getAppURL());
                roku=new URLhandler(roku.getAppName(),roku.getAppURL(),Latestversion);
                rokucurrent=roku.getLatestVersion();
                 updateflag=comparator(rokuver,rokucurrent);
                rokuresult="App name:" + roku.getAppName() + "  " +  roku.getLatestVersion() + "  " +  updateflag;
                System.out.println( rokuresult );
                
                //Twitter//
                Latestversion=connector(twitter.getAppURL());
                twitter=new URLhandler(twitter.getAppName(),twitter.getAppURL(),Latestversion);
                twittercurrent=twitter.getLatestVersion();
                 updateflag=comparator(twitterver,twittercurrent);
                twitterresult="App name:" + twitter.getAppName() + "  " +  twitter.getLatestVersion() + "  " +  updateflag;
                System.out.println( twitterresult );
                
                //Pandora//
                Latestversion=connector(pandora.getAppURL());
                pandora=new URLhandler(pandora.getAppName(),pandora.getAppURL(),Latestversion);
                pandoracurrent=pandora.getLatestVersion();
                 updateflag=comparator(facebookver,facebookcurrent);
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
                  	dis.close();
		}
        catch (MalformedURLException me)
		{
			System.out.println("MalformedURLException: " + me);
		}
		catch (IOException ioe)
		{
			System.out.println("IOException: " + ioe);
		}
		
		data=trimmer(lineresult);
		
		return data;
    }	
     
     public static String trimmer(String lineresult){
                
		String result=lineresult.replaceAll("\\<.*?>","");
				String result2=result.trim();
                System.out.println("Latest "+result.trim());
               
                return result2;
     }      
                
	public static String comparator(String inp1,String inp2)
	{
		
		System.out.println(inp1);
		System.out.println(inp2);
		result=inp1.equals(inp2);
		System.out.println(result);
		if(result){
			updatecheck="Already Upto date";
		}else{
			updatecheck="New version AVAILABLE";
		}
		return updatecheck;
	}
		
	
    
  
}//End of class Amazon//



	
	



