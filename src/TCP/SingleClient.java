package TCP;
import java.io.*;
import java.net.*;

class SingleClient
{
	public static void main(String[] args)
	{
		try {
			@SuppressWarnings("resource")
			Socket s = new Socket("localhost", 156);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintStream writeS = new PrintStream(s.getOutputStream(), true);
			BufferedReader readS = new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println("You may begin chatting :\n");
			String msgFromSer, msgToSer;
			while(true)
			{
				msgToSer = br.readLine();
				writeS.println(msgToSer);
				writeS.flush();
				if((msgFromSer = readS.readLine()) != null)
					System.out.print("\nServer : "+msgFromSer+"\n\nYou : ");
			}
		}catch(Exception e) {}
	}
	}