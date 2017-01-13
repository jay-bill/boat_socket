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

	//构造方法
	public AllPanel(JPanel left,JPanel right){
		this.setLayout(new GridLayout(1,2));  //一行两列
		this.add(left);//第一列，即左边
		this.add(right);//第二列，即右边
		this.left = (LeftPanel) left;
		this.right = (RightPanel) right;
	}
}
