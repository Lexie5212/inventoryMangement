package com.windows;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.tool.Tool;

public class ChangOwnMeg {
	final int WIDTH=200;//���ö����ܵĿ��
	final int HEIGHT=222;//���ö����ܵĸ߶�
	JFrame jframe=new JFrame();
	public JTextField JT1;
	public JTextField JT2;
	public JTextField JT3;
	public ChangOwnMeg() {
		

		init();
		jframe.setVisible(true); //���õ�ǰ�����Ƿ����ʾ 
		jframe.setResizable(false);//���ڵĴ�С���ɱ�
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����Ĭ�Ϲرշ�ʽ
		jframe.validate();//�������Ч
		jframe.setIconImage(new ImageIcon("src/img/icons8-warehouse-100.png").getImage());
	}
	
	//��ʼ��
	void init() {
		
		Tool.setWindowPosCenter(WIDTH, HEIGHT, jframe);//�ô��ھ�����ʾ��
		jframe.setTitle("���ĸ�����Ϣ");
		
		//һ����ǩ  һ���ı���  һ��  ��ť    ����������
		jframe.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));//����Ϊ�����
		
		//3����ǩ
		//3���ı���
		//2����ť
		
		JLabel JL1=new JLabel("����");
		jframe.add(JL1);
		JT1=new JTextField(12);
		jframe.add(JT1);
		
		JLabel JL2=new JLabel("��ַ");
		jframe.add(JL2);
		JT2=new JTextField(12);
		jframe.add(JT2);
		
		
		
		
		JLabel JL3=new JLabel("����");
		jframe.add(JL3);
		JT3=new JTextField(12);
		jframe.add(JT3);
		
		JButton JB=new JButton("����");
		JButton JB1=new JButton("����");
		jframe.add(JB1);
		jframe.add(JB);
		
		//���ù���
		JB1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JT1.setText("");
				JT2.setText("");
				JT3.setText("");
				
			}
			
			
		});
		
		
		//���ĵĹ���
		JB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String  data[]=new String [4];
				 data[0]=JT1.getText();
				 data[1]=JT2.getText();
				 data[2]=JT3.getText();
				 data[3]=Login.jtextfield.getText();
				

				 
				 
				 String sqlStr="update users set sname=?,saddress=?,semail=? where account=?";
				
				 if(data[2].equals("")) {
					 JOptionPane.showMessageDialog(null, "���䲻��Ϊ��", "��¼��Ϣ",JOptionPane.WARNING_MESSAGE);
					 
				 }else {
					 int a=Tool.changeData(sqlStr, data);
						if(a==0) {
							JOptionPane.showMessageDialog(null, "���������˺�", "��¼��Ϣ",JOptionPane.WARNING_MESSAGE);
						}
						if(a==1) {
							JOptionPane.showMessageDialog(null, "���ĳɹ�", "��¼��Ϣ",JOptionPane.WARNING_MESSAGE);
						}
						if(a==-1) {
							JOptionPane.showMessageDialog(null, "ϵͳ����", "��¼��Ϣ",JOptionPane.WARNING_MESSAGE);
						}
					 
					 
					 
					 
					 
				 }
		
				
			}
			
			
		});
		
		
		
		
		
		
	}
}
