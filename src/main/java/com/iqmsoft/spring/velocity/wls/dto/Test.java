package com.iqmsoft.spring.velocity.wls.dto;

import org.hibernate.validator.constraints.NotBlank;

public class Test{
	
	@NotBlank(message = "No en blanco")
	private String name;
	
	@NotBlank(message = "edad")
	private String age;
	
	
	public Test() {

	}

	public Test(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Test [name=" + name + "]";
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	
	
	
	
}
