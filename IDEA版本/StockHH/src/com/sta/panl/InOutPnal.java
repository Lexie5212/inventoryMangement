package com.sta.panl;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import com.sta.InOutTimeSeriesChart;
import com.sta.InOutTimeSeriesChart2;

public class InOutPnal {

	final int WIDTH=730;//���ö����ܵĿ��
	final int HEIGHT=50;//���ö����ܵĸ߶�
	JPanel  JPM=new JPanel();
	public static JComboBox cmbSupName;//����һ��������
	public  InOutPnal(int x,int y,int width,int height) {
		
		JPM.setBounds(x, y, width, height-60);
		init();
	}
	
	
	void init() {
		
		JPanel JP1=new JPanel();
		JP1.setLayout(new FlowLayout(FlowLayout.CENTER,20,100));//����
		JLabel JL1=new JLabel("��Ӧ��");
		JP1.add(JL1);
		cmbSupName = new JComboBox();    //����JComboBox
		cmbSupName.addItem("--��ѡ��Ӧ��--");
		JP1.add(cmbSupName);
		
		JLabel JL2=new JLabel("�ֿ�״̬");
		JP1.add(JL2);
		

		
		JRadioButton jrb1=new JRadioButton("���");//����������ѡ��ť
		JRadioButton jrb2=new JRadioButton("����");
		jrb1.setSelected(true);//����Ĭ��ѡ�����
		ButtonGroup bg=new ButtonGroup();
		bg.add(jrb1);			//����Ҫ�ѵ�ѡ����밴ť���������в���ʵ�ֵ�ѡ��������
		bg.add(jrb2);//�ѵ�ѡ��ť�ŵ�һ������
		JP1.add(jrb1);
		JP1.add(jrb2);
		
		

		//����������ť
		JButton JB1=new JButton("�鿴���������");
		JP1.add(JB1);
		
		JButton JB2=new JButton("�鿴��������");
		JP1.add(JB2);
		
		JPM.setLayout(new GridLayout(2,2,10,10));//������������ó� ������񲼾�
		
		//JP1.setBorder(BorderFactory.createTitledBorder("�鿴ͳ��ͼ"));
		JPM.add(JP1);
		JPM.add(new InOutTimeSeriesChart("","instock").getChartPanel());//��һ�������ǲ�ѯ�Ǹ���Ӧ�̣��ڶ������� �����
		//this.add(new outBarChart2().getChartPanel());
		JPM.setBorder(BorderFactory.createTitledBorder(""));
		JP1.setBorder(BorderFactory.createTitledBorder("ͳ������"));
		
		
		JB2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//��ȡ�������� һ����Ӫ�̵����е�  ����  ����˵������Ӫ
				
				if(cmbSupName.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "��ѡ����Ӫ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else {
					
					String sup=(String) cmbSupName.getSelectedItem();//��ȡѡ��ı���  ��ȡ���ĸ���Ӫ��
					String sqlstr;//������־����⻹�ǳ���
					if(jrb1.isSelected()) {//jb1����ⵥѡ��ť
						sqlstr="instock";//���ݿ������ �������ݿ�����
					}else {
						sqlstr="outstock";//��������ݿ�����
						
					}
					
					JPM.remove(1);
					SwingUtilities.updateComponentTreeUI(JPM);//��ӻ�ɾ�������,���´���
					JPM.add(new InOutTimeSeriesChart(sup, sqlstr).getChartPanel());
					
	
				}
			}
			
		});
		
		
		JB1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//��ȡ�������� һ����Ӫ�̵����е�  ����  ����˵������Ӫ
				
				if(cmbSupName.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "��ѡ����Ӫ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else {
					
					String sup=(String) cmbSupName.getSelectedItem();//��ȡѡ��ı���  ��ȡ���ĸ���Ӫ��
					String sqlstr;//������־����⻹�ǳ���
					if(jrb1.isSelected()) {//jb1����ⵥѡ��ť
						sqlstr="instock";//���ݿ������ �������ݿ�����
					}else {
						sqlstr="outstock";//��������ݿ�����
						
					}
					
					JPM.remove(1);
					SwingUtilities.updateComponentTreeUI(JPM);//��ӻ�ɾ�������,���´���
					JPM.add(new InOutTimeSeriesChart2(sup, sqlstr).getChartPanel());
					

				}
			}
			
		});
		
		

		
	}

public JPanel  JP() {
	return JPM;
}
}
