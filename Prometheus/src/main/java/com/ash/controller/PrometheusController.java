package com.ash.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

@RestController
public class PrometheusController {

	@GetMapping("/getStatus")
	@Timed(value = "getStatusAPI.response.time", description = "Time taken to process getStatus API request")
	public String getStatus() throws InterruptedException {
		Thread th = new Thread();
		Random random = new Random();
		
		int min = 5000;
        int max = 10000;
		
		int randomNumber = random.nextInt(max - min + 1) + min;
		Thread.sleep(randomNumber);
		return "Success";
	}
}
