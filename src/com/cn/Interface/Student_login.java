package com.cn.Interface;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.GroupLayout.Group;
import javax.swing.border.*;

import com.cn.bookManage.*;
import com.cn.tools.BDConnection;
import com.cn.tools.CircleButton;
import com.cn.user.Student;
/**
 * 学生登录界面
 * @author mac
 *
 */

public class Student_login extends MyFrame {
	private JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10,jb11,jb12,jb13,jb14;
	private JPanel panel,panel_1,panel_2,panel_3,panel_4,panel_5,panel_6;
	private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
	private JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8,jt9,jt10,jt11;
	private JRadioButton jr1,jr2;
	private CircleButton cb;
	private String stu_id,stu_name,stu_userName,stu_sex,stu_age,stu_major,book_id;
	
	private JTable jt;
	private JScrollPane jsp;
	private int counter,ci;
	private Object [][]rowData;
	private Object []columnNames;
	
	public Student_login() {
		setTitle(Student.getStuID()+"欢迎您");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		panel.setBounds(6, 6, 173, 416);
//		contentPane.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 161, 428);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(173, 0, 427, 428);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		
		panel_3 = new JPanel();
		panel_3.setBounds(173, 0, 427, 428);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setVisible(false);
		
		panel_4 = new JPanel();
		panel_4.setBounds(173, 0, 421, 272);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setVisible(false);
		
		panel_5 = new JPanel();
		panel_5.setBounds(173, 280, 421, 148);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setVisible(false);
		
		panel_6 = new JPanel();
		panel_6.setBounds(173, 280, 421, 148);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setVisible(false);
		
		jl1 = new JLabel("学号");
		jl1.setHorizontalAlignment(SwingConstants.RIGHT);
		jl1.setBounds(22, 33, 50, 30);
		
		
		jt1 = new JTextField();
		jt1.setEnabled(false);
		jt1.setBounds(91, 33, 153, 30);
		
		jl2 = new JLabel("姓名");
		jl2.setHorizontalAlignment(SwingConstants.RIGHT);
		jl2.setBounds(22, 96, 50, 30);
		
		jt2 = new JTextField();
		jt2.setEnabled(false);
		jt2.setBounds(91, 96, 100, 30);
		
		jl3 = new JLabel("用户名");
		jl3.setHorizontalAlignment(SwingConstants.RIGHT);
		jl3.setBounds(22, 159, 50, 30);
		
		jt3 = new JTextField();
		jt3.setEnabled(false);
		jt3.setBounds(91, 159, 145, 30);
		
		
		jl4 = new JLabel("性别");
		jl4.setHorizontalAlignment(SwingConstants.RIGHT);
		jl4.setBounds(22, 222, 50, 30);
		
		jt4 = new JTextField();
		jt4.setEnabled(false);
		jt4.setBounds(91, 222, 39, 30);
		
		ButtonGroup bg = new ButtonGroup();
		
		jr1 = new JRadioButton("男");
		jr1.setBounds(91, 222, 45, 30);
		bg.add(jr1);
		
		jr2= new JRadioButton("女");
		jr2.setBounds(130, 222, 45, 30);
		bg.add(jr2);
		
		jl5 = new JLabel("年龄");
		jl5.setHorizontalAlignment(SwingConstants.RIGHT);
		jl5.setBounds(22, 285, 50, 30);
		
		jt5 = new JTextField();
		jt5.setEnabled(false);
		jt5.setBounds(91, 285, 68, 30);
		
		jl6 = new JLabel("专业");
		jl6.setHorizontalAlignment(SwingConstants.RIGHT);
		jl6.setBounds(22, 348, 50, 30);
		
		jt6 = new JTextField();
		jt6.setEnabled(false);
		jt6.setBounds(91, 348, 68, 30);
		
		jt10 = new JTextField();
		jt10.setBounds(180, 6, 130, 30);
		jt10.setColumns(10);
		jt10.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
//				jt10.setText("请输入书籍编号");
//				jt10.setForeground(Color.GRAY);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				jt10.setText("请输入书籍编号");
				jt10.setForeground(Color.GRAY);
			}
		});
		
		
		jb10 = new JButton("搜索");
		jb10.setBounds(304, 6, 117, 29);
		jb10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				book_id = jt10.getText().trim();
				jsp.setVisible(false);

				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql="select * from Book_info where book_id = '"+book_id+"'";
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						counter++;
					}
					rs = stmt.executeQuery(sql);
					columnNames = new  Object[] {"编号","书名","作者","价格","出版社","类别","简介","是否借出"};
					rowData = new Object[counter][columnNames.length];
					counter = 0;
					while(rs.next()) {
						rowData[counter][0] = rs.getString("book_id");
						rowData[counter][1] = rs.getString("book_name");
						rowData[counter][2] = rs.getString("book_author");
						rowData[counter][3] = rs.getString("book_price");
						rowData[counter][4] = rs.getString("book_press");
						rowData[counter][5] = rs.getString("book_category");
						rowData[counter][6] = rs.getString("book_describe");
						rowData[counter][7] = rs.getString("book_Lend");
						counter++;
					}
					jt = new JTable(rowData, columnNames);
					jt.setEnabled(false);
					jsp = new JScrollPane(jt);
					jsp.setBounds(10,40,380,150);
					panel_4.add(jsp);
					jsp.setVisible(true);
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}finally {
					BDConnection.close();
				}
				
			}
		});
		
		jb1 = new JButton("查看个人资料");
		jb1.setBounds(16, 60, 122, 29);
		panel_1.add(jb1);
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				jt1.setEnabled(false);
				jt2.setEnabled(false);
				jt3.setEnabled(false);
				jt4.setEnabled(false);
				jt5.setEnabled(false);
				jt6.setEnabled(false);
				
				panel_2.add(jl1);
				panel_2.add(jt1);
				panel_2.add(jl2);
				panel_2.add(jt2);
				panel_2.add(jl3);
				panel_2.add(jt3);
				panel_2.add(jl4);
//				panel_2.add(jt4);
				panel_2.add(jl5);
				panel_2.add(jt5);
				panel_2.add(jl6);
				panel_2.add(jt6);
				
				panel_2.add(jr1);
				panel_2.add(jr2);
				
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql = "select * from stu_info where stu_id ='"+ Student.getStuID()+"'";
					rs = stmt.executeQuery(sql);
//					stu_sex = jr1.isSelected()?"男":"女";
					if(rs.next()){
						jt1.setText(rs.getString("stu_id"));
						jt2.setText(rs.getString("stu_name"));
						jt3.setText(rs.getString("stu_userName"));
						if(rs.getString("stu_sex").equals("男")) {
							jr1.setSelected(true);
						}else if(rs.getString("stu_sex").equals("女")) {
							jr2.setSelected(true);
						}
						jt5.setText(rs.getString("stu_age"));
						jt6.setText(rs.getString("stu_major"));
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					BDConnection.close();
				}
				
				panel_2.setVisible(true);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				
			}
			
			
		});
		
		jb2 = new JButton("修改个人资料");
		jb2.setBounds(16, 149, 122, 29);
		panel_1.add(jb2);
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql = "select * from stu_info where stu_id ='"+ Student.getStuID()+"'";
					rs = stmt.executeQuery(sql);
					
					if(rs.next()){
						jt1.setText(rs.getString("stu_id"));
						jt2.setText(rs.getString("stu_name"));
						jt3.setText(rs.getString("stu_userName"));
						if(rs.getString("stu_sex").equals("男")) {
							jr1.setSelected(true);
						}else if(rs.getString("stu_sex").equals("女")) {
							jr2.setSelected(true);
						}
						jt5.setText(rs.getString("stu_age"));
						jt6.setText(rs.getString("stu_major"));
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					BDConnection.close();
				}
				
				jt1.setEnabled(false);
				jt2.setEnabled(true);
				jt3.setEnabled(true);
				jt4.setEnabled(true);
				jt5.setEnabled(true);
				jt6.setEnabled(true);
			
				
				
				panel_3.add(jl1);
				panel_3.add(jt1);
				panel_3.add(jl2);
				panel_3.add(jt2);
				panel_3.add(jl3);
				panel_3.add(jt3);
				panel_3.add(jl4);
//				panel_3.add(jt4);
				panel_3.add(jl5);
				panel_3.add(jt5);
				panel_3.add(jl6);
				panel_3.add(jt6);
				
				panel_3.add(jb5);
				panel_3.add(jr1);
				panel_3.add(jr2);
				
				panel_3.setVisible(true);
				panel_2.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
			}
		});
		
		jb3 = new JButton("查看书本信息");
		jb3.setBounds(16, 240, 122, 29);
		panel_1.add(jb3);
		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				panel_4.setVisible(true);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				
				
				panel_4.add(jt10);
				panel_4.add(jb10);
				panel_4.add(jb11);
				panel_4.add(jb12);
				panel_4.add(cb);

				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql="select * from Book_info";
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						counter++;
					}
					rs = stmt.executeQuery(sql);
					columnNames = new  Object[] {"编号","书名","作者","价格","出版社","类别","简介","是否借出"};
					rowData = new Object[counter][columnNames.length];
					counter = 0;
					while(rs.next()) {
						rowData[counter][0] = rs.getString("book_id");
						rowData[counter][1] = rs.getString("book_name");
						rowData[counter][2] = rs.getString("book_author");
						rowData[counter][3] = rs.getString("book_price");
						rowData[counter][4] = rs.getString("book_press");
						rowData[counter][5] = rs.getString("book_category");
						rowData[counter][6] = rs.getString("book_describe");
						rowData[counter][7] = rs.getString("book_Lend");
						counter++;
					}
					jt = new JTable(rowData, columnNames);
					jt.setEnabled(false);
					jsp = new JScrollPane(jt);
					jsp.setBounds(10,40,380,150);
					panel_4.add(jsp);
				
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}finally {
					BDConnection.close();
				}
				
			}
		});
		
		jb4 = new JButton("退出系统");
		jb4.setBounds(16, 327, 122, 29);
		panel_1.add(jb4);
		jb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				System.exit(0);
			}
		});
		
		jb5 = new JButton("保存");
		jb5.setBounds(300, 348, 100, 30);
		jb5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				stu_id,stu_name,stu_userName,stu_sex,stu_age,stu_major;
				
				stu_name = jt2.getText();
				stu_userName = jt3.getText();
				stu_sex = jr1.isSelected()?"男":"女";
				stu_age = jt5.getText();
				stu_major = jt6.getText();
				
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql="update stu_info set stu_name = '"+stu_name+"', stu_userName = '"+stu_userName +"',stu_sex = '"+stu_sex+"',stu_age = '"+stu_age+"',stu_major = '"+stu_major+"' where stu_id = '"+Student.getStuID()+"'";
					int mun = stmt.executeUpdate(sql);
					if(mun >0){
						JOptionPane.showMessageDialog(null, "修改成功！");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					BDConnection.close();
				}
				
				
			}
		});
		
		
		
		jl8 = new JLabel("编号:");
		jl8.setBounds(60, 50, 70, 30);
		
		jt11 = new JTextField();
		jt11.setBounds(100, 50, 110, 30);
		
	
		
		
		jb13 = new JButton("确定");
		jb13.setBounds(210, 50, 70, 30);
		jb13.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql = "select stu_ci from stu_info where stu_id = '"+ Student.getStuID()+"'";
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						ci = Integer.parseInt(rs.getString("stu_ci"));
//						System.out.println(ci);
					}

					while(ci <= 0) {
						JOptionPane.showMessageDialog(null, "借阅失败！当前课借阅次数为："+ci+"次","借阅失败", 1, new ImageIcon("/imgs/failure.png"));
						break;
					}
					while(ci>=1) {
						sql = "select * from Book_info where book_id = '"+jt11.getText().trim()+"'";
						rs = stmt.executeQuery(sql) ;
						if(rs.next()){
							sql = "update Book_info set book_Lend = '已借出' where book_id = '"+jt11.getText().trim()+"'";
							int num = stmt.executeUpdate(sql);
							if(num > 0) {
								ci--;
								sql = "update stu_info set stu_ci ='"+ci+"'";
								num = stmt.executeUpdate(sql);
								if (num > 0) {
									JOptionPane.showMessageDialog(null, "借阅成功！当前课借阅次数为："+ci+"次","借阅成功", 1, new ImageIcon("/imgs/access.png"));
									
								}
							}
						}
						
					break;
				}
					
				} catch (SQLException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}finally {
					BDConnection.close();
				}
				
				
				
			
			}
		});

		cb = new CircleButton("?");
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "借书：每位同学有3次借书机会，每次借书次数-1，直至次数用完", "借书",JOptionPane.WARNING_MESSAGE);
				JOptionPane.showMessageDialog(null, "还书：每次还书，可借书次数+1，直至可借次数达到最大值3", "还书",JOptionPane.WARNING_MESSAGE);
			}
		});
		cb.setBounds(20, 221, 25, 25);
//		cb.setFont(new java.awt.Font("", 1, 9));
//		cb.setIcon(new ImageIcon(login.class.getResource("/imgs/问号.png")));
//		panel_2.add(cb);
	
		jb11 = new JButton("借书");
		jb11.setBounds(90, 221, 70, 30);
		jb11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				panel_5.setVisible(true);
				panel_6.setVisible(false);
				panel_5.add(jl8);
				panel_5.add(jt11);
				panel_5.add(jb13);
				
			}
		});
		
		jb12 = new JButton("还书");
		jb12.setBounds(200, 221, 70, 30);
		jb12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				panel_5.setVisible(false);
				panel_6.setVisible(true);
				
				panel_6.add(jl8);
				panel_6.add(jt11);
				panel_6.add(jb14);
				
				
			}
		});
		
		jb14 = new JButton("确定");
		jb14.setBounds(210, 50, 70, 30);
		jb14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql = "select stu_ci from stu_info where stu_id = '"+Student.getStuID()+"'";
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						ci = Integer.parseInt(rs.getString("stu_ci"));
					}
					if(ci == 3) {
						JOptionPane.showMessageDialog(null, "归还失败，已达归还最大次数！","还书提示",1,new ImageIcon("/imgs/failure.png"));
					}
					while(ci<3) {
						sql = "select * from Book_info where book_id = '"+jt11.getText().trim()+"'";
						rs = stmt.executeQuery(sql) ;
						if(rs.next()){
							sql = "update Book_info set book_Lend = '未借出'  where book_id = '"+jt11.getText().trim()+"'";
							int num = stmt.executeUpdate(sql);
							if(num > 0) {
								ci++;
								sql = "update stu_info set stu_ci ='"+ci+"'";
								num = stmt.executeUpdate(sql);
								if (num > 0) {
									JOptionPane.showMessageDialog(null, "借阅成功！当前课借阅次数为："+ci+"次","借阅成功", 1, new ImageIcon("/imgs/access.png"));
									
								}
							}
						}
						
					break;
					}
					
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}finally {
					BDConnection.close();
				}
				
			}
		});
	}
}
