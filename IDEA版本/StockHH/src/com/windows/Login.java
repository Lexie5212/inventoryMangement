package com.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import com.dao.LoginDao;
import com.dao.SupManDao;
import com.manage.panl.InStockPan;
import com.style.Style;
import com.tool.Tool;



public class Login {
	
	public static JTextField jtextfield;
	public static JPasswordField jtextfield1;

	final int WIDTH=500;//���ö����ܵĿ��
	final int HEIGHT=350;//���ö����ܵĸ߶�
	
	String title;
	JFrame jframe=new JFrame();
	

	FlowLayout flowlayout;
	
	
	
	Login(String title){
		this.title=title;
		init();
		jframe.setVisible(true); //���õ�ǰ�����Ƿ����ʾ 
		jframe.setResizable(false);//���ڵĴ�С���ɱ�
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����Ĭ�Ϲرշ�ʽ
		jframe.validate();//�������Ч
		jframe.setIconImage(new ImageIcon("src/img/icons8-warehouse-100.png").getImage());
	}

	void init() {

	//	jframe.setIconImage(new ImageIcon("src/img/icons8-warehouse-100.png").getImage());
		//���ñ���
		
		jframe.setTitle(title);
		//���ô��ڵ�λ��
		// ���õ�ǰ���ڵĴ�С
		Tool.setWindowPosCenter(WIDTH, HEIGHT, jframe);
	
		//��С��������ˡ�
		flowlayout=new FlowLayout(flowlayout.CENTER);//���ж���
		Style style=new Style();
		jframe.setLayout(null);
		
		//�Ȱ�ͼƬ�������
		ImageIcon img=new ImageIcon("src/img/Login.jpg");//��ͼƬ��ȡ�ŵ�img��������
		JLabel bgimg = new JLabel(img);
		bgimg.setBounds(0,0,500,350);//���ñ���ͼƬ ���ñ���λ��
		
		
		//����������� �ֱ�װ�˺ţ��������
		JPanel jpnel1=new JPanel();
		jpnel1.setLayout(flowlayout);
		jpnel1.setBounds(0, 0,500, 45);
		
		//��ӱ���
		JLabel jlabel1=new JLabel("�ֿ����ϵͳ��¼");
		jlabel1.setFont(style.title);
		jpnel1.add(jlabel1);
		jpnel1.setOpaque(false);
		//�������Ӷ�
		JPanel jpnel2=new JPanel();
		jpnel2.setLayout(flowlayout);
		jpnel2.setBounds(125, 45,210, 230);
		jpnel2.setOpaque(false);
		
		JLabel jlabel2=new JLabel("�˺�");
		jlabel2.setFont(style.account);
		jpnel2.add(jlabel2);
		//����˺ſ�
		jtextfield=new JTextField(10);
		jtextfield.setFont(style.accounttext);
		jpnel2.add(jtextfield);
		
		JLabel jlabel3=new JLabel("����");
		jlabel3.setFont(style.account);
		jpnel2.add(jlabel3);
		
		
		//����˺ſ�
		jtextfield1=new JPasswordField(10);
		jtextfield1.setFont(style.accounttext);
		jpnel2.add(jtextfield1);
		
		
		//JLabel AAA=new JLabel("            ");
		//jpnel2.add(AAA);
		//���������ѡ��
		//JCheckBox JC1 = new JCheckBox("��������");//
		//JC1.setOpaque(false);
		//jpnel2.add(JC1);
		//JCheckBox JC2 = new JCheckBox("�Զ���¼");//
		//jpnel2.add(JC2);
		//JC2.setOpaque(false);
		
		
		
		
		// ��¼��ť
		JButton jbutton=new JButton("��ȫ��¼");
		jbutton.setFont(style.ok);
		jbutton.setPreferredSize(new Dimension(195,35) );
		jbutton.setBackground(Color.gray);
		jbutton.setForeground(new Color(	255,215,0));
		
		
		jpnel2.add(jbutton);


		jframe.add(jpnel2);
		jframe.add(jpnel1);
		JLabel jl=new JLabel("��������");
		jframe.add(jl);
		jl.setBounds(430, 160, 300, 40);
		//register.setFont(fronts.register);
		jl.setForeground(Color.DARK_GRAY);
		
		jframe.add(bgimg);
		
		
		//��ǩֻ���������ͷ
		jl.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				ForGetPasssWord c=new ForGetPasssWord();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
	
		
		
		//�����Ǽ����¼�
		
		jbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//���˺�  �������ȡ�� ������Ӧ����ʾ 
				//���˺ź����룬�����ݿ����ƥ�ԣ�ͬʱ��ƥ��Ȩ�ޣ�ʵ����ת��ͬ�Ľ���
				
				String account=jtextfield.getText();//��ȡ�˺�
				
				char []str=jtextfield1.getPassword();
				String password=new String(str);
				
				
				boolean star = LoginDao.loginStar(account, password);
				if(star==true) {
					System.out.println("��¼�ɹ�");
					//֮�󣬻���Ҫ�ж� Ȩ�� ���Ǹ��ȼ� ���ݵȼ�������ת��ͬ�Ľ���
					int pow=LoginDao.loginPow(account, password);
					if(pow==2) {
						//���ǹ���Ա
						jframe.dispose();
						MangePeopleWindows a=new MangePeopleWindows();
						SupManDao.readSup(InStockPan.cmbSupName);
						
					}else if(pow==1) {
						//������ͨ�û�
						jframe.dispose();
						StaiffWindows a=new StaiffWindows();
					}else {
						//����
						JOptionPane.showMessageDialog(null, "ϵͳ����", "��¼��Ϣ",JOptionPane.WARNING_MESSAGE);
					}
					
					
				}else {
					
					JOptionPane.showMessageDialog(null, "�˺Ż����������", "��¼��Ϣ",JOptionPane.WARNING_MESSAGE);
				}
				
		
			
				
				
			}
			
		});
		


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
	
		
		
		
		
		
		
		
		
	}
	
	
	
	

	
	///
	//
	//
}
