package contrller;

import java.io.IOException;

import TcpProgram.TcpClient;
/*
 * ���Ʋ�
 */
public class Controller implements Runnable{
	
	private TcpClient client;
	public Controller(TcpClient client){
		this.client = client;
	}
	public TcpClient getClient(){
		return client;
	}
	
	//ʹ�ö��߳̿�������
	@Override
	public void run() {
		client.setFlag(true);
		try {
			client.clientMethod();  //��������
		} catch (IOException e) {
			System.out.println("socket�������쳣");
		}  
	}
	
	//����socket
	public void endConnection(){
		client.setFlag(false);
	}
	
	//����
	public void test(){
		System.out.println("��������¼��Ƿ�ɹ�");
	}
}
