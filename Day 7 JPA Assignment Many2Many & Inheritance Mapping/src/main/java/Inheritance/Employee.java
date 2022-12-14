package Inheritance;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Employee extends Person {
	
	@Embedded
	@AttributeOverrides({
		
		@AttributeOverride(name="state",column=@Column(name="OFFICE_STATE")),
		@AttributeOverride(name="city",column=@Column(name="OFFICE_CITY")),
		@AttributeOverride(name="pincode",column=@Column(name="OFFICE_PINCODE"))
		
	})
	private Address officeAddress; 
	
	
	@Embedded
	@AttributeOverrides({
	        @AttributeOverride(name="state",column=@Column(name="HOME_STATE")),
	        @AttributeOverride(name="city",column=@Column(name="HOME_CITY")),
	        @AttributeOverride(name="pincode",column=@Column(name="HOME_PINCODE"))
	})
	private Address homeAddress; 
	
	private int salary;
	
	
	public Employee(Address homeAddress, Address officeAddress, int salary) {
		this.homeAddress = homeAddress;
		this.officeAddress = officeAddress;
		this.salary = salary;
	}
	
	public Employee() {
		
	}
	
	@Override
	public String toString() {
		return "Employee [homeAddress=" + homeAddress + ", officeAddress=" + officeAddress + ", salary=" + salary + "]";
	}
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	

}
