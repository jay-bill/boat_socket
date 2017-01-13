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
 * Tcp�ͻ���
 */
public class TcpClient {
	
	//�������Ұ�����ֵ
	private static int up = KeyEvent.VK_UP;
	private static int down = KeyEvent.VK_DOWN;
	private static int left = KeyEvent.VK_LEFT;
	private static int right = KeyEvent.VK_RIGHT;
	
	private Socket client = null;
	private BufferedWriter writer = null;
	private BufferedReader reader = null;
	private BufferedReader input = null;	
	//������ֵ
	private volatile int key = 0;
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	//�ж�whileѭ���Ƿ��ս�
	private volatile boolean flag=true;
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	//���� ����
	public void clientMethod() throws IOException {
		//��һ�����ͻ����뱾���˿�8888��������
		client=new Socket("192.168.2.233",1234);
		//�ڶ�������ȡsocket������������ڽ����ݷ����������
		writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		//����������ȡSocket�������������ڽ�������
		reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
		//���Ĳ��������������ʱ��
		client.setSoTimeout(50000);
		while(flag){
			System.out.println("��������,key="+key);
			//������¡��������ҡ����Ļ�
			if(key==up){
				send("1"); //����
			}else if(key==down){
				send("2"); //����
			}else if(key==left){
				send("3"); //����
			}else if(key==right){
				send("4"); //����
			}
			try {
				Thread.sleep(5);  //��ͣ0.5s
			} catch (InterruptedException e) {
				System.out.println("�߳�˯��ʱ�ڳ����쳣����");
			}
		}
		send("0");  //����Ͽ��󣬷���0
		System.out.println("�������ӵ��˽���������������");
		if(client!=null){			
			client.close();//��󣬹ر�socket����֮��ص���Ҳ��֮�ر�
		}
	}
	
	//��������������ݣ�����ȡ��Ӧ����
	private void send(String data) throws IOException{
		//�����˷�������
		writer.write(data);
		writer.newLine();
		writer.flush();
		System.out.println(key);
		key = 0; //������Ϊ0
		
//		�ȴ���������Ӧ
//		String str=reader.readLine();
//		System.out.println("����ˣ�"+str);
	}
}