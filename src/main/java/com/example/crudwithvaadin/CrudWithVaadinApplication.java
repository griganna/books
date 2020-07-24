package com.example.crudwithvaadin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudWithVaadinApplication {

	private static final Logger log = LoggerFactory.getLogger(CrudWithVaadinApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrudWithVaadinApplication.class);
	}

	@Bean
	public CommandLineRunner loadData(BookRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Book("Book 1", "Author 1", 100));
			repository.save(new Book("Book 2", "Author 2", 200));
			repository.save(new Book("Book 3", "Author 3", 300));
			repository.save(new Book("Book 4", "Author 4", 400));
			repository.save(new Book("Book 5", "Author 5", 500));

			// fetch all customers
			log.info("Books found with findAll():");
			log.info("-------------------------------");
			for (Book customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual book by ID
			Book book = repository.findById(1L).get();
			log.info("Book found with findOne(1L):");
			log.info("--------------------------------");
			log.info(book.toString());
			log.info("");

			// fetch books by name
			log.info("Book found with findByNameStartsWithIgnoreCase('Book 1'):");
			log.info("--------------------------------------------");
			for (Book bauer : repository
					.findByNameStartsWithIgnoreCase("Book 1")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}

}
