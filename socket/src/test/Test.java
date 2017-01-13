package test;

import javax.swing.JPanel;

import contrller.Controller;
import TcpProgram.TcpClient;
import view.AllPanel;
import view.LeftPanel;
import view.LoginFrame;
import view.RightPanel;

public class Test {

	public static void main(String[] args) {
		TcpClient client = new TcpClient();  //实例化TcpClient类
		Controller controller = new Controller(client);  //把client对象传递给控制器
		
		/*
		 * 界面的装配
		 */
		JPanel left = new LeftPanel();  
		RightPanel right = new RightPanel(controller);
		JPanel allpanel = new AllPanel(left,right);
		LoginFrame l = new LoginFrame(allpanel,client); 
		right.setFrame(l); 
	}

}
