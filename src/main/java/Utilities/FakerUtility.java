package Utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;

public class FakerUtility {

	public static String firstNameFakerSample() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}

	public static String lastNameFakerSample() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}

	public static String cityNameFakerSample() {
		Faker faker = new Faker();
		return faker.address().cityName();
	}

	public static String stateFakerSample() {
		Faker faker = new Faker();
		return faker.address().state();
	}

	public static String countryFakerSample() {
		Faker faker = new Faker();
		return faker.address().country();
	}

	public static String cellPhoneFakerSample() {
		Faker faker = new Faker();
		return faker.phoneNumber().cellPhone();
	}

	public static String animalFakerSample() {
		Faker faker = new Faker();
		return faker.animal().name();
	}

	public static String emailFakerSample() {
		Faker faker = new Faker();
		return faker.bothify("?????##@gmail.com");
	}
}
