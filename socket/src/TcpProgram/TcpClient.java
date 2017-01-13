package TcpProgram;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

/*
 * Tcp客户端
 */
public class TcpClient {
	
	//上下左右按键键值
	private static int up = KeyEvent.VK_UP;
	private static int down = KeyEvent.VK_DOWN;
	private static int left = KeyEvent.VK_LEFT;
	private static int right = KeyEvent.VK_RIGHT;
	
	private Socket client = null;
	private BufferedWriter writer = null;
	private BufferedReader reader = null;
	private BufferedReader input = null;	
	//按键键值
	private volatile int key = 0;
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	//判断while循环是否终结
	private volatile boolean flag=true;
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	//建立 连接
	public void clientMethod() throws IOException {
		//第一步：客户端与本机端口8888建立连接
		client=new Socket("192.168.2.233",1234);
		//第二步：获取socket的输出流，用于将数据发送至服务端
		writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		//第三步：获取Socket的输入流，用于接收数据
		reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
		//第四步：设置最大阻塞时间
		client.setSoTimeout(50000);
		while(flag){
			System.out.println("还在运行,key="+key);
			//如果按下“上下左右”键的话
			if(key==up){
				send("1"); //发送
			}else if(key==down){
				send("2"); //发送
			}else if(key==left){
				send("3"); //发送
			}else if(key==right){
				send("4"); //发送
			}
			try {
				Thread.sleep(5);  //暂停0.5s
			} catch (InterruptedException e) {
				System.out.println("线程睡眠时期出现异常！！");
			}
		}
		send("0");  //点击断开后，发送0
		System.out.println("本次连接到此结束！！！！！！");
		if(client!=null){			
			client.close();//最后，关闭socket，与之相关的流也随之关闭
		}
	}
	
	//向服务器发送数据，并读取响应内容
	private void send(String data) throws IOException{
		//向服务端发送数据
		writer.write(data);
		writer.newLine();
		writer.flush();
		System.out.println(key);
		key = 0; //重新置为0
		
//		等待服务器响应
//		String str=reader.readLine();
//		System.out.println("服务端："+str);
	}
}