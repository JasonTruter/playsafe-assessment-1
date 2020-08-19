package com.playsafe.assessment1.service;

import org.springframework.stereotype.Service;

@Service
public class ConversionsService {
	
	public float kelvinToCelsius(float kelvin) {
		float celsius = kelvin - 273.15F;
		return celsius;
	}

	public float celsiusToKelvin(float celsius) {
		float kelvin = celsius + 273.15F;
		return kelvin;
	}

	public float milesToKilometers(float miles) {
		float kilometers = miles * 1.6F;
		return kilometers;
	}

	public float kilometersToMiles(float kilometers) {
		float miles = kilometers / 1.6F;
		return miles;
	}
}
