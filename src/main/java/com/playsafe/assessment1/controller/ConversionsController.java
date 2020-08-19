package com.playsafe.assessment1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playsafe.assessment1.service.ConversionsService;

@RestController
@RequestMapping("/conversions")
public class ConversionsController {

	private static final Logger logger = LoggerFactory.getLogger(ConversionsController.class);

	private final ConversionsService conversionService;

	public ConversionsController(ConversionsService conversionService) {
		this.conversionService = conversionService;
	}

	@GetMapping("/ktoc/{kelvinStr}")
	public ResponseEntity<String> getKelvinToCelsius(@PathVariable String kelvinStr) {
		try {
			float kelvin = Float.parseFloat(kelvinStr);
			float celsius = conversionService.kelvinToCelsius(kelvin);
			logger.info("Input Kelvin: {} Converted to Celsius: {} ", kelvin, celsius);
			return new ResponseEntity<>(String.valueOf(celsius), HttpStatus.OK);
		} catch (NumberFormatException ex) {
			return new ResponseEntity<>("Please provide a number value", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/ctok/{celsiusStr}")
	public ResponseEntity<String> getCelsiusToKelvin(@PathVariable String celsiusStr) {
		try {
			float celsius = Float.parseFloat(celsiusStr);
			float kelvin = conversionService.celsiusToKelvin(celsius);
			logger.info("Input Celsius: {} Converted to Kelvin: {} ", celsius, kelvin);
			return new ResponseEntity<>(String.valueOf(kelvin), HttpStatus.OK);
		} catch (NumberFormatException ex) {
			return new ResponseEntity<>("Please provide a number value", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/mtok/{milesStr}")
	public ResponseEntity<String> getMilesToKilometers(@PathVariable String milesStr) {
		try {
			float miles = Float.parseFloat(milesStr);
			float kilometers = conversionService.milesToKilometers(miles);
			logger.info("Input Miles: {} Converted to Kilometers: {} ", miles, kilometers);
			return new ResponseEntity<>(String.valueOf(kilometers), HttpStatus.OK);
		} catch (NumberFormatException ex) {
			return new ResponseEntity<>("Please provide a number value", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/ktom/{kilometersStr}")
	public ResponseEntity<String> getKilometersToMiles(@PathVariable String kilometersStr) {
		try {
			float kilometers = Float.parseFloat(kilometersStr);
			float miles = conversionService.kilometersToMiles(kilometers);
			logger.info("Input Kilometers: {} Converted to Miles: {} ", kilometers, miles);
			return new ResponseEntity<>(String.valueOf(miles), HttpStatus.OK);
		} catch (NumberFormatException ex) {
			return new ResponseEntity<>("Please provide a number value", HttpStatus.BAD_REQUEST);
		}
	}
}
