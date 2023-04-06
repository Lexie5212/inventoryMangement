package com.tool;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import com.until.DBUtil;

public class Tool {

	static Connection con=DBUtil.conn;
	//���ô��ھ���
	public static void setWindowPosCenter(int WIDTH,int HEIGHT,JFrame jframe) {
		
		Toolkit kit =Toolkit.getDefaultToolkit();//��ȡ�����С	//���ô���λ��
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;//��ȡ��Ļ�߶ȺͿ��
		int x=(width-WIDTH)/2;
		int y=(height-HEIGHT)/2;
		jframe.setBounds(x, y, WIDTH, HEIGHT);
		
	}
	//��ӱ���ģ�黯����
	public static  int addDataTable(ResultSet rs ,DefaultTableModel  model,int index) {
		
		int count=0;
		model.setNumRows(0);
		
		String  data[]=new String [index];
		try {
			while(rs.next()) {
				count++;
				for(int i=0;i<data.length;i++) {
					data[i]=rs.getString(i+1);
					
				}
				model.addRow(data);
				
				
			}
			rs.close();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return count;
		}
		
		
		

		
	}
	
	
	
	
	
	
	//ɾ��ͨ�õķ���   ����һ��ɾ�����  ����洢����
	public static int dellData(String sqlStr,String data[]) {
PreparedStatement preSql;//Ԥ�����
		
		//int num1 = Integer.parseInt(num);//���ַ�ת��������

		
		int num=0;
		
		try {
		
			preSql=con.prepareStatement(sqlStr);
			for(int i=0;i<data.length;i++) {
				preSql.setString(i+1,data[i]);
			}
			
			num=preSql.executeUpdate();
			return num;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
			//-1����  0û�ҵ���������   >=1ɾ���ɹ�
				
			
		}
		
		
		
	}
	//��ѯͨ�÷���
	//ɾ��ͨ�õķ���   ����һ��ɾ�����  ����洢����
	public static ResultSet showData(String sqlStr,String data[]) {
			PreparedStatement preSql;//Ԥ�����
		
		//int num1 = Integer.parseInt(num);//���ַ�ת��������

		
		ResultSet rs=null;
		
		try {
		
			preSql=con.prepareStatement(sqlStr);
			if(data!=null) {
				for(int i=0;i<data.length;i++) {
					preSql.setString(i+1,data[i]);
				}
			}
			
			
			 rs = preSql.executeQuery();
			return rs;
			
		}catch(SQLException e) {
			
			return rs;
			//-1����  0û�ҵ���������   >=1ɾ���ɹ�
				
			
		}
		
		
		
	}
	//ͨ�ø��ĵĹ���
	public static int changeData(String sqlStr,String data[]) {
		PreparedStatement preSql;//Ԥ�����
				
				//int num1 = Integer.parseInt(num);//���ַ�ת��������

				
				int num=0;
				
				try {
				
					preSql=con.prepareStatement(sqlStr);
					for(int i=0;i<data.length;i++) {
						preSql.setString(i+1,data[i]);
					}
					
					num=preSql.executeUpdate();
					return num;
					
				}catch(SQLException e) {
					e.printStackTrace();
					return -1;
					//-1����  0û�ҵ���������   >=1ɾ���ɹ�
						
					
				}
				
				
				
			}
	
	
	
	
	
	
	
	
	
	
	
	
}
