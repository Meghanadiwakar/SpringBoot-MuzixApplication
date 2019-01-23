package com.stackroute;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.hibernate.SpringJtaPlatform;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
@SpringBootApplication
public class MuzixApplication implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

	@Autowired
	TrackRepository trackRepository;
	public static void main(String args[]){
		SpringApplication.run(MuzixApplication.class,args);
	}

	@Override
	public void run(String... args) throws Exception {
		trackRepository.save(new Track(2,"hello","lionel"));

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		trackRepository.save(new Track(1,"buffalo","bob marley"));


	}


//	public static void main(String[] args) {
//		SpringApplication.run(MuzixApplication.class, args);
//	}


}

