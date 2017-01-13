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
	//�¼�������
	private Controller controller;	
	private LoginFrame frame;
	
	Thread t1 = null;
	
	public LoginFrame getFrame() {
		return frame;
	}

	public void setFrame(LoginFrame frame) {
		this.frame = frame;
	}

	//��ť���
	private JButton start;
	private JButton manual;
	private JButton auto;
	private JButton over;
	
	//���췽��
	public RightPanel(final Controller controller){
	   //�����ڿ�����
	   this.controller = controller;
	  
	   this.setLayout(null);
	   //ʵ������ť���
	   start = new JButton("��������");
	   manual = new JButton("�ֶ�����");
	   auto = new JButton("�Զ�����");
	   over = new JButton("����");
	   
	   //��ӵ���壨������
	   add(start);
	   add(manual);
	   add(auto);
	   add(over);
	   
	   //�԰�ť������ж�λ
	   start.setBounds(160, 210, 120, 30);
	   manual.setBounds(120, 270, 100, 30);
	   auto.setBounds(220, 270, 100, 30);
	   over.setBounds(185, 330, 70, 30);
	   
	   //�԰�ť������Ⱦ
	   start.setBackground(Color.cyan);
	   start.setFont(new Font("΢���ź�",0,15));
	   manual.setBackground(Color.cyan);
	   manual.setFont(new Font("΢���ź�",0,15));
	   over.setBackground(Color.cyan);
	   over.setFont(new Font("΢���ź�",0,15));
	   
	   //����"��ʼ"����¼�
	   start.addMouseListener(new MouseListener(){

	    //��굥��
		@Override
		public void mouseClicked(MouseEvent e) {
			//���ÿ������ġ��������ӡ����������߳�
			t1 = new Thread(controller);
			t1.start();
			//��ť����Ϊ�����ã�ֱ�����¡���������������ʹ��
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
	   
	   //��������������갴��
	   over.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			controller.endConnection(); //����
			//����ʼ���ӡ���ť����
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
