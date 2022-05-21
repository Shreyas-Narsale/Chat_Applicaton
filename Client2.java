package ChatApp;
import java.lang.*;
import java.net.*;
import java.io.*;

final class Client
{

	private String s1, s2;
	private Socket s=null;
	private BufferedReader brk=null;
	private BufferedReader br=null;;
	private PrintStream ps=null;;

	public Client()
	{
		try
		{
			System.out.println("Client Application is running");
			this.s=new Socket("localhost",1100);
			this.brk=new BufferedReader(new InputStreamReader(System.in));
			this.br=new BufferedReader(new InputStreamReader(this.s.getInputStream()));
			this.ps=new PrintStream(this.s.getOutputStream());
		}
		catch(Exception obj)
		{}
	}
	public void Communicatate()
	{
		try
		{
			System.out.println("Enter message for server:");
			while((!(this.s1=this.brk.readLine()).equals("gn")))
			{
				this.ps.println(this.s1);
				this.s2=this.br.readLine();
				System.out.println("Server says:"+this.s2);
				System.out.println("Enter message for server:");
			}
		}
		catch (Exception obj)
		{}
	}
		
	protected void finalize()throws Exception  
	{
		this.s.close();
		this.br.close();
		this.brk.close();
		this.ps.close();
	}
	
}

