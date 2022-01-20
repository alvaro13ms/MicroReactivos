package com.example.observador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.reactivex.Observable;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ObservadorApplication {

	public static void main(String[] args) {

		Flux<String> messageSender = Flux.just("Mensaje 1", "Mensaje 2", "Mensaje 3");

		messageSender.subscribe(message -> System.out.println("Observer 1. Received " + message));
		messageSender.subscribe(message -> System.out.println("Observer 2. Received " + message));

		messageSender.doOnNext((element) -> {
			System.out.println(element);
		}).blockFirst();

		/*
		 * messageSender.subscribe(new Flux<String>() {
		 * 
		 * public void onSuscribe(Disposable d) {
		 * System.out.println("Flux 1. Suscribed"); }
		 * 
		 * public void onNext(String s) { System.out.println("Flux 1. Received: " + s);
		 * }
		 * 
		 * public void onError(Throwable e) { System.out.println("Flux 1. Error: " +
		 * e.getMessage()); }
		 * 
		 * public void onComplete() { System.out.println("Flux 1. Completed"); } }
		 * 
		 * );
		 */

		SpringApplication.run(ObservadorApplication.class, args);
	}

}
