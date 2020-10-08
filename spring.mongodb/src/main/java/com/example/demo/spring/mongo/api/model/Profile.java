package com.example.demo.spring.mongo.api.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "Users")
@ToString

public class Profile {
	
	public Profile() {
		
	}
	
	@Id
	private String id;
	private String FirstName;
	private String LastName;
	private int age;
	private String Gender;
	private long ContactNo;
	private String Email;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)	
	private Date DateofBirth = new Date();

	
	
	public Profile(String id, String firstName, String lastName, int age, String gender, long contactNo,String email,Date dob) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		this.age = age;
		Gender = gender;
		ContactNo = contactNo;
		Email = email;
		DateofBirth = dob;
	}


	//Getter and Setters for Variables like FirstName, LastName, Age, Gender, Email,ContactNo.
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail() {
		return Email;
}
public void setEmail(String email) {
		Email = email;
	}
	public Date getDateofBirth() {
	return DateofBirth;
}

public void setDateofBirth(Date dateofBirth) {
	DateofBirth = dateofBirth;
}

	public long getContactNo() {
		return ContactNo;
	}
	public void setContactNo(long contactNo) {
		ContactNo = contactNo;
	}




	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Users [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Age=" + age + ",Gender=" + Gender + ",ContactNo="+ContactNo+",Email="+ Email+",DateofBirth="+DateofBirth+"]";
	}

	public String getID() {
		// TODO Auto-generated method stub
		return id;
	}
	

	
}
