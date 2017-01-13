package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import contrller.Controller;

public class RightPanel extends JPanel{

	private static final long serialVersionUID = -3308066640949407740L;
	//事件的属性
	private Controller controller;	
	private LoginFrame frame;
	
	Thread t1 = null;
	
	public LoginFrame getFrame() {
		return frame;
	}

	public void setFrame(LoginFrame frame) {
		this.frame = frame;
	}

	//按钮组件
	private JButton start;
	private JButton manual;
	private JButton auto;
	private JButton over;
	
	//构造方法
	public RightPanel(final Controller controller){
	   //依赖于控制器
	   this.controller = controller;
	  
	   this.setLayout(null);
	   //实例化按钮组件
	   start = new JButton("开启连接");
	   manual = new JButton("手动操作");
	   auto = new JButton("自动操作");
	   over = new JButton("结束");
	   
	   //添加到面板（窗格）中
	   add(start);
	   add(manual);
	   add(auto);
	   add(over);
	   
	   //对按钮组件进行定位
	   start.setBounds(160, 210, 120, 30);
	   manual.setBounds(120, 270, 100, 30);
	   auto.setBounds(220, 270, 100, 30);
	   over.setBounds(185, 330, 70, 30);
	   
	   //对按钮进行渲染
	   start.setBackground(Color.cyan);
	   start.setFont(new Font("微软雅黑",0,15));
	   manual.setBackground(Color.cyan);
	   manual.setFont(new Font("微软雅黑",0,15));
	   over.setBackground(Color.cyan);
	   over.setFont(new Font("微软雅黑",0,15));
	   
	   //监听"开始"鼠标事件
	   start.addMouseListener(new MouseListener(){

	    //鼠标单击
		@Override
		public void mouseClicked(MouseEvent e) {
			//调用控制器的“开启连接”，开启新线程
			t1 = new Thread(controller);
			t1.start();
			//按钮设置为不可用，直到按下“结束”才能重新使用
			start.setEnabled(false);
			frame.requestFocus();
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
		   
	   });
	   
	   //监听“结束”鼠标按键
	   over.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			controller.endConnection(); //结束
			//“开始连接”按钮可用
			start.setEnabled(true);
			frame.requestFocus();
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
		   
	   });
	}
}
