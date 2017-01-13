package TcpProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//Tcp�����
public class TcpService implements Runnable{

	private Socket client=null;
    public TcpService(Socket client){
    	this.client=client;
    }
	public static void main(String[] args) throws IOException {
		//����ServerSocket����ָ���˿ں�
		ServerSocket service=new ServerSocket(8888);
		//�ȴ�
		boolean flag=true;
		while(flag){
			//���տͻ��˵���Ϣ
			try{
				Socket client=service.accept(); //�ȴ�
				TcpService tcp=new TcpService(client);
				System.out.println("��ͻ������ӳɹ�");
				new Thread(tcp).start();//�����߳�
			}catch(IOException e){
				System.out.println("δ��ͻ��˳ɹ�����");
				flag=false;
			}
		}
	}

	@Override
	public void run() {
		try {
			//��������ȡ������������
			BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
			//������Ӧ���ͻ���
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			boolean flag=true;
			while(flag){
				String message=reader.readLine();
				String res="���ã��ͻ���";
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
