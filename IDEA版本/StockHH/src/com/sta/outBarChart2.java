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

public class outBarChart2 {
	 ChartPanel frame1;
	public outBarChart2() {
		
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
        String SqlStr= "select * from outstock ORDER BY num desc LIMIT 0, 9";
        ResultSet rs = Tool.showData(SqlStr, null);
        try {
			while(rs.next()) {
				
				 int num = rs.getInt("num");
				 String sup=rs.getString("supname");
				 String sun=rs.getString("stockname");
			   	dataset.addValue(num, sup, sun+i);
				i++;
				
			
			
				
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
