package View;

import Select.AllStateSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProTestPage extends JFrame implements ActionListener {

	JPanel northPane;
	JLabel northlb1;
	JButton logout;

	JPanel leftMenuPane;
	String [] menuTitle = {"교수testPage", "강의정보관리","교수정보관리","학생정보관리"};
	Font font;



	public ProTestPage() {
		
		init();
		setSize(1024,768);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}
	
	public void init() {
		setNorthPane(); //nothpanel ����
		setLeftMenu(); //�޴���

	}

	public void setNorthPane() {		

		northPane = new JPanel(new BorderLayout());	
		northPane.setBackground(new Color(33, 140, 116));
		
		northlb1 = new JLabel("ID:"+AllStateSession.login_id+"이름:"+AllStateSession.login_name); //������ ����
		northlb1.setHorizontalAlignment(JLabel.CENTER);

		northlb1.setOpaque(true);
		northlb1.setBackground(new Color(33, 140, 116)); 
		northlb1.setForeground(Color.white);
		northlb1.setPreferredSize(new Dimension(900, 0));

		logout = new JButton("LogOut");
		
		
		northPane.add(BorderLayout.WEST,northlb1); //������ ����� ���� �����ִ� JLabel �߰�
		northPane.add(BorderLayout.EAST,logout); // �α׾ƿ���ư
		northPane.setPreferredSize(new Dimension(0, 35)); //����������


		add(BorderLayout.NORTH,northPane);
		logout.addActionListener(this);


	}
	
	public void setLeftMenu() {
		leftMenuPane = new JPanel(new GridLayout(8,0));
		leftMenuPane.setPreferredSize(new Dimension(160, 0));//�޴����г� ������,��ġ
		leftMenuPane.setBackground(new Color(213, 213, 213));
		font = new Font("����", Font.BOLD, 20);

		for(int i=0; i<menuTitle.length; i++) {
			JButton jbt= new JButton(menuTitle[i]);
			jbt.setFont(font);	
			jbt.setBackground(new Color(213, 213, 213));
			leftMenuPane.add(jbt);
		}
		add(BorderLayout.WEST,leftMenuPane);
	}
	@Override
	public void actionPerformed(ActionEvent e) {////---추가한거
		Object event =e.getSource();

		if(event==logout)
		{
			AllStateSession.login_id=null;
			AllStateSession.login_state=0;
			setVisible(false);
			new MainIndex();
		}
		System.out.println(AllStateSession.login_id);
		System.out.println(AllStateSession.login_state);
	}//---추가한거
	public static void main(String[] args) {
		System.out.println("asdasd");
		new ProTestPage();
	}


}
