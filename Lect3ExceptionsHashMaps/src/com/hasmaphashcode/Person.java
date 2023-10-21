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
		return Objects.equals(address, other.address) && age == other.age && id == other.id
				&& Objects.equals(name, other.name);
	}

}
