package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LeftPanel extends JPanel{

	private static final long serialVersionUID = -3308066640949407740L;
	//四个按钮组件，上下左右
	private JButton top;
	private JButton down;
	private JButton left;
	private JButton right;
	public JButton getTop() {
		return top;
	}

	public void setTop(JButton top) {
		this.top = top;
	}

	public JButton getDown() {
		return down;
	}

	public void setDown(JButton down) {
		this.down = down;
	}

	public JButton getLeft() {
		return left;
	}

	public void setLeft(JButton left) {
		this.left = left;
	}

	public JButton getRight() {
		return right;
	}

	public void setRight(JButton right) {
		this.right = right;
	}
	
	//构造方法
	public LeftPanel(){
	   this.setBackground(Color.blue);
	   this.setLayout(null);
	   //实例化按钮组件
	   top = new JButton("上");
	   down = new JButton("下");
	   left = new JButton("左");
	   right = new JButton("右");
	   
	   //添加到面板（窗格）中
	   add(top);
	   add(down);
	   add(left);
	   add(right);
	   
	   //定位
	   top.setBounds(140, 200, 140, 60);
	   down.setBounds(140, 320, 140, 60);
	   left.setBounds(0, 260, 140, 60);
	   right.setBounds(280, 260, 140, 60);
	   
	   //设置为不可用
	   top.setEnabled(false);
	   down.setEnabled(false);
	   left.setEnabled(false);
	   right.setEnabled(false);
	}
}
