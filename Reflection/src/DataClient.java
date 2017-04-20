import java.io.*;
import java.net.*;

class DataClient
{
    public static void main(String args[]) throws Exception
    {
        Socket soc=new Socket(InetAddress.getLocalHost(),5217);        
        BufferedReader in=new BufferedReader(
                new InputStreamReader(
                        soc.getInputStream()
                        )
                    );

        System.out.println( in.readLine());
    }    
}



// Date Server

