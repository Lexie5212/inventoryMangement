package com.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;







import com.style.Style;
import com.tool.Tool;

public class ForGetPasssWord {

	
	public static int code=-1;
	FlowLayout flowlayout;//����һ������
	final int WIDTH=410;//���ö����ܵĿ��
	final int HEIGHT=320;//���ö����ܵĸ߶�
	
	//��������
	javax.swing.JPanel jpanel_1;//��ͼƬ������������
	javax.swing.JPanel jpanel_2;//ֻ�Ƿű���
	javax.swing.JPanel jpanel_3;//ֻ�Ƿű���
	
	JFrame jframe=new JFrame();
	
	
	public ForGetPasssWord() {
		init();
		jframe.setVisible(true); //���õ�ǰ�����Ƿ����ʾ 
		jframe.setResizable(false);//���ڵĴ�С���ɱ�
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����Ĭ�Ϲرշ�ʽ
		jframe.validate();//�������Ч
		jframe.setIconImage(new ImageIcon("src/img/icons8-warehouse-100.png").getImage());
		
		
	}
	
	void init() {
		//���岼��
		flowlayout=new FlowLayout(FlowLayout.CENTER);//���ж���
		//�ô��ھ�����ʾ
		Tool.setWindowPosCenter(WIDTH, HEIGHT, jframe);
		jpanel_1=new javax.swing.JPanel();
		jpanel_1.setPreferredSize(new Dimension (WIDTH,HEIGHT));
		jpanel_1.setLayout(null);//���ò���
		jpanel_1.setOpaque(false);//����ǰ���������ó�͸��
		
		
		//�������Ӵ�С
		
		//���ñ���ͼƬ
		ImageIcon img=new ImageIcon("src/img/2.jpg");//��ͼƬ��ȡ�ŵ�img��������
		JLabel bgimg = new JLabel(img);
		bgimg.setBounds(0,0,410,400);//���ñ���ͼƬ ���ñ���λ��
		
		Style fronts=new Style();//���������Ըı���ʽ
		jframe.setTitle("�ֿ����ϵͳ�����һ�");
		
		JLabel title = new JLabel("�ִ�����ϵͳ�˺��һ�");
		title.setFont(fronts.title);
		title.setForeground(Color.gray);
		
	
		
		
		jpanel_2=new javax.swing.JPanel();
		jpanel_2.setBounds(0, 30, WIDTH-10, 70);
		jpanel_2.setOpaque(false);//����ǰ���������ó�͸��
		jpanel_2.setLayout(flowlayout);
		jpanel_2.add(title);
		//�����Ӷ������ݽ��г�ʼ��
		//��ʼ���������� 
		jpanel_3=new javax.swing.JPanel();
		jpanel_3.setBounds(25, 100,350,270);
		jpanel_3.setOpaque(false);//����ǰ���������ó�͸��
		jpanel_3.setLayout(flowlayout);//���ò���
		
		
		JLabel JL1=new JLabel("��        ��:");
		JL1.setFont(fronts.account);//����������ʽ
		JTextField JT1 = new JTextField(20);
		JL1.setForeground(new Color(102,102,102));
		JT1.setForeground(new Color(18,120,192));
		JT1.setPreferredSize(new Dimension(15,28));
		JT1.setFont(fronts.accounttext);
		
		//��һ�����ݽ��г�ʼ��

		jpanel_3.add(JL1);
		jpanel_3.add(JT1);
		
		
		
		JLabel JL2=new JLabel("��  ��  ��:");
		JL2.setFont(fronts.account);//����������ʽ
		JPasswordField JT2 = new JPasswordField(20);
		JL2.setForeground(new Color(102,102,102));
		JT2.setForeground(new Color(18,120,192));
		JT2.setPreferredSize(new Dimension(15,28));
		JT2.setFont(fronts.accounttext);
		
		//��һ�����ݽ��г�ʼ��

		jpanel_3.add(JL2);
		jpanel_3.add(JT2);
		
		
		JLabel JL3=new JLabel("��        ��:");
		JL3.setFont(fronts.account);//����������ʽ
		JTextField JT3 = new JTextField(20);
		JL3.setForeground(new Color(102,102,102));
		JT3.setForeground(new Color(18,120,192));
		JT3.setPreferredSize(new Dimension(15,28));
		JT3.setFont(fronts.accounttext);
		
		//��һ�����ݽ��г�ʼ��

		jpanel_3.add(JL3);
		jpanel_3.add(JT3);
		
		
		
		JLabel JL4=new JLabel("��  ֤  ��:");
		JL4.setFont(fronts.account);//����������ʽ
		JTextField JT4 = new JTextField(20);
		JL4.setForeground(new Color(102,102,102));
		JT4.setForeground(new Color(18,120,192));
		JT4.setPreferredSize(new Dimension(15,28));
		JT4.setFont(fronts.accounttext);
		
		//��һ�����ݽ��г�ʼ��

		jpanel_3.add(JL4);
		jpanel_3.add(JT4);
		
		
		JButton JB1 = new JButton("��   ��");
		JB1.setPreferredSize(new Dimension(150,30));//���ð�ť�Ĵ�С
		JB1.setFont(fronts.ok);
		JB1.setForeground(new Color(244,170,128));
		
		
		JButton JB2 = new JButton("��ȡ��֤��");
		JB2.setPreferredSize(new Dimension(150,30));//���ð�ť�Ĵ�С
		JB2.setFont(fronts.ok);
		JB2.setForeground(new Color(244,170,128));

		jpanel_3.add(JB1);
		jpanel_3.add(JB2);
		//���һ��
		
		JB2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// �ж��˺� �Ƿ� ��Ϊ��  �����Ƿ�Ϊ��  �����ʽ �Ƿ���ȷ
				String account=JT1.getText();//��ȡ�˺�
				char []str=JT2.getPassword();
				String password=new String(str);//��ȡ����
				//String 
				String email=JT3.getText();// ��ȡ����
				if(account.equals("")) {
					JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					
				}else if(password.equals("")) {
					JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(email.equals("")){
					JOptionPane.showMessageDialog(null, "���䲻��Ϊ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else {
					//�����䷢��Ϣ  �����ж�һ��  �����ַ�Ƿ���ȡ
					
					String mah = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";//�����������ʽ
					Pattern pattern = Pattern.compile(mah);
					Matcher matcher = pattern.matcher(email);
					boolean result = matcher.matches();
					if(result) {
						//�����䷢����ȷ����֤��  163  
						Random tool = new Random();//4455
					
			    		code = tool.nextInt(9000) + 1000;
			    		System.out.println("��֤��Ϊ��" + code);
						
			    		 String to = email;//��ȡ��ǰ���������
			    		 
			    		 String from = "buyiyangdelaomo@163.com";
					     String host = "smtp.163.com";  //163 �ʼ�������
						
					     // ��ȡϵͳ����
					      Properties properties = System.getProperties();

					        // �����ʼ�������
					       properties.setProperty("mail.smtp.host", host);

					       properties.put("mail.smtp.auth", "true");
					        // ��ȡĬ��session����
					       
					       
					       
					       
					       Session session = Session.getDefaultInstance(properties,new Authenticator(){
					            public PasswordAuthentication getPasswordAuthentication()
					            {
					                return new PasswordAuthentication("buyiyangdelaomo@163.com", "HJZUSSRJLSDFUOJH"); //�������ʼ��û���������
					            }
					        });
					       
					       //�����ݿ�����������ȡ����
					       String sqlStr="select * from users where account=?";//��ȡ����
					       String data[]=new String[1];
					       data[0]=account;
					       ResultSet rs = Tool.showData(sqlStr,  data);
					    
					       try {
					    	
							if(rs.next()) {
								String ema=rs.getString("semail");
								
								   //System.out.println(ema==email);
								if(ema.equals(email)) {
									 try{
								            // ����Ĭ�ϵ� MimeMessage ����
								            MimeMessage message = new MimeMessage(session);

								            // Set From: ͷ��ͷ�ֶ�
								            message.setFrom(new InternetAddress(from));

								            // Set To: ͷ��ͷ�ֶ�
								            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

								            // Set Subject: ͷ��ͷ�ֶ�
								            message.setSubject("�ִ�����ϵͳע����֤");//Email����

								            // ������Ϣ��
								            message.setText("���Ĵ˴���֤��Ϊ��" + code);//Email����

								            // ������Ϣ
								            Transport.send(message);
								            JOptionPane.showMessageDialog(null, "��֤�뷢�ͳɹ�,��ע�����", "��Ϣ",JOptionPane.WARNING_MESSAGE);
								        }catch (MessagingException mex) {
								            mex.printStackTrace();
								            JOptionPane.showMessageDialog(null, "����Ƿ���pop3���񣬷�ʧ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
								        }
								       	
									
									
								}else {
									
									JOptionPane.showMessageDialog(null, "�����ַ����", "��Ϣ",JOptionPane.WARNING_MESSAGE);
									
								}
								
								
								
								
								
							}else {
								
								JOptionPane.showMessageDialog(null, "��������ȷ���˺�", "��Ϣ",JOptionPane.WARNING_MESSAGE);
								
							}
					
							
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					       
					}else {
						JOptionPane.showMessageDialog(null, "�����ʽ����", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					}
					
					
					
					
					
					
				}
			}
			
		});
		
		JB1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// �ж��˺� �Ƿ� ��Ϊ��  �����Ƿ�Ϊ��  �����ʽ �Ƿ���ȷ
				String account=JT1.getText();//��ȡ�˺�
				char []str=JT2.getPassword();
				String password=new String(str);//��ȡ����
				//String 
				String email=JT3.getText();// ��ȡ����
				String code1=JT4.getText();
				if(account.equals("")) {
					JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					
				}else if(password.equals("")) {
					JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(email.equals("")){
					JOptionPane.showMessageDialog(null, "���䲻��Ϊ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else {
					//�����䷢��Ϣ  �����ж�һ��  �����ַ�Ƿ���ȡ
					
					String mah = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";//�����������ʽ
					Pattern pattern = Pattern.compile(mah);
					Matcher matcher = pattern.matcher(email);
					boolean result = matcher.matches();
					if(result) {
						
					       	
						String s = String.valueOf(code);
						if(s.equals(code1)) {
							//�����ݸ��µ����ݿ�
							String sql="update users set password=? where account=?";
							String data[]=new String [2];
							data[0]=password;
							data[1]=account;
							int num = Tool.dellData(sql, data);
							if(num==0) {
								JOptionPane.showMessageDialog(null, "��������ȷ�˺�", "��Ϣ",JOptionPane.WARNING_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "���ĳɹ�", "��Ϣ",JOptionPane.WARNING_MESSAGE);
							}
							
							
						}else {
							JOptionPane.showMessageDialog(null, "��֤�����", "��Ϣ",JOptionPane.WARNING_MESSAGE);
						}
				
						
						
					}else {
						JOptionPane.showMessageDialog(null, "�����ʽ����", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					}
					
					
					
					
					
					
				}
			}
			
		});
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		jpanel_1.add(jpanel_2);//���Ӷ�������
		jpanel_1.add(jpanel_3);
		jpanel_1.add(bgimg);
		jframe.add(jpanel_1);//����һ������
		
		

		
		
				
				
				
				
				
				
				
				
				
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
