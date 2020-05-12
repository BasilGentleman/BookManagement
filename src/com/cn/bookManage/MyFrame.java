package com.cn.bookManage;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
/**
 * 主体UI
 * @author mac
 *
 */
public class MyFrame extends JFrame {
	public JPanel contentPane;
	public JLabel lb1,lb2,lb3,lb4;
	public JTextField t1,t2;
	public static Statement stmt ;
	public static ResultSet rs ;
	public static Connection con ;
	public static String sql ;

	
	public MyFrame(){
		setSize(600,450);
		contentPane = new JPanel() ;
		contentPane.setBackground(new Color(176, 196, 222));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	}
}
