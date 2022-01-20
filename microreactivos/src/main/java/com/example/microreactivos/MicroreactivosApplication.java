package com.example.microreactivos;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroreactivosApplication {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
		;

		int count = 0;

		for (int numero : numbers) {
			if (numero > 10) {
				count++;
			}
		}
		System.out.println(count);

		/************************************/

		List<Product> shoppingCart = List.of(new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
				new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
				new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
				new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
				new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
				new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL));

	BigDecimal result=shoppingCart.stream().map(product-> product.price.add(product.price.multiply(new BigDecimal(product.tax.percent).divide(new BigDecimal(100)))))
		.reduce(BigDecimal.ZERO, (x,y)-> x.add(y));
		
		System.out.println("Valor " + result.toString());
		
		
		String result2 = shoppingCart.stream().filter(product->product.name.startsWith("C")).map(product -> product.name).collect(Collectors.joining(", ", " Resultado " , "."));
		System.out.println("Valor2 " + result2.toString());
		SpringApplication.run(MicroreactivosApplication.class, args);
	}

}
