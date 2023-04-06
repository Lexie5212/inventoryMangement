package com.sta;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.tool.Tool;

public class inBarChart {
	 ChartPanel frame1;
	public inBarChart() {
		
		CategoryDataset dataset = getDataSet();
		 JFreeChart chart = ChartFactory.createBarChart3D(
	            "�����Ʒ����", // ͼ�����
                "��Ʒ����", // �ļ��������ʾ��ǩ
                "����", // ��ֵ�����ʾ��ǩ
                dataset, // ���ݼ�
                PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
                false,          // �Ƿ����ɹ���
                false           // �Ƿ�����URL����
                );
		  CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������
	      CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�
	      
	      domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����
	      domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����
	      ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״
	      
	      rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));
	      chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
	      chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
	      
	      frame1=new ChartPanel(chart,true);  
	      
	}
	

	private  CategoryDataset getDataSet() {
		// TODO Auto-generated method stub
		
		//���ڶ�ȡ���ݿ� 
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
       int i=0;
        String SqlStr= "SELECT supname, sum(num) FROM instock GROUP BY supname order by sum(num) desc LIMIT 0, 3";
        ResultSet rs = Tool.showData(SqlStr, null);
        try {
			while(rs.next()) {
				String supname=rs.getString("supname");
				String data[]=new String[1];
				data[0]=supname;
				String sql="select * from instock  where  supname=? order by num desc LIMIT 0, 3";
				ResultSet rs1 = Tool.showData(sql,data);
				 
				 while(rs1.next()) {
					 int num = rs1.getInt("num");
					 String sup=rs1.getString("supname");
					 String sun=rs1.getString("stockname");
					dataset.addValue(num, sup, sun+i);
					i++;
					
				 }
				rs1.close();
				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
     
       

        return dataset;
	}
	public ChartPanel getChartPanel(){
		return frame1;
		
	}
}
