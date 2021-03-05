package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class FilterService {
	
	String[] filtro = {"subnormal", "hijoputa", "hijaputa", "tonto", "tonta", 
			"idiota", "puto", "puta", "capullo", "capulla"};
	
	public String filtrarLenguaje(String input) {
		
		System.out.println("Cadena inicial: "+ input);
		for(String s: filtro) {
			
			input = input.replaceAll(s, "***");
			
		}
		
		System.out.println("Cadena modificada: "+input);
		return input;
	}
}
