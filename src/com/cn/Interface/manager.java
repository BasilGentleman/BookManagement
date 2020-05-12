package com.cn.Interface;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;

import com.cn.bookManage.*;
import com.cn.tools.BDConnection;
import com.cn.user.*;
/**
 * 管理者界面
 * @author mac
 *
 */
public class manager extends MyFrame{
	private JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10,jb11,jb12,jb13,jb14,jb15,jb16,jb17,jb18;
	private JPanel panel;
	private JPanel panel_1,panel_2,panel_3,panel_4,panel_5,panel_6,panel_7;
	private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15,jl16,jl17,jl18,jl19,jl20,jl21,jl22,jl23,jl24,jl25,jl26;
	private JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8,jt9,jt10,jt11,jt12,jt13,jt14,jt15,jt16,jt17,jt18,jt19,jt20,jt21,jt22,jt23,jt24,jt25,jt26;
	private String manager_id,manager_name,manager_sex,manager_age,manager_Wyear,manager_majors,book_id ,book_name,book_author,book_price,book_press,book_category
	,book_describe;
	private JRadioButton jr1,jr2;
	private JComboBox jc1,jc2 ,jc3;
	private JTextPane jtp1,jtp2;
	private JTable jt;
	private JScrollPane jsp;
	private int counter;
	private Object [][]rowData;
	private Object []columnNames;
	
	public manager() {
		setVisible(true);
		setTitle("--"+Manager.getID()+"欢迎您--");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 186, 428);
		contentPane.add(panel);
		panel.setLayout(null);
		
		jb1 = new JButton("查看个人资料");
		jb1.setBounds(17, 28, 147, 29);
		panel.add(jb1);
//		jb1.setFont(new Font("幼圆", Font.BOLD, 18));
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_1.add(jl1);
				panel_1.add(jt1);
				panel_1.add(jl2);
				panel_1.add(jt2);
				panel_1.add(jl3);
//				panel_1.add(jt3);
				panel_1.add(jl4);
				panel_1.add(jt4);
				panel_1.add(jl5);
				panel_1.add(jt5);
				panel_1.add(jl6);
				panel_1.add(jt6);
				
				panel_1.add(jr1);
				panel_1.add(jr2);
				
				jt1.setEnabled(false);
				jt2.setEnabled(false);
//				jt3.setEnabled(false);
				jt4.setEnabled(false);
				jt5.setEnabled(false);
				jt6.setEnabled(false);
				
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql = "select * from manager_info where manager_id = '"+Manager.getID()+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()){
						jt1.setText(rs.getString("manager_id"));
						jt2.setText(rs.getString("manager_name"));
						if(rs.getString("manager_sex").equals("男")) {
							jr1.setSelected(true);
						}else if(rs.getString("manager_sex").equals("女")) {
							jr2.setSelected(true);
						}
						jt4.setText(rs.getString("manager_age"));
						jt5.setText(rs.getString("manager_Wyear"));
						jt6.setText(rs.getString("manager_majors"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					BDConnection.close();
				}
				
				
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				
				
			}
		});
		
		
		jb2 = new JButton("修改个人资料");
		jb2.setBounds(17, 85, 147, 29);
		panel.add(jb2);
//		jb2.setFont(new Font("幼圆", Font.BOLD, 18));
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql = "select * from manager_info where manager_id = '"+Manager.getID()+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()){
						jt1.setText(rs.getString("manager_id"));
						jt2.setText(rs.getString("manager_name"));
						if(rs.getString("manager_sex").equals("男")) {
							jr1.setSelected(true);
						}else if(rs.getString("manager_sex").equals("女")) {
							jr2.setSelected(true);
						}
						jt4.setText(rs.getString("manager_age"));
						jt5.setText(rs.getString("manager_Wyear"));
						jt6.setText(rs.getString("manager_majors"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					BDConnection.close();
				}
				
				panel_2.add(jl1);
				panel_2.add(jt1);
				panel_2.add(jl2);
				panel_2.add(jt2);
				panel_2.add(jl3);
//				panel_2.add(jt3);
				panel_2.add(jl4);
				panel_2.add(jt4);
				panel_2.add(jl5);
				panel_2.add(jt5);
				panel_2.add(jl6);
				panel_2.add(jt6);
				
				panel_2.add(jb8);
				panel_2.add(jr1);
				panel_2.add(jr2);
				
				jt1.setEnabled(false);
				jt2.setEnabled(true);
//				jt3.setEnabled(true);
				jt4.setEnabled(true);
				jt5.setEnabled(true);
				jt6.setEnabled(true);
				
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				
			}
		});
		

		jb3 = new JButton("查看书本信息");
		jb3.setBounds(17, 142, 147, 29);
		panel.add(jb3);
//		jb3.setFont(new Font("幼圆", Font.BOLD, 18));
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(true);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				
				panel_3.add(jb13);
				panel_3.add(jt16);
				

				
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
					jsp.setBounds(10,40,380,350);
					panel_3.add(jsp);
					
					
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}finally {
					BDConnection.close();
				}
				
				

				
			}
		});
		
		
		jb4 = new JButton("修改书本信息");
		jb4.setBounds(17, 256, 147, 29);
		panel.add(jb4);
//		jb4.setFont(new Font("幼圆", Font.BOLD, 18));
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(true);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				
				
			
				
				
				panel_4.add(jc2);
				panel_4.add(jl16);
				panel_4.add(jb14);
				panel_4.add(jb15);
				panel_4.add(jb16);
				panel_4.add(jb17);
				panel_4.add(jb18);
				panel_4.add(jl17);
				panel_4.add(jt17);
				
				panel_4.add(jl18);
				panel_4.add(jt18);
				panel_4.add(jl19);
				panel_4.add(jt19);
				panel_4.add(jl20);
				panel_4.add(jt20);
				panel_4.add(jl21);
				panel_4.add(jt21);
				panel_4.add(jl23);
				panel_4.add(jc3);
				panel_4.add(jl24);
				panel_4.add(jt24);
				panel_4.add(jl25);
				
				panel_4.add(jtp2);
				
				
			}
		});
		
		jb5 = new JButton("删除书本信息");
		jb5.setBounds(17, 313, 147, 29);
		panel.add(jb5);
//		jb5.setFont(new Font("幼圆", Font.BOLD, 18));
		jb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(true);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				
				panel_5.add(jl13);
				panel_5.add(jl14);
				panel_5.add(jb11);
				panel_5.add(jb12);
				panel_5.add(jt14);
				
			}
		});
		
		jb6 = new JButton("增添书本信息");
		jb6.setBounds(17, 199, 147, 29);
		panel.add(jb6);
//		jb6.setFont(new Font("幼圆", Font.BOLD, 18));
		jb6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(true);
				panel_7.setVisible(false);
				
				
				panel_6.add(jl7);
				panel_6.add(jt7);
				panel_6.add(jl8);
				panel_6.add(jt8);
				panel_6.add(jl9);
				panel_6.add(jt9);
				panel_6.add(jl10);
				panel_6.add(jt10);
				panel_6.add(jl11);
				panel_6.add(jtp1);
				panel_6.add(jl12);
				panel_6.add(jb9);
				panel_6.add(jb10);
				panel_6.add(jc1);
				panel_6.add(jt15);
				panel_6.add(jl15);
				
//				book_id ,book_name,book_author,book_price,book_press,book_category,book_describe
				
				
				
			}
		});
		
		jb7 = new JButton("退出系统");
		jb7.setBounds(17, 370, 147, 29);
		panel.add(jb7);
		jb7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});
		//面板1
		panel_1 = new JPanel();
		panel_1.setBounds(196, 0, 404, 428);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		jl7 = new JLabel("书名:");
		jl7.setHorizontalAlignment(SwingConstants.RIGHT);
		jl7.setBounds(19, 25, 37, 30);
		
		
		jt7 = new JTextField();
		jt7.setBounds(68, 27, 120, 26);
		jt7.setColumns(10);
		
		jl8 = new JLabel("作者:");
		jl8.setHorizontalAlignment(SwingConstants.RIGHT);
		jl8.setBounds(211, 32, 37, 16);
		
		jt8 = new JTextField();
		jt8.setColumns(10);
		jt8.setBounds(258, 27, 120, 26);
		
		jl9 = new JLabel("编号:");
		jl9.setHorizontalAlignment(SwingConstants.RIGHT);
		jl9.setBounds(19, 85, 37, 30);
		
		jt9 = new JTextField();
		jt9.setColumns(10);
		jt9.setBounds(68, 87, 120, 26);
		
		jl10 = new JLabel("价格:");
		jl10.setHorizontalAlignment(SwingConstants.RIGHT);
		jl10.setBounds(211, 85, 37, 30);
		
		jt10 = new JTextField();
		jt10.setColumns(10);
		jt10.setBounds(258, 87, 120, 26);
		
		jl11 = new JLabel("图书类别:");
		jl11.setHorizontalAlignment(SwingConstants.RIGHT);
		jl11.setBounds(6, 142, 61, 16);
		
		String [] category = {"计算机类","医学类","哲学","经济","文学","历史"}; 
		
		jc1 = new JComboBox(category);
		jc1.setBounds(74, 138, 145, 27);
		
		jl15 = new JLabel("出版社:");
		jl15.setBounds(217, 138, 51, 30);
		
		jt15 = new JTextField();
		jt15.setBounds(270, 138, 100, 30);
		
		jl12 = new JLabel("图书简介:");
		jl12.setHorizontalAlignment(SwingConstants.RIGHT);
		jl12.setBounds(6, 196, 61, 16);
		
		jtp1 = new JTextPane();
		jtp1.setBounds(74, 191, 304, 176);
//		jtp1.setColumns(10);
		
		jb9 = new JButton("添加");
		jb9.setBounds(164, 379, 107, 29);
		jb9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				book_id = jt9.getText().trim();
				book_name = jt7.getText().trim();
				book_author = jt8.getText().trim();
				book_price = jt10.getText().trim();
				book_press = jt15.getText().trim();
				book_category = jc1.getSelectedItem().toString().trim();
				book_describe = jtp1.getText();
//				System.out.println(book_id +book_name+book_author+book_price+book_category+book_describe);
				
				con =BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql = "select * from Book_info where book_id ='"+book_id+"'";
					rs = stmt.executeQuery(sql);
					if(!rs.next()) {
						sql="insert into Book_info (book_id,book_name,book_author,book_price,book_press,book_category,book_describe) values('"+book_id+"','"+book_name+"','"+book_author+"','"+book_price+"','"+book_press+"','"+book_category+"','"+book_describe+"') ";
//						System.out.println(sql);
						int num = stmt.executeUpdate(sql);
						if(num > 0){
							JOptionPane.showMessageDialog(null, "书籍编号"+book_id+"添加成功!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "书籍编号"+book_id+"该书籍已存在！");
					}
					
					
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
			}
		});
		
		jb10 = new JButton("重置");
		jb10.setBounds(283, 379, 107, 29);
		jb10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				jt7.setText("");
				jt8.setText("");
				jt9.setText("");
				jt10.setText("");
				jtp1.setText("");
			}
		});
		
		//用户名
		jl1 = new JLabel("用户名");
		jl1.setBounds(10, 34, 51, 30);
		jl1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		jt1 = new JTextField();
		jt1.setBounds(104, 42, 109, 21);
		
		//姓名
		jl2 = new JLabel("姓名");
		jl2.setBounds(10, 98, 51, 30);
		jl2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		jt2 = new JTextField();
		jt2.setBounds(104, 105, 67, 21);
		
		//性别
		jl3 = new JLabel("性别");
		jl3.setBounds(10, 162, 51, 30);
		jl3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		ButtonGroup bg = new ButtonGroup();
		
		jr1 = new JRadioButton("男");
		jr1.setBounds(104, 168, 50, 30);
		
		jr2 = new JRadioButton("女");
		jr2.setBounds(144, 168, 50, 30);
		
		bg.add(jr1);
		bg.add(jr2);
		
		//年龄
		jl4 = new JLabel("年龄");
		jl4.setBounds(10, 226, 51, 30);
		jl4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		jt4 = new JTextField();
		jt4.setBounds(104, 231, 67, 21);
		
		//工龄
		jl5 = new JLabel("工龄");
		jl5.setBounds(10, 290, 51, 30);
		jl5.setHorizontalAlignment(SwingConstants.RIGHT);
		
		jt5 = new JTextField();
		jt5.setBounds(104, 294, 67, 21);
	
		//科目
		jl6 = new JLabel("任职科目");
		jl6.setBounds(0, 354, 70, 30);
		jl6.setHorizontalAlignment(SwingConstants.RIGHT);
		
		jt6 = new JTextField();
		jt6.setBounds(104, 357, 67, 21);
		panel_1.setVisible(false);
		
		jb8 = new JButton("保存");
		jb8.setBounds(292, 364, 100, 30);
		jb8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
//				manager_id,manager_name,manager_sex,manager_age,manager_Wyear,manager_majors;
				manager_id = Manager.getID();
//				jt1.setText(manager_id);
				manager_name = jt2.getText();
//				manager_sex = jt3.getText();
				manager_sex = jr1.isSelected()?"男":"女";
				manager_age = jt4.getText();
				manager_Wyear = jt5.getText();
				manager_majors = jt6.getText();
				
				
//				System.out.println(manager_id+manager_name+manager_sex+manager_age+manager_Wyear+manager_majors);
				
				
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql="select * from manager_info where manager_id ='"+manager_id+"'";
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						sql ="update manager_info set manager_name ='"+manager_name+"', manager_sex ='"+manager_sex+"',manager_age = '"+manager_age+"' , manager_Wyear ='"+manager_Wyear+"' , manager_majors = '"+manager_majors+"' where  manager_id ='"+Manager.getID()+"'";
					}else {
						sql="insert into manager_info values('"+manager_id+"','"+manager_name+"','"+manager_sex+"',"+manager_age+","+manager_Wyear+",'"+manager_majors+"')";
					}
					
					int num = stmt.executeUpdate(sql);
					if(num >0 ) {
						JOptionPane.showMessageDialog(null, "修改成功！" );
					}
//					System.out.println(sql);
					
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}finally {
					BDConnection.close();
				}
			}
		});
		
		
		
		//面板2
		panel_2 = new JPanel();
		panel_2.setBounds(196, 0, 404, 428);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		
		// 面板3
		panel_3 = new JPanel();
		panel_3.setBounds(196, 0, 404, 428);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setVisible(false);
		
		jb13 = new JButton("搜索");
		jb13.setBounds(300, 10, 70, 30);
		jb13.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				jsp.setVisible(false);
				book_id = jt16.getText().trim();
				
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql="select * from Book_info where book_id ='"+book_id+"'";
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						counter++;
					}
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						columnNames = new  Object[] {"编号","书名","作者","价格","出版社","类别","简介","是否借出"};
						rowData = new Object[counter][columnNames.length];
						counter=0;
							rowData[counter][0] = rs.getString("book_id");
							rowData[counter][1] = rs.getString("book_name");
							rowData[counter][2] = rs.getString("book_author");
							rowData[counter][3] = rs.getString("book_price");
							rowData[counter][4] = rs.getString("book_press");
							rowData[counter][5] = rs.getString("book_category");
							rowData[counter][6] = rs.getString("book_describe");
							rowData[counter][7] = rs.getString("book_Lend");
						jt = new JTable(rowData, columnNames);
						jt.setEnabled(false);
						jsp = new JScrollPane(jt);
						jsp.setBounds(10,40,380,350);
						panel_3.add(jsp);
					}else {
						JOptionPane.showMessageDialog(null, "您输入的书籍编号"+book_id+"该书籍不存在！");
					}
					
					
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}finally {
					BDConnection.close();
				}
				
				
			}
		});
		
		jt16 = new JTextField();
		jt16.setBounds(150, 10, 150, 30);
		jt16.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				jt16.setText("请输入书籍编号");
				jt16.setForeground(Color.GRAY);
			}
		});
		
		//面板4
		panel_4 = new JPanel();
		panel_4.setBounds(196, 0, 404, 428);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setVisible(false);
		
		jc2 = new JComboBox(category);
		jc2.setBounds(121, 1, 140, 42);
		
		jl16 = new JLabel("请选择书籍类别");
		jl16.setBounds(23, 6, 100, 30);
		
		
		jl18 = new JLabel("编号：");
		jl18.setHorizontalAlignment(SwingConstants.RIGHT);
		jl18.setBounds(23, 226, 50, 16);
		
		jt18 = new JTextField();
		jt18.setBounds(71, 221, 80, 26);
		jt18.setColumns(10);
		
		jl19 = new JLabel("书名：");
		jl19.setHorizontalAlignment(SwingConstants.RIGHT);
		jl19.setBounds(186, 226, 50, 16);
		
		
		jt19 = new JTextField();
		jt19.setColumns(10);
		jt19.setBounds(248, 221, 115, 26);
		
		
		jl20= new JLabel("作者：");
		jl20.setHorizontalAlignment(SwingConstants.RIGHT);
		jl20.setBounds(23, 260, 50, 16);
		
		
		jt20 = new JTextField();
		jt20.setColumns(10);
		jt20.setBounds(71, 255, 102, 26);
		
		
		jl21 = new JLabel("出版社：");
		jl21.setHorizontalAlignment(SwingConstants.RIGHT);
		jl21.setBounds(171, 260, 65, 16);
	
		
		jt21 = new JTextField();
		jt21.setColumns(10);
		jt21.setBounds(248, 255, 115, 26);
		
		
		jl23 = new JLabel("类别：");
		jl23.setHorizontalAlignment(SwingConstants.RIGHT);
		jl23.setBounds(23, 296, 50, 16);
		
		
		jc3 = new JComboBox(category);
		jc3.setBounds(71, 293, 102, 27);
		
		
		jl24 = new JLabel("价格：");
		jl24.setHorizontalAlignment(SwingConstants.RIGHT);
		jl24.setBounds(186, 296, 50, 16);
		
		jt24 = new JTextField();
		jt24.setColumns(10);
		jt24.setBounds(248, 293, 80, 26);
		
		jl25= new JLabel("简介：");
		jl25.setHorizontalAlignment(SwingConstants.RIGHT);
		jl25.setBounds(23, 324, 50, 16);
		
		jtp2 = new JTextPane();
		jtp2.setBounds(81, 332, 247, 51);
		
		jt18.setEditable(false);
		jt19.setEditable(false);
		jt20.setEditable(false);
		jt21.setEditable(false);
		jt24.setEditable(false);
		jtp2.setEditable(false);
		jc3.setEnabled(false);
		
		jb14 = new JButton("查询");
		jb14.setBounds(273, 7, 100, 30);
		jb14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String get_cate = jc2.getSelectedItem().toString().trim();
				
				
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql="select * from Book_info where book_category  = '"+get_cate+"'";
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
		
		jl17 = new JLabel("请输入书籍编号：");
		jl17.setHorizontalAlignment( SwingConstants.RIGHT);
		jl17.setBounds(0,190,130,30);
		
		jt17 = new JTextField();
		jt17.setBounds(120, 190, 160, 25);
		
		jb15 = new JButton("搜索");
		jb15.setBounds(273, 190, 100, 30);
		jb15.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				book_id = jt17.getText().trim();
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql = "select * from Book_info where book_id = '"+book_id +"'";
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						jt18.setText(rs.getString("book_id"));
						jt19.setText(rs.getString("book_name"));
						jt20.setText(rs.getString("book_author"));
						jt21.setText(rs.getString("book_press"));
						jt24.setText(rs.getString("book_price"));
						jc3.setSelectedItem(rs.getString("book_category"));
						jtp2.setText(rs.getString("book_describe"));
						
						book_category = jc3.getSelectedItem().toString();
						book_describe = jtp2.getText().trim();
					}else {
						JOptionPane.showMessageDialog(null, "您输入书籍编号:"+book_id+"不存在");
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}finally {
					BDConnection.close();
				}
				
				
			}
		});
		jb18 = new JButton("修改");
		jb18.setBounds(80, 390, 100, 30);
		jb18.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				jt19.setEditable(true);
				jt20.setEditable(true);
				jt21.setEditable(true);
				jt24.setEditable(true);
				jtp2.setEditable(true);
				jc3.setEnabled(true);
				
			}
		});
		
		jb16 = new JButton("确认");
		jb16.setBounds(180, 390, 100, 30);
		jb16.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				book_id = jt18.getText().trim();
				book_name = jt19.getText().trim();
				book_author = jt20.getText().trim();
				book_price = jt24.getText().trim();
				book_press = jt21.getText().trim();
				book_category = jc3.getSelectedItem().toString();
				book_describe = jtp2.getText().trim();
				
				
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql = "select * from Book_info where book_id = '"+book_id +"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						sql = "update Book_info set book_name = '"+book_name+"' , book_author = '"+book_author+"' ,book_price = '"+book_price+"' ,book_press = '"+book_press+"' ,book_category = '"+book_category+"' ,book_describe = '"+book_describe+"' where book_id = '"+book_id+"'";
						int num = stmt.executeUpdate(sql);
						if(num > 0) {
							JOptionPane.showMessageDialog(null, "修改成功!");
							jt17.setText("");
							jt18.setText("");
							jt19.setText("");
							jt20.setText("");
							jt21.setText("");
							jt24.setText("");
							jtp2.setText("");
							jt18.setEditable(false);
							jt19.setEditable(false);
							jt20.setEditable(false);
							jt21.setEditable(false);
							jt24.setEditable(false);
							jtp2.setEditable(false);
							jc3.setEnabled(false);
						}else {
							JOptionPane.showMessageDialog(null, "修改失败!");
							
						}
					}
					
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}finally {
					BDConnection.close();
				}
			}
		});
		jb17 = new JButton("重置");
		jb17.setBounds(273, 390, 100, 30);
		jb17.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
//				jt18.setText("");
				jt19.setText("");
				jt20.setText("");
				jt21.setText("");
				jt24.setText("");
				jtp2.setText("");
			}
		});
		
		
		//面板5
		panel_5 = new JPanel();
		panel_5.setBounds(196, 0, 404, 428);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setVisible(false);
		

		jl13 = new JLabel("请输入您要删除的书本编号：");
		jl13.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		jl13.setHorizontalAlignment(SwingConstants.CENTER);
		jl13.setBounds(125, 134, 208, 29);
		
		
		jl14 = new JLabel("");
		jl14.setIcon(new ImageIcon(manager.class.getResource("/imgs/警告.png")));
		jl14.setBounds(57, 110, 73, 66);
		
		jt14 = new JTextField();
		jt14.setBounds(113, 206, 208, 29);
		
		jb11 = new JButton("重置");
		jb11.setBounds(228, 275, 93, 30);
		jb11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				jt14.setText("");
			}
		});
		
		jb12 = new JButton("删除");
		jb12.setBounds(94, 275, 85, 30);
		jb12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String getBook_id = jt14.getText().trim();
				
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql ="select * from Book_info WHERE book_id='"+getBook_id+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						sql ="DELETE FROM Book_info WHERE book_id='"+getBook_id+"'";
						int num = stmt.executeUpdate(sql);
						if(num >0 ) {
							JOptionPane.showMessageDialog(null, "书籍编号"+getBook_id+"删除成功！");
						}
					}else {
						JOptionPane.showMessageDialog(null, "书籍编号"+getBook_id+"该书籍不存在！");
						
					}
					
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}finally {
					BDConnection.close();
				}
						
			}
		});
		
		
		
		//面板6
		panel_6 = new JPanel();
		panel_6.setBounds(196, 0, 404, 428);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setVisible(false);
		
		
		//面板7
		panel_7 = new JPanel();
		panel_7.setBounds(196, 0, 404, 428);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		panel_7.setVisible(false);
		
//		jb7.setFont(new Font("幼圆", Font.BOLD, 18));
		jb7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				System.exit(0);
				
			}
		});
		
		
		
	}
}
