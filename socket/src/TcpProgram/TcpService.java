package TcpProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//Tcp服务端
public class TcpService implements Runnable{

	private Socket client=null;
    public TcpService(Socket client){
    	this.client=client;
    }
	public static void main(String[] args) throws IOException {
		//创建ServerSocket对象，指定端口号
		ServerSocket service=new ServerSocket(8888);
		//等待
		boolean flag=true;
		while(flag){
			//接收客户端的消息
			try{
				Socket client=service.accept(); //等待
				TcpService tcp=new TcpService(client);
				System.out.println("与客户端连接成功");
				new Thread(tcp).start();//开启线程
			}catch(IOException e){
				System.out.println("未与客户端成功连接");
				flag=false;
			}
		}
	}

	@Override
	public void run() {
		try {
			//输入流获取发送来的数据
			BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
			//发送响应到客户端
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			boolean flag=true;
			while(flag){
				String message=reader.readLine();
				String res="您好，客户端";
				writer.write(res+":"+message);	
				writer.newLine();
				writer.flush();
			}
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
