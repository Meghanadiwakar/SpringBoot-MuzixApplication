package com.stackroute;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/*
In this class Application Listener,Command Line Runner,@Value ,@PropertySource is used.
 */


@SpringBootApplication
@PropertySource("classpath:application.properties")
public class MuzixApplication implements /*ApplicationListener<ContextRefreshedEvent>,*/ CommandLineRunner {
	@Value("6")
	private int trackId;

	@Value("${trackName}")
	private String trackName;

	@Value("bob marley")
	private String comment;

	@Autowired
	TrackRepository trackRepository;

	@Autowired
	Environment env;
	public static void main(String args[]){
		SpringApplication.run(MuzixApplication.class,args);
	}
//
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//		trackRepository.save(new Track(Integer.parseInt(env.getProperty("trackId")),env.getProperty("trackName"),env.getProperty("Comment")));
//	}

	@Override
	public void run(String... args) throws Exception {
		trackRepository.save(new Track(trackId,trackName,comment));
	}
}

