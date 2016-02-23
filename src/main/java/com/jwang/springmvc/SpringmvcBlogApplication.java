package com.jwang.springmvc;

import com.jwang.springmvc.DAO.AccessModel.User;
import com.jwang.springmvc.DAO.AccessModel.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcBlogApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcBlogApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new User("first1","last1",10,"test1@test.com"));
		repository.save(new User("first2","last2",12,"test2@email.com"));

		// fetch all customers
		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");
		for (User user : repository.findAll()) {
			System.out.println(user);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("first1"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (User user : repository.findByLastName("last2")) {
			System.out.println(user);
		}
	}
}
