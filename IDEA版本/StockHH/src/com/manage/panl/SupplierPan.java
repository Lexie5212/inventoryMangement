package com.manage.panl;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.dao.SupManDao;

public class SupplierPan  extends JPanel{
	
	static int num=1;//��ӵĴ���
	final int WIDTH=730;//���ö����ܵĿ��
	final int HEIGHT=50;//���ö����ܵĸ߶�
	public JComboBox cmb1;
	public static  JTextField  jt1;
	
	public SupplierPan(int x,int y,int width,int height) {
		this.setBounds(x, y, width, height);
		init();
	}
	
	void init() {
	
		this.setLayout(null);
		JPanel jpan1=new JPanel();//����һ������1
		jpan1.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));//���ж���
		jpan1.setBounds(0, 0, WIDTH-20, 100);

		this.add(jpan1);
		
		JLabel jl1=new JLabel("��Ӧ��");
		jt1=new JTextField(15);
		JButton jb1=new JButton("��ӹ�Ӧ��");
		JButton jb5=new JButton("ɾ����Ӧ��");
		
	
		
		
		
		jpan1.add(jl1);
		jpan1.add(jt1);
		jpan1.add(jb1);
		jpan1.add(jb5);
		
		
		//һ����ǩ
		JLabel JL1=new JLabel("��Ӧ��");
		jpan1.add(JL1);

		
	
		
		
		JComboBox cmbSupName = new JComboBox();    //����JComboBox
		cmbSupName.addItem("--��ѡ��Ӧ��--");
		jpan1.add(cmbSupName);
		
		
		JLabel JL2=new JLabel("��Ʒ����");
		jpan1.add(JL2);
		
		
		JComboBox cmbStockName = new JComboBox();    //����JComboBox
		cmbStockName.addItem("--��ѡ����Ʒ--");
		jpan1.add(cmbStockName);
		
		JButton jb=new JButton("ɾ�������Ӳ�Ʒ");
		jpan1.add(jb);
		
		
		
		//_____________________________________________
	


		
		
		
		
		
		
		
		//������ļ���
		cmbSupName.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				SupManDao.readSun(cmbStockName, (String )cmbSupName.getSelectedItem());
			
				
			}
			
		});
		
		SupManDao.readSup(cmbSupName);
		
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//��������ɾ��
				
				if(cmbSupName.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "��ѡ��Ӧ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if (cmbStockName.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "��ѡ���Ӳ�Ʒ", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else {
					
					String sup=(String )cmbSupName.getSelectedItem();
					String sun=(String )cmbStockName.getSelectedItem();
					
					int a=SupManDao.delSunStock(sup, sun);
					if(a==1) {
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "��Ϣ",JOptionPane.WARNING_MESSAGE);
						SupManDao.readSun(cmbStockName, (String )cmbSupName.getSelectedItem());
					}
					if(a==0) {
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					}
					if(a==3) {
						JOptionPane.showMessageDialog(null, "ɾ������", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					}
					
					
				}
				
				
				
				
			}
			
		});
		
		
		
		
		
		
		
		
		
		//����һ�����Ӷ��� ����Ŀ����һ����
		JPanel jpan2=new JPanel();
		jpan2.setLayout(new FlowLayout(FlowLayout.LEFT,40,10));
	
		jpan2.setBounds(0, 110, WIDTH-20,410);
		this.add(jpan2);
		
		JLabel jl2=new JLabel("��Ӧ��");
		cmb1=new JComboBox();
		cmb1.addItem("--��ѡ��Ӧ��--");
		JButton jb2 =new JButton("��������Ӳ�Ʒ");
	
		JButton jb3 =new JButton("��������");
		JButton jb4=new JButton("����");
		

		
		jpan2.add(jl2);
		jpan2.add( cmb1);
		jpan2.add(jb2);
		jpan2.add( jb3);
		
		jpan2.add( jb4);
		
	
		
		
	
		
		
		//�ٶ���һ������ �ŵ����ӵ���
		JPanel jp3=new JPanel();
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER));
	
		jp3.setPreferredSize(new Dimension(200, 350));//��������������ʹ��
		JTextField A=new JTextField(12);
		JLabel B=new JLabel("��Ʒ����");
		A.setName("sun");
		jp3.add(B);
		jp3.add(A);
		jpan2.add(jp3);
		
		
		jpan2.setBorder(BorderFactory.createTitledBorder(""));
		jpan1.setBorder(BorderFactory.createTitledBorder(""));
		jp3.setBorder(BorderFactory.createTitledBorder("��Ӳ�Ʒ"));
		
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				if(num<5) {
					JTextField A=new JTextField(12);
					JLabel B=new JLabel("��Ʒ����");
					A.setName("sun");
					
					jp3.add(B);
					jp3.add(A);
					myUpdateUI();
					num++;
				}else {
					JOptionPane.showMessageDialog(null, "���ֻ�����5��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		
		
		
	//��� ��Ӧ��
		
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//������д�뵽�������ݿ�
				
				if(jt1.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "��Ӧ�̲���Ϊ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else {
					int star=SupManDao.wiretSup(jt1.getText());
					if(star==0) {
						JOptionPane.showMessageDialog(null, "��Ӧ�����ʧ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					}
					if(star==1) {
						JOptionPane.showMessageDialog(null, "��Ӧ����ӳɹ�", "��Ϣ",JOptionPane.WARNING_MESSAGE);
						SupManDao.readSup(cmb1);
						//ˢ��������
						SupManDao.readSup(cmbSupName);
						
					}
					if(star==3) {
						JOptionPane.showMessageDialog(null, "��Ӧ�������ظ�������д����", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					}
				}
				
				
				
				
			}
			
		});	
		//���ɾ����ť�ļ���dellSup
		jb5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//������д�뵽�������ݿ�
				
				if(jt1.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "��Ӧ�̲���Ϊ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else {
					int star=SupManDao.dellSup(jt1.getText());
					if(star==0) {
						JOptionPane.showMessageDialog(null, "ɾ����Ӧ�����ʧ����������", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					}
					if(star==1) {
						JOptionPane.showMessageDialog(null, "��Ӧ��ɾ���ɹ�", "��Ϣ",JOptionPane.WARNING_MESSAGE);
						SupManDao.readSup(cmb1);
						SupManDao.readSup(cmbSupName);
						//ˢ��������
						
					}
					if(star==3) {
						JOptionPane.showMessageDialog(null, "����������������", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					}
				}
				
				
				
				
			}
			
		});	
		
		
		//��������������ж�����ȡһ��  
		//��������ѡ������ݸ��� ���������ı�����������ݻ�ȡ��д�����ݿ�
		
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int a=0;
				Component[] tem = jp3.getComponents();
				for(int i=0;i<tem.length;i++) {
					
					

					if(tem[i].getName()!=null&&tem[i].getName().equals("sun")) {
						//��֤�����������ı���
						JTextField TEMP1 = (JTextField)tem[i];
						String text=TEMP1.getText();//���ı�������ݴ����
			
						if(cmb1.getSelectedIndex()==0) {
							JOptionPane.showMessageDialog(null, "��ѡ��Ӧ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
						}else {
							//��ȡ��Ŀ����
							String sup=(String) cmb1.getSelectedItem();
							//text ������Ӳ�Ʒ sup ����Ӫ��
						a=SupManDao. wiretSupSun(sup, text);
						
						}
						
						
					}
				}
				//����߼���ʱ�������Զ��������������� 
				if(a==3) {
					JOptionPane.showMessageDialog(null, "�����Ӳ�Ʒ�����Ƿ��ظ�", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}
				else if(a==0) {
					JOptionPane.showMessageDialog(null, "���ʧ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "��Ӳ�Ʒ�ɹ�", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					SupManDao.readSun(cmbStockName, (String )cmbSupName.getSelectedItem());
				}
			}
			
		});
		
		//���ð�ť    �����Ӳ˵���ղ� ��һ��
		jb4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jp3.removeAll();
				JTextField A=new JTextField(12);
				JLabel B=new JLabel("��Ʒ����");
				A.setName("sun");
				jp3.add(B);
				jp3.add(A);
				num=1;
				
				
				
				
				myUpdateUI();
				
				
			}
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	


	//���½���
	private void myUpdateUI() {
	SwingUtilities.updateComponentTreeUI(this);//��ӻ�ɾ�������,���´���


	}
	
	
	
	
	
}

	
