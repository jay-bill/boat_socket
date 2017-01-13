package TcpProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TcpThread implements Runnable{

	private Socket client=null;
	public Socket getClient() {
		return client;
	}
	public void setClient(Socket client) {
		this.client = client;
	}
	
	public TcpThread(Socket client){
		this.client=client;
	}
	@Override
	public void run() {
		try {
			//输入流获取发送来的数据
			BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
			String str=null;
			boolean flag=true;
			while(flag){
				if((str=reader.readLine())!=null){
					System.out.println("客户端："+str);
					//发送响应到客户端
					BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
					writer.write("您好，客户端");	
					flag=false;
				}				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
