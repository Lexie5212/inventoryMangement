package com.until;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
public class DBUtil {
	
	public static Connection conn=null;
	
	public DBUtil(String account ,String password,String database){
		//���ݿ��˺ţ����ݿ����룬���ݿ�����
		
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���������ɹ�");
			
		}catch(Exception e) {
			System.out.println("��������ʧ��");
		}
		
		try {
			
			String url="jdbc:mysql://localhost:3306/"+database+"?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT&AllowPublicKeyRetrieval=True";
			conn=DriverManager.getConnection(url, account, password);
			System.out.println("�������ݿ�ɹ�");
			
		}catch(SQLException e1) {
			System.out.println("�������ݿ�ʧ��");
			String temp=e1.getMessage();
			System.out.println(temp);
			String[] arr1=temp.split(" ");
			if(arr1[0].equals("Unknown")) {
			System.out.println("�뽨������Ϊ��"+arr1[2]+"���ݿ�");
			}
			if(arr1[0].equals("Access")) {
			System.out.println("�������ݿ������Ƿ���ȷ�����ݿ��������");
			}
		}
	}
	//��������Ƿ�رյ���˼�Զ��ر� ��һ������ ��ȡ���ݿ�Ľӿ�
	//Ԥ���Ľӿ�
	public static void  CloseDB(ResultSet rs, PreparedStatement stm) {
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stm!=null)
		{
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
