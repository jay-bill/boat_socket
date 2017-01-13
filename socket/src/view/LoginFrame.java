package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import TcpProgram.TcpClient;

public class LoginFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int old_x=0;
    int old_y=0;
    private TcpClient client = null;
    private AllPanel allpanel = null;
    
	public LoginFrame(JPanel panel,final TcpClient client)
	{		
		this.setVisible(true);
		this.setTitle("�������˴�С�ֶ�");
		this.setResizable(false);
		this.setSize(880,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
		this.setContentPane(panel);
		this.allpanel = (AllPanel) panel;
		//ʹ�������
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width)/2-this.getWidth()/2;
		int y = (screen.height)/2-this.getHeight()/2;
		this.setLocation(x, y);
		//���ͼ��
//		Image image = new ImageIcon("Graphics/1.jpg").getImage();  //��ȡͼƬ
//		this.setIconImage(image);
		//ʵ������϶�����
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e)
			{
				old_x=e.getX();//��ȡ�϶����x����
				old_y=e.getY();//��ȡ�϶����y����
			}
			
		});
		this.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				int onscreen_x = e.getXOnScreen();
				int onscreen_y = e.getYOnScreen();
				int xx = onscreen_x - old_x;
				int yy = onscreen_y - old_y;
				LoginFrame.this.setLocation(xx, yy);
			}
		});
		
		//���������������¼�
		this.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {}
			//���̰��£�δ�ͷţ�
			@Override
			public void keyPressed(KeyEvent e) {
				//�����¡����ϡ�����
				if(e.getKeyCode() == KeyEvent.VK_KP_UP||e.getKeyCode() == KeyEvent.VK_UP){
					System.out.println("�������ˡ����ϡ�����");
					client.setKey(KeyEvent.VK_UP);
					//�ı䷽��ָʾ����ɫ
					allpanel.getLeft().getTop().setBackground(Color.red);
				}
				//�����¡����¡�����
				if(e.getKeyCode() == KeyEvent.VK_KP_DOWN||e.getKeyCode() == KeyEvent.VK_DOWN){
					System.out.println("�������ˡ����¡�����");
					client.setKey(KeyEvent.VK_DOWN);
					allpanel.getLeft().getDown().setBackground(Color.red);
				}
				//�����¡����󡱰���
				if(e.getKeyCode() == KeyEvent.VK_KP_LEFT||e.getKeyCode() == KeyEvent.VK_LEFT){
					System.out.println("�������ˡ����󡿰���");
					client.setKey(KeyEvent.VK_LEFT);
					allpanel.getLeft().getLeft().setBackground(Color.red);
				}
				//�����¡����ϡ�����
				if(e.getKeyCode() == KeyEvent.VK_KP_RIGHT||e.getKeyCode() == KeyEvent.VK_RIGHT){
					System.out.println("�������ˡ����ҡ�����");
					client.setKey(KeyEvent.VK_RIGHT);
					allpanel.getLeft().getRight().setBackground(Color.red);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_KP_UP||e.getKeyCode() == KeyEvent.VK_UP){
					//�ı䷽��ָʾ����ɫ
					allpanel.getLeft().getTop().setBackground(Color.LIGHT_GRAY);
				}
				//�����¡����¡�����
				if(e.getKeyCode() == KeyEvent.VK_KP_DOWN||e.getKeyCode() == KeyEvent.VK_DOWN){
					//�ı䷽��ָʾ����ɫ
					allpanel.getLeft().getDown().setBackground(Color.LIGHT_GRAY);
				}
				//�����¡����󡱰���
				if(e.getKeyCode() == KeyEvent.VK_KP_LEFT||e.getKeyCode() == KeyEvent.VK_LEFT){
					//�ı䷽��ָʾ����ɫ
					allpanel.getLeft().getLeft().setBackground(Color.LIGHT_GRAY);
				}
				//�����¡����ҡ�����
				if(e.getKeyCode() == KeyEvent.VK_KP_RIGHT||e.getKeyCode() == KeyEvent.VK_RIGHT){
					//�ı䷽��ָʾ����ɫ
					allpanel.getLeft().getRight().setBackground(Color.LIGHT_GRAY);
				}
			}
			
		});
	}
}
