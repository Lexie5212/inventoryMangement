package com.windows;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.dao.SupManDao;
import com.manage.item.AddStaffAccout;

import com.staff.panl.*;
import com.tool.Tool;

public class StaiffWindows {

	String buton[] ={"    ��Ʒ���    ","    ��Ʒ����    "};//�ǰ�ť������
	String butonName[] ={"stockIn","stockOut"};//�������ֲ�ͬ��ť
	
	final int WIDTH=900;//���ö����ܵĿ��
	final int HEIGHT=600;//���ö����ܵĸ߶�
	public JFrame jframe=new JFrame();
	
	public StaiffWindows() {
		

		init();
		jframe.setVisible(true); //���õ�ǰ�����Ƿ����ʾ 
		jframe.setResizable(false);//���ڵĴ�С���ɱ�
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����Ĭ�Ϲرշ�ʽ
		jframe.validate();//�������Ч
		jframe.setIconImage(new ImageIcon("src/img/icons8-warehouse-100.png").getImage());
	}
	
	void init() {
		
		
		jframe.setLayout(null);//���ÿղ���
		jframe.setTitle("�ֿ����ϵͳ");
		//���ھ���
		Tool.setWindowPosCenter(WIDTH, HEIGHT, jframe);
		
		JPanel jpanel1=new JPanel();
		JLayeredPane jpanel2 = new JLayeredPane();
		//��ʱû�������ʲô�����ݲ�����
		
		//���õ�һ�����ӵ�λ���Լ���С
		jpanel1.setBounds(5, 5, 150, HEIGHT-10);

		jpanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		

		//����һ���˵���  ���˺Ź���   �����ӹ�Ӧ��
		JMenuBar menubar = new JMenuBar();//����һ���˵���
		JMenu menu = new JMenu("�˺Ź���");
		//JMenu menu1 = new JMenu("�ֿ����");
		JMenuItem item1_1 = new JMenuItem("������Ϣ����",new  ImageIcon("src/img/item3.png"));
		menu.add(item1_1);
		menubar.add(menu);//���˵��ŵ�  �˵���
		jframe.setJMenuBar(menubar);
	
		
		JMenu menu2 = new JMenu("ϵͳ");
		JMenuItem item2_2 = new JMenuItem("ע��", new ImageIcon("src/img/it1.png"));
		JMenuItem item2_3 = new JMenuItem("�˳�", new ImageIcon("src/img/it2.png"));
		 menu2.add(item2_2);
		 menu2.add(item2_3);
		 menubar.add(menu2);
		 //ע��
		 item2_2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//�رյ�ǰ���� �򿪵�¼����
					jframe.dispose();
					Login login=new Login("�ֿ����ϵͳ");
					
				}
				
			});
		 //�˳�
		 item2_3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					jframe.dispose();
				}
				
			});
		
		
		//���˺����Ա���˺����
		
		item1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangOwnMeg chan=new ChangOwnMeg();
				String data[]=new String[1];
				data[0]=Login.jtextfield.getText();
				String sqlStr="select  sname,saddress,semail from users  where account=?";
				ResultSet rs = Tool.showData(sqlStr,data );
				try {
					rs.next();
					chan.JT1.setText(rs.getString("sname"));
					chan.JT2.setText(rs.getString("saddress"));
					chan.JT3.setText(rs.getString("semail"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
			
		});
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		//��ⴰ��
		InStockPan inpan=new InStockPan(0, 0, 665+50, HEIGHT-10);
		jpanel2.add(inpan, (Integer) (JLayeredPane.PALETTE_LAYER));
		
		//���ⴰ�� 
		OutStockPan outpan=new OutStockPan(0, 0, 665+50, HEIGHT-10);
		jpanel2.add(outpan, (Integer) (JLayeredPane.PALETTE_LAYER));

		
		

		jpanel2.setBounds(215-50, 5, 680+50, HEIGHT-10);//�������Ӷ���С
		
		
		jframe.add(jpanel2);
		jframe.add(jpanel1);
		jpanel1.setBackground(new Color(135,206,235));
		
		
		
		for(int i=0;i<buton.length;i++) {
			
			JButton bu=null;

			if(i==0) {
				bu=new JButton(buton[i],new  ImageIcon("src/img/Bu1.png"));
				jpanel1.add(bu);
				bu.setName(butonName[i]);
			}
			if(i==1) {
				bu=new JButton(buton[i],new  ImageIcon("src/img/Bu2.png"));
				jpanel1.add(bu);
				bu.setName(butonName[i]);
			}

			bu.addActionListener(new ActionListener() {
		
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					JButton jbl=(JButton)e.getSource();
					if(jbl.getName().equals(butonName[0])) {
						//����Ʒ����Ǹ������ƶ���������
						jpanel2.moveToFront(inpan);
						SupManDao.readSup(InStockPan.cmbSupName);
						
					
						
					}
					
					if(jbl.getName().equals(butonName[1])) {
						//����Ʒ����Ǹ������ƶ���������
						jpanel2.moveToFront(outpan);
						SupManDao.readSup(OutStockPan.cmbSupName);
						
					}
			
					
					
					
					
				}
				
			});
			
			
			
		}
		
		
		
		

		
		
		
		
		
	}


	
	
}
