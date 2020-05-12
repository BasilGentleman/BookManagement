package com.cn.bookManage;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

import com.cn.user.Manager;
import com.cn.user.Student;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 登录界面
 * @author mac
 *
 */
public class login extends MyFrame {
	private JPanel contentPane;
	public static String id;
	static JButton jb1,jb2,jb3,jb4,jb5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() { 
		setTitle("图书管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jb1 = new JButton("");
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		jb1.setIcon(new ImageIcon(login.class.getResource("/imgs/员工信息平台.png")));
		jb1.setBounds(43, 262, 247, 51);
		contentPane.add(jb1);
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Manager();
				dispose();
			}
		});
		
		jb2 = new JButton("");
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Student();
				dispose();
			}
		});
		jb2.setIcon(new ImageIcon(login.class.getResource("/imgs/学生信息平台.png")));
		jb2.setBounds(319, 262, 247, 51);
		contentPane.add(jb2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/imgs/标题.png")));
		lblNewLabel.setBounds(84, 45, 481, 174);
		contentPane.add(lblNewLabel);
		
		
	}

	
}
