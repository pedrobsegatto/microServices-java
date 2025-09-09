package br.edu.atitus.greeting_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.atitus.greeting_service.configs.GreetingConfig;

@RestController
@RequestMapping("greeting")
public class GreetingController {
	
	private final GreetingConfig config;
	
	public GreetingController(GreetingConfig config) {
		this.config = config;
	}

	// GET com RequestParam (já existente)
	@GetMapping
	public ResponseEntity<String> greet(
			@RequestParam(required = false) String name){
		String greetingReturn = config.getGreeting();
		String nameReturn = name != null ? name : config.getDefaultName();
		String textReturn = String.format("%s, %s!!!", greetingReturn, nameReturn);
		
		return ResponseEntity.ok(textReturn);
	}

	// GET com PathVariable
	@GetMapping("/{name}")
	public ResponseEntity<String> greetWithPath(@PathVariable String name) {
		String textReturn = String.format("%s, %s!!!", config.getGreeting(), name);
		return ResponseEntity.ok(textReturn);
	}

	// POST recebendo JSON
	@PostMapping
	public ResponseEntity<String> greetPost(@RequestBody Person person) {
		String name = person.getName() != null ? person.getName() : config.getDefaultName();
		String textReturn = String.format("%s, %s!!!", config.getGreeting(), name);
		return ResponseEntity.ok(textReturn);
	}

	// Classe auxiliar para JSON
	public static class Person {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
