package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.demo.Models.Address;
import com.example.demo.Models.Gender;
import com.example.demo.Models.Student;
import com.example.demo.Repos.StudentRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate){
		return args -> {
			Address address= new Address("Kenya", "Nairobi", "00100");
			// String email = "jeremy@gmail.com";
			Student student =new Student(
				"Jeremy",
				"Munroe",
				"jeremyaa@gmail.com",
				Gender.MALE,
				address,
				List.of("CS","Math"),
				BigDecimal.TEN,
				LocalDateTime.now()

			);
			// usingMongoTemplateandQuery(repository, mongoTemplate, student);
			repository.findStudentByEmail(student.getEmail()).ifPresentOrElse(s -> {
				System.out.println(student+ " already exists.");
			}, ()->{
				System.out.println("Inserting student "+ student);
				repository.insert(student);
			});
			
		};
		
	}
	private void usingMongoTemplateandQuery( StudentRepository repository, MongoTemplate mongoTemplate, Student student){
		Query query = new Query();
			query.addCriteria(Criteria.where("email").is(student.getEmail()));
			List<Student> students = mongoTemplate.find(query, Student.class);
			if(students.size()>1){
				throw new IllegalStateException("Found many students with "+ student.getEmail());
			}
			if(students.isEmpty()){
				System.out.println("Inserting student "+ student);
				repository.insert(student);
			} else {
				System.out.println(student+ " already exists.");
			}
			// repository.insert(student);
	}

}
