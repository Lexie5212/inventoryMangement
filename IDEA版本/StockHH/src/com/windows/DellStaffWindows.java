package com.windows;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.tool.Tool;

public class DellStaffWindows {
	
	
	Object columns[] ={"Ա������","Ȩ��","Ա������","Ա��סַ","Ա������"};//������Ϣ
	JTable tableL=null;//���
	JScrollPane jscrollpane;//������
	public static DefaultTableModel  model;//������Ŀ���Ȩ
	
	final int WIDTH=500;//���ö����ܵĿ��
	final int HEIGHT=400;//���ö����ܵĸ߶�
	JFrame jframe=new JFrame();
	
	public DellStaffWindows() {
		

		init();
		jframe.setVisible(true); //���õ�ǰ�����Ƿ����ʾ 
		jframe.setResizable(false);//���ڵĴ�С���ɱ�
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����Ĭ�Ϲرշ�ʽ
		jframe.validate();//�������Ч
		jframe.setIconImage(new ImageIcon("src/img/icons8-warehouse-100.png").getImage());
	}
	
	void init() {
		
		
		Tool.setWindowPosCenter(WIDTH, HEIGHT, jframe);//�ô��ھ�����ʾ��
		jframe.setTitle("ɾ��Ա���˺�");
		
		//һ����ǩ  һ���ı���  һ��  ��ť    ����������
		jframe.setLayout(new FlowLayout(FlowLayout.LEFT));//����Ϊ�����
		
		JLabel JL1=new JLabel("Ա������");
		jframe.add(JL1);
		JTextField JT1=new JTextField(12);
		jframe.add(JT1);
		
		JButton JB1=new JButton("ɾ��Ա���˺�");
		jframe.add(JB1);
		JButton JB2=new JButton("��ѯԱ���˺�");
		jframe.add(JB2);
		table();
		jframe.add(jscrollpane);
		
		JB1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//���ı�������ݴ������
				String sqlStr="delete from users where account=?";
				
				String  data[]=new String [1];
				data[0]=JT1.getText();
				int a=Tool.dellData(sqlStr, data);
				if(a==0) {
					JOptionPane.showMessageDialog(null, "�����˺��Ƿ����", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}
				if(a==-1) {
					JOptionPane.showMessageDialog(null, "�����˺���������", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}
				if(a>=1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		JB2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sqlStr="select account,if(pow=1,'��ͨ�û�','����Ա'),sname,saddress,semail from users";
				
				
				ResultSet rs = Tool.showData(sqlStr, null);
				 Tool.addDataTable(rs, model, 5);
				
				
				
			}
		
		});
		
		
		
	}
	void table() {
		
		tableL=getTable();//��ʼ�����
		jscrollpane=new JScrollPane(tableL);//���һ���������
		tableL.setPreferredSize(new Dimension(WIDTH-30,10000));//��������ô�С
		jscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//�����������ʾ�ڴ�����
		//jscrollpane.setBounds(0, 170, WIDTH-30, 360);
		jscrollpane.setPreferredSize(new Dimension(WIDTH-30,320));//��������ô�С
		
	}
	
	JTable getTable() {
		//������Ϊ���򴴽����
		if(tableL==null) {
			tableL=new JTable();//���� 
			model=new DefaultTableModel() {
				//���һЩ�Ա��Ŀ��� ���ñ�� ���ɶ�  ���ɱ༭
				public boolean isCellEditable(int row, int column)
				{
				return false;
				}
				
			};
			
		
		model.setColumnIdentifiers(columns);
		tableL.setModel(model);//����Ϊ����ģʽ
		
		tableL.getTableHeader().setReorderingAllowed(false);//�ñ�񲻿��϶�
		tableL.getTableHeader().setResizingAllowed(false);//�ñ�񲻿��϶�
			
		//�п� ������  �����ñ�񲻿ɱ༭
			
			
		}
		
		
		
		return tableL;
	}
}
