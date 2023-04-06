package com.sta;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.tool.Tool;

public class InPieChart {
	ChartPanel frame1;
	
	public  InPieChart() {
		
		 DefaultPieDataset data = getDataSet();
		  JFreeChart chart = ChartFactory.createPieChart3D("����ͳ������",data,true,false,false);
		    //���ðٷֱ�
		  PiePlot pieplot = (PiePlot) chart.getPlot();
		  DecimalFormat df = new DecimalFormat("0.00%");//���һ��DecimalFormat������Ҫ������С������
		  NumberFormat nf = NumberFormat.getNumberInstance();//���һ��NumberFormat����
		  StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//���StandardPieSectionLabelGenerator����
		  pieplot.setLabelGenerator(sp1);//���ñ�ͼ��ʾ�ٷֱ�
		  
		  
		   pieplot.setNoDataMessage("��������ʾ");
		   pieplot.setCircular(false);
		  pieplot.setLabelGap(0.02D);
		  
		  
		  pieplot.setIgnoreNullValues(true);//���ò���ʾ��ֵ
	      pieplot.setIgnoreZeroValues(true);//���ò���ʾ��ֵ
	      frame1=new ChartPanel (chart,true);
	      chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
	      PiePlot piePlot= (PiePlot) chart.getPlot();//��ȡͼ���������
	      piePlot.setLabelFont(new Font("����",Font.BOLD,10));//�������
	      chart.getLegend().setItemFont(new Font("����",Font.BOLD,10));
		
	}

	private DefaultPieDataset getDataSet() {
		// TODO Auto-generated method stub
		//���Զ�����һ�����������������д
		
		 DefaultPieDataset dataset =new   DefaultPieDataset();
		 ResultSet rs = Tool.showData("select DISTINCT supname from instock", null);//�鿴
		 
		 try {
			 
			 while(rs.next()) {
				 String supname=rs.getString("supname");//��ȡ����Ӧ�̵�����
				 String sqlstr="select ifnull(supname,?) ,ifnull(sum(num*pric),0)-(select sum(num*pric)from instock where supname=?) from outstock where supname=?";
				 String data[]=new String[3];
				data[0]=supname;
				data[1]=supname;
				data[2]=supname;
				ResultSet rs1 = Tool.showData(sqlstr, data);
				while(rs1.next()) {
					String supname1=rs1.getString(1);
					Float sumpric=rs1.getFloat(2);
					dataset.setValue(supname1,sumpric);
				}
				rs1.close();
				 
			 }
			 
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return dataset;
	}
	
	public ChartPanel getChartPanel(){
	    	return frame1;
	    	
	    }
	
	
	
	

}
