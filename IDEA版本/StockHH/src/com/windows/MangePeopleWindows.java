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
import com.manage.panl.InStockPan;
import com.manage.panl.OutStockPan;
import com.manage.panl.ShowInOutStock;
import com.manage.panl.SupplierPan;
import com.sta.panl.InComeStic;
import com.sta.panl.InOutPnal;
import com.sta.panl.inBarPanl;
import com.sta.panl.outBarPanl;
import com.tool.Tool;

public class MangePeopleWindows {

	String buton[] ={"    ��Ʒ���    ","    ��Ʒ����    ","  ��ӹ�Ӧ��  ","    ��ѯ��¼    ","��������ͳ��","��������ͳ��","ӯ������ͳ��","������������"};//�ǰ�ť������
	String butonName[] ={"stockIn","stockOut","supplier","showdata","stiffdata","inoutdata","income","inoutstock"};//�������ֲ�ͬ��ť
	
	final int WIDTH=900;//���ö����ܵĿ��
	final int HEIGHT=600;//���ö����ܵĸ߶�
	public JFrame jframe=new JFrame();
	public static  InOutPnal inout;
	public MangePeopleWindows() {
		

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
		JMenuItem item1_1 = new JMenuItem("���Ա���˺�",new  ImageIcon("src/img/item1.png"));
		JMenuItem item1_2 = new JMenuItem("ɾ��Ա���˺�",new  ImageIcon("src/img/item2.png"));
		JMenuItem item1_3 = new JMenuItem("������Ϣ����",new  ImageIcon("src/img/item3.png"));
		menu.add(item1_1);
		menu.add(item1_2);
		menu.add(item1_3);
		
		
		JMenuItem item2_1 = new JMenuItem("����Ա���˺���Ϣ");
		//menu1.add(item2_1);
	
		 
		 
		
		
		menubar.add(menu);//���˵��ŵ�  �˵���
	//	menubar.add(menu1);
		jframe.setJMenuBar(menubar);
	
		
		
		JMenu menu2 = new JMenu("ϵͳ");
		JMenuItem item2_2 = new JMenuItem("ע��",new  ImageIcon("src/img/it1.png"));
		JMenuItem item2_3 = new JMenuItem("�˳�",new  ImageIcon("src/img/it2.png"));
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
				AddStaffAccout a=new AddStaffAccout();
			}
			
		});
		//���ɾ��Ա���˺�
		item1_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DellStaffWindows a=new DellStaffWindows();
				
				
			}
			
		});
		//������ĸ�����Ϣ
		//���ɾ��Ա���˺�
		item1_3.addActionListener(new ActionListener() {

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
		//�����Ӫ�̴���
		SupplierPan suppan=new SupplierPan(0, 0, 665+50, HEIGHT-10);
		jpanel2.add(suppan, (Integer) (JLayeredPane.PALETTE_LAYER));
		//��ѯ��¼
		//�����Ӫ�̴���
		ShowInOutStock showdata=new ShowInOutStock(0, 0, 665+50, HEIGHT-10);
		jpanel2.add(showdata, (Integer) (JLayeredPane.PALETTE_LAYER));
		

		//ͳ�����ݵ�����
		inBarPanl inbar=new inBarPanl(0, 0, 665+50, HEIGHT-10);
		jpanel2.add(inbar, (Integer) (JLayeredPane.PALETTE_LAYER));
		//ͳ�Ƴ��� 
		outBarPanl outbar=new outBarPanl(0, 0, 665+50, HEIGHT-10);
		jpanel2.add(outbar, (Integer) (JLayeredPane.PALETTE_LAYER));
		
		//����ͳ��
		InComeStic income=new InComeStic(0, 0, 665+50, HEIGHT-10);
		jpanel2.add(income, (Integer) (JLayeredPane.PALETTE_LAYER));
		
		//����ͳ��ͼ
		inout=new InOutPnal(0, 0, 665+50, HEIGHT-10);
		jpanel2.add(inout.JP(), (Integer) (JLayeredPane.PALETTE_LAYER));
		
		
		
		
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
			if(i==2) {
				bu=new JButton(buton[i],new  ImageIcon("src/img/Bu3.png"));
				jpanel1.add(bu);
				bu.setName(butonName[i]);
			}
			if(i==3) {
				bu=new JButton(buton[i],new  ImageIcon("src/img/Bu4.png"));
				jpanel1.add(bu);
				bu.setName(butonName[i]);
			}
			if(i==4) {
				bu=new JButton(buton[i],new  ImageIcon("src/img/Bu5.png"));
				jpanel1.add(bu);
				bu.setName(butonName[i]);
			}
			if(i==5) {
				bu=new JButton(buton[i],new  ImageIcon("src/img/Bu6.png"));
				jpanel1.add(bu);
				bu.setName(butonName[i]);
			}
			if(i==6) {
				bu=new JButton(buton[i],new  ImageIcon("src/img/Bu7.png"));
				jpanel1.add(bu);
				bu.setName(butonName[i]);
			}
			if(i==7) {
				bu=new JButton(buton[i],new  ImageIcon("src/img/Bu8.png"));
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
					
					if(jbl.getName().equals(butonName[2])) {
						//����Ʒ����Ǹ������ƶ���������
						jpanel2.moveToFront(suppan);
						
						SupManDao.readSup(suppan.cmb1);
						
						
					}
					if(jbl.getName().equals(butonName[3])) {
						//����Ʒ����Ǹ������ƶ���������
						jpanel2.moveToFront(showdata);
						
						
						
						
					}
					if(jbl.getName().equals(butonName[4])) {
						//����Ʒ����Ǹ������ƶ���������
						jpanel2.moveToFront(inbar);
						//�ƶ����Ϸ����� ���ǰ����ݳ�ʼ��һ��
					
						inbar.rep();//�Ƴ�
						inbar.rep1();//�����
						SwingUtilities.updateComponentTreeUI(inbar);//��ӻ�ɾ�������,���´���

						
						//
						
					}
					if(jbl.getName().equals(butonName[5])) {
						//����Ʒ����Ǹ������ƶ���������
						jpanel2.moveToFront(outbar);
						//�ƶ����Ϸ����� ���ǰ����ݳ�ʼ��һ��
					
						outbar.rep();//�Ƴ�
						outbar.rep1();//�����
						SwingUtilities.updateComponentTreeUI(outbar);//��ӻ�ɾ�������,���´���

						
						//outbar
						
					}
					if(jbl.getName().equals(butonName[6])) {
						//����Ʒ����Ǹ������ƶ���������
						jpanel2.moveToFront(income);
						//�ƶ����Ϸ����� ���ǰ����ݳ�ʼ��һ��
					
						income.rep();//�Ƴ�
						income.rep1();//�����
						SwingUtilities.updateComponentTreeUI(income);//��ӻ�ɾ�������,���´���

						
						//outbar
						
					}
					
					if(jbl.getName().equals(butonName[7])) {
						//����Ʒ����Ǹ������ƶ���������
						jpanel2.moveToFront(inout.JP());
						//�ƶ����Ϸ����� ���ǰ����ݳ�ʼ��һ��
					
					
						SwingUtilities.updateComponentTreeUI(inout.JP());//��ӻ�ɾ�������,���´���
						SupManDao.readSup(InOutPnal.cmbSupName);
						
						//outbar
						
					}
					
					
				}
				
			});
			
			
			
		}
		
		
		
		

		
		
		
		
		
	}


	
	
}
