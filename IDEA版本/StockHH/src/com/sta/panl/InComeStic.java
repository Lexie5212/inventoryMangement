package com.sta.panl;

import java.awt.GridLayout;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

import com.sta.InPieChart;
import com.sta.inBarChart;
import com.sta.inBarChart2;
import com.sta.outBarChart;
import com.sta.outBarChart2;
import com.sta.outPieChart;

public class InComeStic extends JPanel{
	final int WIDTH=730;//���ö����ܵĿ��
	final int HEIGHT=50;//���ö����ܵĸ߶�
	
	
	
	public InComeStic(int x,int y,int width,int height) {
		//��һ�� w  h �Ǳ�ʾ����λ�� �ڶ�����ʾ //�������Ĵ�С
		this.setBounds(x, y, width, height-60);
		init();
	}
	

	
	void init() {
		
		this.setLayout(new GridLayout(2,2,10,10));
		this.add(new InPieChart().getChartPanel());
		this.add(new outPieChart().getChartPanel());
		 
		
	}
	public void rep() {
		this.removeAll();
		this.repaint();
	}
	public void rep1() {

		this.add(new InPieChart().getChartPanel());
		this.add(new outPieChart().getChartPanel());
		this.repaint();
	}




}
