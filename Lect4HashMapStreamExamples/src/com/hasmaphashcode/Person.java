package com.hasmaphashcode;

import java.util.Objects;

public class Person {
	public int id;
	
	
//	id or catergory id - 
//	products1 , product2,  prodcut3 
//	
	
	public int age;
	public String name;
	public String address;
	
	
	public Person() {
		
	}
	
	

	public Person(int id, int age, String name, String address) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", name=" + name + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return id == other.id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
