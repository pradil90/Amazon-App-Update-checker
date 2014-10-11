package checker;

import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.Scanner;
import java.util.regex.*;
import java.util.StringTokenizer;
import static java.lang.System.exit;
/**
 *
 * @author pradil90
 */

public class Amazon {
     
    /**
     * @param args the command line arguments
     * 
     */
	static String data;
	static String appversion;
	public static void checkalert()
	{
		 SendEmail connector=new SendEmail();
		 connector.mail(Amazon.data,Amazon.appversion);
		 System.out.println(Amazon.data);
	}
    public static void main(String[] args) {
        
        String inputLine;
        String lineresult="";
       
                System.out.println("List of Amazon App supported by this tool Version.1.0:");
                
                System.out.println("[1] FACEBOOK : http://www.amazon.com/Facebook/dp/B0094BB4TW/ref=sr_1_1?ie=UTF8&qid=1412390279&sr=8-1&keywords=facebook");
                System.out.println("[2] NETFLIX  : http://www.amazon.com/Netflix-Inc-Kindle-Fire-v1/dp/B00KHEEZT6/ref=sr_1_2?s=mobile-apps&ie=UTF8&qid=1412403256&sr=1-2&keywords=Netflix");
                System.out.println("[3] You Tube : http://www.amazon.com/Voyage-Apps-Free-vTube-YouTube/dp/B00B7Y0206/ref=sr_1_1?s=mobile-apps&ie=UTF8&qid=1412403307&sr=1-1&keywords=you+tube");
                System.out.println("[4] ROKU     : http://www.amazon.com/gp/product/B007K8RFJ4/ref=s9_hps_bw_g405_i2?pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-7&pf_rd_r=06SJM9ABQDRPEBN5FTWX&pf_rd_t=101&pf_rd_p=1630881202&pf_rd_i=2478843011");
                System.out.println("[5] TWITTER  : http://www.amazon.com/Twitter-Inc/dp/B004SOR4H6/ref=sr_1_1_ha?s=mobile-apps&ie=UTF8&qid=1412403558&sr=1-1&keywords=twitter");
                System.out.println("[6] Pandora  : http://www.amazon.com/Pandora-Media/dp/B005V1N71W/ref=sr_1_1_ha?s=mobile-apps&ie=UTF8&qid=1412403600&sr=1-1&keywords=pandora");
                System.out.println("[7] Subway Surfers : http://www.amazon.com/gp/product/B009UX2YAC/ref=s9_dcbhz_bw_g405_i3_sh?pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-8&pf_rd_r=0T20H4ZM29VT1S2CVM8K&pf_rd_t=101&pf_rd_p=1627541382&pf_rd_i=2350149011");
                System.out.println("Please enter the application URL for version check:");
                 Scanner scanner = new Scanner( System.in );
                 String input = scanner.nextLine();
                 System.out.println( "input = " + input );
                 appversion=input;
		try 
		{
			//Creating URL object specified.
//		
                        URL myURL = new URL(input);
                        
			//printing the values parsed from the new created object 
			System.out.println("Host = " + myURL.getHost());
			System.out.println("Port = " + myURL.getPort());
			System.out.println("File = " + myURL.getFile());
			System.out.println("Reference = " + myURL.getRef());
			System.out.println("protocol = " + myURL.getProtocol());
            
            //creating an open stream object to stream the contents of the URL directly.
            BufferedReader dis = new BufferedReader(new InputStreamReader(myURL.openStream()));
			
            
			while ((inputLine = dis.readLine()) != null)
			{
//				System.out.println(inputLine);
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
		
                
		String result=lineresult.replaceAll("\\<.*?>","");
                System.out.println("Latest Version:"+result);
                data=result;
                checkalert();
			
		}
	
	}

//****************************Workspace*************************************

//                                 StringBuffer mybuff=new StringBuffer(inputLine);
//                                 StringTokenizer token=new StringTokenizer(inputLine,"Version:");
//                                 while(token.hasMoreTokens()) {
//                                    String key = token.nextToken(">");
//                                    String val = token.nextToken("<");
//                                    System.out.println(key + "\t" + val);
//                                       } 

	
	



