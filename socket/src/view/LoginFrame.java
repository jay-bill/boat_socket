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
		this.setTitle("华工无人船小分队");
		this.setResizable(false);
		this.setSize(880,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
		this.setContentPane(panel);
		this.allpanel = (AllPanel) panel;
		//使界面居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width)/2-this.getWidth()/2;
		int y = (screen.height)/2-this.getHeight()/2;
		this.setLocation(x, y);
		//添加图标
//		Image image = new ImageIcon("Graphics/1.jpg").getImage();  //获取图片
//		this.setIconImage(image);
		//实现鼠标拖动功能
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e)
			{
				old_x=e.getX();//获取拖动后的x坐标
				old_y=e.getY();//获取拖动后的y坐标
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
		
		//整个面板监听键盘事件
		this.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {}
			//键盘按下（未释放）
			@Override
			public void keyPressed(KeyEvent e) {
				//当按下“向上”按键
				if(e.getKeyCode() == KeyEvent.VK_KP_UP||e.getKeyCode() == KeyEvent.VK_UP){
					System.out.println("您按下了【向上】按键");
					client.setKey(KeyEvent.VK_UP);
					//改变方向指示的颜色
					allpanel.getLeft().getTop().setBackground(Color.red);
				}
				//当按下“向下”按键
				if(e.getKeyCode() == KeyEvent.VK_KP_DOWN||e.getKeyCode() == KeyEvent.VK_DOWN){
					System.out.println("您按下了【向下】按键");
					client.setKey(KeyEvent.VK_DOWN);
					allpanel.getLeft().getDown().setBackground(Color.red);
				}
				//当按下“向左”按键
				if(e.getKeyCode() == KeyEvent.VK_KP_LEFT||e.getKeyCode() == KeyEvent.VK_LEFT){
					System.out.println("您按下了【向左】按键");
					client.setKey(KeyEvent.VK_LEFT);
					allpanel.getLeft().getLeft().setBackground(Color.red);
				}
				//当按下“向上”按键
				if(e.getKeyCode() == KeyEvent.VK_KP_RIGHT||e.getKeyCode() == KeyEvent.VK_RIGHT){
					System.out.println("您按下了【向右】按键");
					client.setKey(KeyEvent.VK_RIGHT);
					allpanel.getLeft().getRight().setBackground(Color.red);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_KP_UP||e.getKeyCode() == KeyEvent.VK_UP){
					//改变方向指示的颜色
					allpanel.getLeft().getTop().setBackground(Color.LIGHT_GRAY);
				}
				//当按下“向下”按键
				if(e.getKeyCode() == KeyEvent.VK_KP_DOWN||e.getKeyCode() == KeyEvent.VK_DOWN){
					//改变方向指示的颜色
					allpanel.getLeft().getDown().setBackground(Color.LIGHT_GRAY);
				}
				//当按下“向左”按键
				if(e.getKeyCode() == KeyEvent.VK_KP_LEFT||e.getKeyCode() == KeyEvent.VK_LEFT){
					//改变方向指示的颜色
					allpanel.getLeft().getLeft().setBackground(Color.LIGHT_GRAY);
				}
				//当按下“向右”按键
				if(e.getKeyCode() == KeyEvent.VK_KP_RIGHT||e.getKeyCode() == KeyEvent.VK_RIGHT){
					//改变方向指示的颜色
					allpanel.getLeft().getRight().setBackground(Color.LIGHT_GRAY);
				}
			}
			
		});
	}
}
