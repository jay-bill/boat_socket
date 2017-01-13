package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LeftPanel extends JPanel{

	private static final long serialVersionUID = -3308066640949407740L;
	//�ĸ���ť�������������
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
	
	//���췽��
	public LeftPanel(){
	   this.setBackground(Color.blue);
	   this.setLayout(null);
	   //ʵ������ť���
	   top = new JButton("��");
	   down = new JButton("��");
	   left = new JButton("��");
	   right = new JButton("��");
	   
	   //��ӵ���壨������
	   add(top);
	   add(down);
	   add(left);
	   add(right);
	   
	   //��λ
	   top.setBounds(140, 200, 140, 60);
	   down.setBounds(140, 320, 140, 60);
	   left.setBounds(0, 260, 140, 60);
	   right.setBounds(280, 260, 140, 60);
	   
	   //����Ϊ������
	   top.setEnabled(false);
	   down.setEnabled(false);
	   left.setEnabled(false);
	   right.setEnabled(false);
	}
}
