package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class AllPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2035391864869887799L;
    private LeftPanel left;
    private RightPanel right;
    
	public LeftPanel getLeft() {
		return left;
	}

	public void setLeft(LeftPanel left) {
		this.left = left;
	}

	public RightPanel getRight() {
		return right;
	}

	public void setRight(RightPanel right) {
		this.right = right;
	}

	//���췽��
	public AllPanel(JPanel left,JPanel right){
		this.setLayout(new GridLayout(1,2));  //һ������
		this.add(left);//��һ�У������
		this.add(right);//�ڶ��У����ұ�
		this.left = (LeftPanel) left;
		this.right = (RightPanel) right;
	}
}
