package com.cn.Interface;

import javax.swing.*;
import javax.swing.GroupLayout.*;
import javax.swing.border.*;

import com.cn.bookManage.*;
import com.cn.tools.BDConnection;
import com.cn.tools.DigestUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 注册界面
 * @author mac
 *
 */
public class Resiter extends MyFrame{
	private JLabel jl, jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15,jl16;
	private JTextField jt1,jt2,jt3,jt4,jt5;
	private JRadioButton jr1,jr2;
	private JPasswordField jp1,jp2;
	private JButton jb1,jb2,jb3;
	private String stu_id,stu_name,stu_userName,stu_password,stu_sex,stu_age,stu_major,stu_repassword;
	
	public Resiter() {
		setTitle("用户注册");
		setFocusable(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		
		jl= new JLabel("");
	    jl.setFont(new Font("幼圆", Font.PLAIN, 18));
	    jl.setIcon(new ImageIcon(login.class.getResource("/imgs/书标.png")));
	    jl.setBounds(184, 35, 54, 55);
		contentPane.add(jl);
		
		jl1 = new JLabel("图书管理系统用户注册");
		jl1.setHorizontalAlignment(SwingConstants.CENTER);
		jl1.setFont(new Font("幼圆", Font.BOLD, 16));
		jl1.setBounds(250, 35, 191, 55);
		contentPane.add(jl1);
		
		jl2 = new JLabel("学		号:");
		jl2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		jl2.setHorizontalAlignment(SwingConstants.RIGHT);
		jl2.setBounds(56, 111, 100, 30);
		contentPane.add(jl2);
		
		jt1 = new JTextField();
		jt1.setBounds(194, 112, 296, 30);
		contentPane.add(jt1);
		jt1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				 stu_id = jt1.getText().trim();
				 Pattern p = Pattern.compile("[1-9]\\d{11}");
				 Matcher m = p.matcher(stu_id);
				 boolean b = m.matches();
				 if(b) {
					 jl9.setText("正确");
					 jl9.setForeground(new Color(0,100,0));
				 }else {
					 jl9.setText("错误");
					 jl9.setForeground(Color.RED);
				 }
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				jl9.setVisible(true);
			}
		});
		
		jl9 = new JLabel("请输入非零开头的12位学号");
		jl9.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		jl9.setForeground(Color.RED);
		jl9.setHorizontalAlignment(SwingConstants.LEFT);
		jl9.setBounds(488, 118, 100, 23);
		jl9.setVisible(false);
		contentPane.add(jl9);
		
		
		
		jl3 = new JLabel("姓		名:");
		jl3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		jl3.setHorizontalAlignment(SwingConstants.RIGHT);
		jl3.setBounds(56, 140, 100, 30);
		contentPane.add(jl3);
		
		jt2 = new JTextField();
		jt2.setBounds(194, 141, 296, 30);
		contentPane.add(jt2);
		jt2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				jl10.setVisible(false);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				jl10.setVisible(true);
			}
		});
		
		jl10 = new JLabel("请输入姓名");
		jl10.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		jl10.setForeground(Color.RED);
		jl10.setHorizontalAlignment(SwingConstants.LEFT);
		jl10.setBounds(488, 147, 100, 23);
		jl10.setVisible(false);
		contentPane.add(jl10);
		
		jl3 = new JLabel("用户名:");
		jl3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		jl3.setHorizontalAlignment(SwingConstants.RIGHT);
		jl3.setBounds(56, 171, 100, 30);
		contentPane.add(jl3);
		
		jt3 = new JTextField();
		jt3.setBounds(194, 171, 296, 30);
		contentPane.add(jt3);
		jt3.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				jl11.setVisible(false);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				jl11.setVisible(true);
			}
		});
		
		jl11 = new JLabel("请输入5个字符以下的用户名");
		jl11.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		jl11.setForeground(Color.RED);
		jl11.setHorizontalAlignment(SwingConstants.LEFT);
		jl11.setBounds(488, 178, 112, 23);
		jl11.setVisible(false);
		contentPane.add(jl11);
		
		jl4 = new JLabel("密码:");
		jl4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		jl4.setHorizontalAlignment(SwingConstants.RIGHT);
		jl4.setBounds(56, 201, 100, 30);
		contentPane.add(jl4);
		
		jp1 = new JPasswordField();
		jp1.setBounds(194, 201, 296, 30);
		contentPane.add(jp1);
		jp1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				stu_password = new String(jp1.getPassword()).trim();
				Pattern p = Pattern.compile("\\\\d{6}");
				Matcher m = p.matcher(stu_password);
				boolean b = m.matches();
				if(b) {
					jl12.setText("正确");
					jl12.setForeground(new Color(0,100,0));
				}else {
					jl12.setText("您设置的密码不符要求");
					jl12.setForeground(Color.RED);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				jl12.setVisible(true);
			}
		});
		
		jl12 = new JLabel("请输入6位数密码");
		jl12.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		jl12.setForeground(Color.RED);
		jl12.setHorizontalAlignment(SwingConstants.LEFT);
		jl12.setBounds(488, 206, 100, 23);
		jl12.setVisible(false);
		contentPane.add(jl12);
		
		jl5 = new JLabel("确认密码:");
		jl5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		jl5.setHorizontalAlignment(SwingConstants.RIGHT);
		jl5.setBounds(56, 231, 100, 30);
		contentPane.add(jl5);
		
		jp2 = new JPasswordField();
		jp2.setBounds(194, 231, 296, 30);
		contentPane.add(jp2);
		jp2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				stu_password = new String(jp1.getPassword()).trim();
				stu_repassword = new String(jp2.getPassword()).trim();
				if (stu_password.equals(stu_repassword)) {
					jl13.setText("正确");
					jl13.setForeground(new Color(0,100,0));
				}else {
					jl13.setText("您输入的密码不一致");
					jl13.setForeground(Color.RED);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				jl13.setVisible(true);
			}
		});
		
		jl13 = new JLabel("请重复密码");
		jl13.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		jl13.setForeground(Color.RED);
		jl13.setHorizontalAlignment(SwingConstants.LEFT);
		jl13.setBounds(488, 234, 100, 23);
		jl13.setVisible(false);
		contentPane.add(jl13);
		
		jl6= new JLabel("性别");
		jl6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		jl6.setHorizontalAlignment(SwingConstants.RIGHT);
		jl6.setBounds(56, 261, 100, 30);
		contentPane.add(jl6);
		
		ButtonGroup bg = new ButtonGroup();
		
		jr1 = new JRadioButton("男");
		jr1.setSelected(true);
		jr1.setBounds(193, 262, 45, 30);
		contentPane.add(jr1);
		bg.add(jr1);
		
		jr2 = new JRadioButton("女");
		jr2.setBounds(250, 262, 45, 30);
		contentPane.add(jr2);
		bg.add(jr2);
		
		jl7 = new JLabel("年龄:");
		jl7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		jl7.setHorizontalAlignment(SwingConstants.RIGHT);
		jl7.setBounds(335, 261, 67, 30);
		contentPane.add(jl7);
		
		jt4 = new JTextField();
		jt4.setBounds(431, 262, 59, 30);
		contentPane.add(jt4);
		jt4.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				jl14.setVisible(false);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				jl14.setVisible(true);
			}
		});
		
		jl14 = new JLabel("请输入合法年龄");
		jl14.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		jl14.setForeground(Color.RED);
		jl14.setHorizontalAlignment(SwingConstants.LEFT);
		jl14.setBounds(488, 264, 100, 23);
		jl14.setVisible(false);
		contentPane.add(jl14);
		
		jl8 = new JLabel("所属班级:");
		jl8.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		jl8.setHorizontalAlignment(SwingConstants.RIGHT);
		jl8.setBounds(56, 288, 100, 30);
		contentPane.add(jl8);
		
		jt5 = new JTextField();
		jt5.setBounds(194, 289, 296, 30);
		contentPane.add(jt5);
		jt5.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				jl15.setVisible(false);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				jl15.setVisible(true);
			}
		});
		
		jl15 = new JLabel("请输入班级");
		jl15.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		jl15.setForeground(Color.RED);
		jl15.setHorizontalAlignment(SwingConstants.LEFT);
		jl15.setBounds(488, 294, 100, 23);
		jl15.setVisible(false);
		contentPane.add(jl15);
		
		jb1 = new JButton("注册");
		jb1.setBounds(105, 349, 100, 30);
		contentPane.add(jb1);
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				stu_id = jt1.getText().trim();
				stu_name = jt2.getText().trim();
				stu_userName = jt3.getText().trim();
				stu_password = new String(jp1.getPassword()).trim();
				stu_repassword = new String(jp2.getPassword()).trim();
				stu_sex = jr1.isSelected()?"男":"女";
				stu_age = jt4.getText().trim();
				stu_major = jt5.getText().trim();
				
				
				if (stu_id.equals("")||stu_name.equals("")||stu_userName.equals("")||stu_password.equals("")||stu_repassword.equals("")||stu_age.equals("")||stu_major.equals("")) {
					JOptionPane.showMessageDialog(null, "字段不能为空！");
				}else {
					con = BDConnection.getConnection();
					try {
						stmt =con.createStatement();
						sql = "select stu_id from stu_info where stu_id ='"+stu_id+"'";
						rs = stmt.executeQuery(sql);
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "该学号已被注册！");
						}else {
							stu_password = DigestUtil.md5Hex(stu_password);
							sql= "insert into stu_info (stu_id,stu_name,stu_userName,stu_password,stu_sex,stu_age,stu_major) values('"+stu_id+"','"+stu_name+"','"+stu_userName+"','"+stu_password+"','"+stu_sex+"',"+stu_age+",'"+stu_major+"')";
							int num =stmt.executeUpdate(sql);
							if (num > 0) {
								JOptionPane.showMessageDialog(null, "注册成功！");
								dispose();
							}
						}
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}finally {
						BDConnection.close();
					}
				}
				
			}
		});
		
		jb2 = new JButton("重置");
		jb2.setBounds(250, 349, 100, 30);
		contentPane.add(jb2);
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				jt1.setText("");
				jt2.setText("");
				jt3.setText("");
				jt4.setText("");
				jt5.setText("");
				jp1.setText("");
				jp2.setText("");
			}
		});
		
		
		jb3 = new JButton("取消");
		jb3.setBounds(390, 349, 100, 30);
		contentPane.add(jb3);
		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});
	}
}
