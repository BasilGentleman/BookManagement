package model;

public class User {
	private String id ,password;
	//构造方法
	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	//生成get、set方法
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	/*
	 * 管理员信息表字段:manager_id      工号
					 manager_name  	 姓名
					 manager_sex 	 性别
					 manager_age	 年龄
					 manager_Wyear	 工龄
					 manager_majors  任职专业
	 */
	



	private String manager_id,manager_name,manager_sex,manager_age,manager_Wyear,manager_majors;
	
	//生成get、set方法
	public String getManager_id() {
		return manager_id;
	}


	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}


	public String getManager_name() {
		return manager_name;
	}


	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}


	public String getManager_sex() {
		return manager_sex;
	}


	public void setManager_sex(String manager_sex) {
		this.manager_sex = manager_sex;
	}


	public String getManager_age() {
		return manager_age;
	}


	public void setManager_age(String manager_age) {
		this.manager_age = manager_age;
	}


	public String getManager_Wyear() {
		return manager_Wyear;
	}


	public void setManager_Wyear(String manager_Wyear) {
		this.manager_Wyear = manager_Wyear;
	}


	public String getManager_majors() {
		return manager_majors;
	}


	public void setManager_majors(String manager_majors) {
		this.manager_majors = manager_majors;
	}
	
	
	
	
	/*
	 * 学生信息表字段:
	 * 
	 * 		stu_id       学号
			stu_name 	 姓名
			stu_userName 用户名
			stu_password 密码
			stu_sex 	 性别
			stu_age 	 年龄
			stu_major 	 专业
			stu_ci		 可借阅次数
	 */
	
	






	private String stu_id,stu_name,stu_userName,stu_password,stu_sex,stu_age,stu_major;
	
	//生成get、set方法
	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_userName() {
		return stu_userName;
	}

	public void setStu_userName(String stu_userName) {
		this.stu_userName = stu_userName;
	}

	public String getStu_password() {
		return stu_password;
	}

	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public String getStu_age() {
		return stu_age;
	}

	public void setStu_age(String stu_age) {
		this.stu_age = stu_age;
	}

	public String getStu_major() {
		return stu_major;
	}

	public void setStu_major(String stu_major) {
		this.stu_major = stu_major;
	}
	
	
	
	
	
	
	
	
	
}
