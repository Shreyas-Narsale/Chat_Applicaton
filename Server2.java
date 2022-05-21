package ChatApp;
import java.lang.*;
import java.net.*;
import java.io.*;

final class Server
{

	private String s1, s2;
	private ServerSocket ss=null;
	private Socket s=null;
	private BufferedReader brk=null;
	private BufferedReader br=null;
	private PrintStream ps=null;

	public Server()
	{
		try
		{
			System.out.println("Server Application is running");
			this.ss=new ServerSocket(1100);
			this.s=this.ss.accept();
			System.out.println("Connection Successfully");
			this.brk=new BufferedReader(new InputStreamReader(System.in));
			this.br=new BufferedReader(new InputStreamReader(this.s.getInputStream()));
			this.ps=new PrintStream(this.s.getOutputStream());
		}
		catch(Exception obj){}
	}
	public void Communicatate()
	{
		try
		{
			while((this.s1=this.br.readLine())!=null)
			{
				System.out.println("Client says:"+this.s1);
				System.out.println("Enter message for Client");
				this.s2=this.brk.readLine();
				this.ps.println(this.s2);
			}
		}
		catch (Exception obj)
		{}
	}
		
	protected void finalize()throws Exception  
	{
		this.s.close();
		this.ss.close();
		this.br.close();
		this.brk.close();
		this.ps.close();
	}
	
}
