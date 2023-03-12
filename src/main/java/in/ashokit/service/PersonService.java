package in.ashokit.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import in.ashokit.entity.Passport;
import in.ashokit.entity.Person;
import in.ashokit.repo.PassportRepo;
import in.ashokit.repo.PersonRepo;

public class PersonService {

	@Autowired
	private PersonRepo personRepo;

	@Autowired
	private PassportRepo passportRepo;

	public void savePersonWithPassport() {

		Passport passport = new Passport();
		passport.setPassportNum("K8HKHK6");
		passport.setIssuedDate(LocalDate.now());
		passport.setExpDate(LocalDate.now().plusYears(10));

		Person person = new Person();
		person.setPersonName("John");
		person.setDob(LocalDate.now().minusYears(20));

		passport.setPerson(person);
		person.setPassport(passport);

		personRepo.save(person);
	}

	public void deletePerson(int id) {
		personRepo.deleteById(id);
	}

	public void getPerson(int id) {
		personRepo.findById(id);
	}

	public void getPassport(int id) {
		passportRepo.findById(id);
	}

	public void deletePassport(int id) {
		passportRepo.deleteById(id);
	}
}
