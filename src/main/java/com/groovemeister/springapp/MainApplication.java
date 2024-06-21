package com.groovemeister.springapp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import com.groovemeister.springapp.model.PracticeItem;
import com.groovemeister.springapp.repository.PracticeItemRepository;

@SpringBootApplication
public class MainApplication {

	private static final Logger log = LoggerFactory.getLogger(MainApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Autowired
	PracticeItemRepository practiceItemRepository;

	@Bean
	@ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
	public CommandLineRunner demoCommandLineRunner() {
		return args -> {
			System.out.println("Running.....");

			PracticeItem p1 = new PracticeItem("MWFSSu",
				"Test from Spring", 
				"Spring Source", 
				"TopicSpring",
				"TypeSpring", 15);

			PracticeItem p2 = new PracticeItem("Mon",
				"SecondSpringTest", 
				"Spring Deux", 
				"TopicSpring",
				"TypeSpring", 15);


			PracticeItem p3 = new PracticeItem("Daily",
				"Thirdspring", 
				"Tres spring", 
				"TopicSpring",
				"TypeSpring", 50);

			practiceItemRepository.saveAll(List.of(p1, p2, p3));
		};
	}
}
