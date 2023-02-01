package com.obsqura.utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	public static String firstNameMethod() {
		Faker faker=new Faker();
		String firstName=faker.name().firstName();
		return firstName;
		}
	public static String lastNameMethod() {
		Faker faker=new Faker();
		String lastName=faker.name().lastName();
		return lastName;
		}
	public static String cityMethod() {
		Faker faker=new Faker();
		String cityName=faker.address().cityName();
		return cityName;
		}
	
	public static String generateSingleData() {
		Faker faker = new Faker();
		String randomData=faker.name().title();
		return randomData;
	}
	public static String phoneNumber() {
		Faker faker=new Faker();
		String phoneNumber = faker.phoneNumber().phoneNumber();
		return phoneNumber;
	}
	public static String email() {
		Faker faker = new Faker();
		return faker.internet().emailAddress();
	}
	
	

}
