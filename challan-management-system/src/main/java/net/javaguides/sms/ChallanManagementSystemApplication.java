package net.javaguides.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.repository.ChallanRepository;

@SpringBootApplication
public class ChallanManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ChallanManagementSystemApplication.class, args);
	}

	@Autowired
	private ChallanRepository challanRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * Challan challan1 = new Challan("Ramesh", "Fadatare", "ramesh@gmail.com");
		 * challanRepository.save(challan1);
		 * 
		 * Challan challan2 = new Challan("Sanjay", "Jadhav", "sanjay@gmail.com");
		 * challanRepository.save(challan2);
		 * 
		 * Challan challan3 = new Challan("tony", "stark", "tony@gmail.com");
		 * challanRepository.save(challan3);
		 */
		
	}

}