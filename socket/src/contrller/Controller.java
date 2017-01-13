package contrller;

import java.io.IOException;

import TcpProgram.TcpClient;
/*
 * 控制层
 */
public class Controller implements Runnable{
	
	private TcpClient client;
	public Controller(TcpClient client){
		this.client = client;
	}
	public TcpClient getClient(){
		return client;
	}
	
	//使用多线程开启连接
	@Override
	public void run() {
		client.setFlag(true);
		try {
			client.clientMethod();  //开启连接
		} catch (IOException e) {
			System.out.println("socket出现了异常");
		}  
	}
	
	//结束socket
	public void endConnection(){
		client.setFlag(false);
	}
	
	//测试
	public void test(){
		System.out.println("测试鼠标事件是否成功");
	}
}
