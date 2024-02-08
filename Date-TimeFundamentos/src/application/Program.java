package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {

	public static void main(String[] args) {

		// https://docs.oracle.com/javase/jp/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
		
		LocalDate d01 = LocalDate.now(); // LocalDate é um metodo estatico, now para mostrar a data de agora no sistema.
		LocalDateTime d02 = LocalDateTime.now(); // para mostrar a hora de agora no sistema.
		Instant d03 = Instant.now(); // para gerar o instante em horario global (Z). GERA A HORA DE LONDRES.
		
		LocalDate d04 = LocalDate.parse("2024-02-20"); // para pré definir uma data.
		LocalDateTime d05 = LocalDateTime.parse("2024-02-20T01:30:26"); // para pré definir uma data e hora.
		Instant d06 = Instant.parse("2024-02-20T01:30:26Z"); // para pré definir uma data e hora global.
		Instant d07 = Instant.parse("2024-02-20T01:30:26-03:00"); // para pré definir uma data e hora mostrando um time zone diferente.
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // para customizar uma data.
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDate d08 = LocalDate.parse("20/07/2024", fmt1); // para customizar uma data.
		LocalDateTime d09 = LocalDateTime.parse("20/07/2024 01:30", fmt2);
		
		LocalDate d10 = LocalDate.of(2024, 7, 20);
		LocalDateTime d11 = LocalDateTime.of(2022, 7, 20, 1, 30);
		
		System.out.println("--------------------");
		System.out.println("d01: " + d01);
		System.out.println("d02: " + d02);
		System.out.println("d03: " + d03);
		System.out.println("--------------------");
		System.out.println("d04: " + d04);
		System.out.println("d05: " + d05);
		System.out.println("d06: " + d06);
		System.out.println("d07: " + d07);
		System.out.println("--------------------");
		System.out.println("d08: " + d08);
		System.out.println("d09: " + d09);
		System.out.println("--------------------");
		System.out.println("d10: " + d10);
		System.out.println("d11: " + d11);
	}

}
