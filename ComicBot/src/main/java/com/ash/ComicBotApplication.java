package com.ash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
public class ComicBotApplication {

	public static void main(String args[]) {
		SpringApplication.run(ComicBotApplication.class, args);
	}
}
