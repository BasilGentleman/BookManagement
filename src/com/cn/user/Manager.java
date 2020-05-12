package com.cn.user;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

import com.cn.Interface.manager;
import com.cn.bookManage.*;
import com.cn.tools.*;

public class Manager extends MyFrame {
	
	static JLabel jl, jl1,jl2,jl3;
	static JPasswordField jp;
	static JButton jb1,jb2,jb3;
	static JTextField jt1;
	private static String id , password;
	

	public Manager() {
		setVisible(true);
		setTitle("--管理员登录界面--");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    jl= new JLabel("");
	    jl.setFont(new Font("幼圆", Font.PLAIN, 18));
	    jl.setIcon(new ImageIcon(login.class.getResource("/imgs/书标.png")));
	    jl.setBounds(180, 86, 54, 55);
		contentPane.add(jl);
		
		jl3 = new JLabel("图书管理系统");
		jl3.setHorizontalAlignment(SwingConstants.CENTER);
		jl3.setFont(new Font("幼圆", Font.BOLD, 25));
		jl3.setBounds(246, 86, 168, 55);
		contentPane.add(jl3);
		
		jl1 = new JLabel("用户名：");
		jl1.setHorizontalAlignment(SwingConstants.RIGHT);
		jl1.setFont(new Font("幼圆", Font.BOLD, 18));
		jl1.setBounds(113, 185, 100, 30);
		contentPane.add(jl1);
		
		jt1 = new JTextField();
		jt1.setBounds(246, 188, 197, 28);
		contentPane.add(jt1);
		
		jl2 = new JLabel("密	  码：");
		jl2.setHorizontalAlignment(SwingConstants.RIGHT);
		jl2.setFont(new Font("幼圆", Font.BOLD, 18));
		jl2.setBounds(113, 230, 100, 30);
		contentPane.add(jl2);
		
		jp = new JPasswordField();
		jp.setBounds(246, 230, 197, 28);
		contentPane.add(jp);
		
		jb1 = new JButton("登录");
//		jb1.setFont(new Font("幼圆", Font.BOLD, 18));
		jb1.setBounds(125, 300, 100, 28);
		contentPane.add(jb1);
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				id = jt1.getText().trim();
				password = new String(jp.getPassword()).trim();
				password = DigestUtil.md5Hex(password);
				con = BDConnection.getConnection();
				try {
					stmt = con.createStatement();
					sql = "select * from manager where id = '"+id+"' and password = '"+password+"'";
					rs = stmt.executeQuery(sql);
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "登录成功！");
						new manager();
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "用户名或密码有误！");
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					BDConnection.close();
				}
			}
		});
		
		
		jb2 = new JButton("重置");
//		jb2.setFont(new Font("幼圆", Font.BOLD, 18));
		jb2.setBounds(256, 300, 100, 28);
		contentPane.add(jb2);
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jt1.setText("");
				jp.setText("");
			}
		});
		

		jb3 = new JButton("退出");
//		jb3.setFont(new Font("幼圆", Font.BOLD, 18));
		jb3.setBounds(383, 300, 100, 28);
		contentPane.add(jb3);
		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
	}
	public static String getID() {
		id = jt1.getText().trim();
		return id;
		
	}
	public static String getPassword(){
		password = new String(jp.getPassword()).trim();
		password = DigestUtil.md5Hex(password);
		return password;
	}
}
