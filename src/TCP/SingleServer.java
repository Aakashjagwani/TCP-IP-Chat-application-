package TCP;
import java.io.*;
import java.net.*;
class SingleServer implements Runnable
{
	static ServerSocket ss;
	public void run()
	{
		String name = Thread.currentThread().getName();

		while(true)
		{
			try{
				System.out.println("Client "+name+" ready to accept…");
				Socket s = ss.accept();
				System.out.println("Client "+name+" accepted the connection");
				BufferedReader readKb = new BufferedReader(new InputStreamReader(System.in));
				PrintStream writeC = new PrintStream(s.getOutputStream(), true);
				BufferedReader readC = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String msgFromC, msgToC;
				while(true)
				{
					if((msgFromC = readC.readLine()) != null)
						System.out.print("\nClient "+name+" : "+msgFromC+"\n\nYou : ");
					msgToC = readKb.readLine();
					writeC.println(msgToC);
					writeC.flush();
				}
			}
			catch(Exception e)	{ }
		}
	}

	public static void main(String[] args)
	{
	try {
		SingleServer ms = new SingleServer();
		ss = new ServerSocket(156);

		Thread t1 = new Thread(ms, "One");
		Thread t2 = new Thread(ms, "Two");
		t1.start();
		t2.start();
		}
	catch(Exception e) { }
	}
	}
