package com.cn.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;

import com.cn.Interface.Resiter;
import com.cn.Interface.Student_login;
import com.cn.bookManage.*;
import com.cn.tools.BDConnection;
import com.cn.tools.DigestUtil;

public class Student extends MyFrame{
	private static String id ,password;
	private JLabel jl,jl1,jl2,jl3;
	private static JTextField jt1;
	private JPasswordField jp;
	private JButton jb1,jb2,jb3,jb4;
	public Student() {

		setTitle("--学生登录--");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		jl= new JLabel("");
	    jl.setFont(new Font("宋体", Font.PLAIN, 18));
	    jl.setIcon(new ImageIcon(login.class.getResource("/imgs/书标.png")));
	    jl.setBounds(180, 86, 54, 55);
		contentPane.add(jl);
		
		jl1 = new JLabel("图书管理系统");
		jl1.setHorizontalAlignment(SwingConstants.CENTER);
		jl1.setFont(new Font("Dialog", Font.BOLD, 25));
		jl1.setBounds(246, 86, 168, 55);
		contentPane.add(jl1);
		
		
		
		jl2 = new JLabel("学   号:");
		jl2.setHorizontalAlignment(SwingConstants.RIGHT);
		jl2.setFont(new Font("幼圆", Font.BOLD, 18));
		jl2.setBounds(98, 185, 100, 30);
		contentPane.add(jl2);
		
		jt1 = new JTextField();
		jt1.setBounds(246, 188, 197, 28);
		contentPane.add(jt1);
		
		jl3 = new JLabel("密	  码：");
		jl3.setHorizontalAlignment(SwingConstants.RIGHT);
		jl3.setFont(new Font("幼圆", Font.BOLD, 18));
		jl3.setBounds(113, 230, 100, 30);
		contentPane.add(jl3);
		
		jp = new JPasswordField();
		jp.setBounds(246, 230, 197, 28);
		contentPane.add(jp);
		
		jb1 = new JButton("登	录");
		jb1.setBounds(180, 310, 100, 30);
		contentPane.add(jb1);
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				id = jt1.getText().trim();
				password = new String(jp.getPassword()).trim();
				password = DigestUtil.md5Hex(password);
				if (id.equals("")||password.equals("")) {
					JOptionPane.showMessageDialog(null, "字段不能为空");
				}else {
					con = BDConnection.getConnection();
					try {
						stmt = con.createStatement();
						sql="select * from stu_info where stu_id = '"+id +"' and stu_password = '"+password+"'";
						rs = stmt.executeQuery(sql);
						if(rs.next()){
							JOptionPane.showMessageDialog(null, "登录成功！");
							new Student_login();
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "用户名或密码有误");
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally {
						BDConnection.close();
					}
					
					
					
				}
			}
		});
		
		jb2 = new JButton("注	册");
		jb2.setBounds(40, 310, 100, 30);
		contentPane.add(jb2);
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new Resiter();
			}
		});
		
		jb3 = new JButton("重	置");
		jb3.setBounds(320, 310, 100, 30);
		contentPane.add(jb3);
		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				jt1.setText("");
				jp.setText("");
			}
		});
		
		
		jb4 = new JButton("取	消");
		jb4.setBounds(460, 310, 100, 30);
		contentPane.add(jb4);
		jb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});
		
		
		
	}
	public static String getStuID() {
		id = jt1.getText().trim();
		return id;
		
	}
	

}
