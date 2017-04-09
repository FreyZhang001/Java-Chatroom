import java.io.*;
import java.net.*;

public class Server1 extends Thread {//�̳�Thread��
	private Socket client;
	
	public Server1(Socket c){//���ʼ�������ܲ���Ϊ�ͻ��˵�����
		this.client = c;
	}
	
	public void run(){//��дrun����
		try{
			BufferedReader in=
				new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out=new PrintWriter(client.getOutputStream());
			while(true){
				String str=in.readLine();
				System.out.println(str);
				out.println("has receive....");
				out.flush();
				if(str.equals("end"))
					break;   
			}   
			client.close();
		}catch(IOException ex){
		}finally{
		}
	}
	
	public static void main(String[] args) throws IOException{
		ServerSocket server=new ServerSocket(5678);
		while(true){
			Server1 mu=new Server1(server.accept());//ÿ���пͻ���������½�һ��Server����֮ͨ��
			mu.start();
		}
	}   
}