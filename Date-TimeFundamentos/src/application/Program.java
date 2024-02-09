package application;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault()); // Para customizar fusoH, no caso usando o proprio fusoH do PC.
		DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME; // customização usando um padrão ISO direto.
		DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT; // para horas
		
		LocalDate d08 = LocalDate.parse("20/07/2024", fmt1); // para customizar uma data.
		LocalDateTime d09 = LocalDateTime.parse("20/07/2024 01:30", fmt2);
		LocalDate d10 = LocalDate.of(2024, 7, 20);
		LocalDateTime d11 = LocalDateTime.of(2022, 7, 20, 1, 30);
		
		LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault()); // data de Londres em relaçao a d6
		LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal")); // data de Portugual em relaçao a d6
		LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault()); // data + H de Londres em relaçao a d6
		LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal")); // data + H de Portugual em relaçao a d6
		
		LocalDate pastWeekLocalDate = d04.minusDays(7); // d04 - 7 dias;
		LocalDate nextWeekLocalDate = d04.plusDays(7); // d04 + 7 dias;
		Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS); // d04 - 7 dias com segundos;
		Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS); // d04 + 7 dias com segundos;
		
		Duration t1 = Duration.between(pastWeekLocalDate, d05); // duração entre datas.
		
		//for(String s : ZoneId.getAvailableZoneIds()) { // lista fusoHr.
		//	System.out.println(s);
		//}
		//System.out.println("\nFusoHs:\n");
		
		System.out.println("----------------------------");
		System.out.println("d01: " + d01);
		System.out.println("d02: " + d02);
		System.out.println("d03: " + d03);
		System.out.println("----------------------------");
		System.out.println("d04: " + d04);
		System.out.println("d05: " + d05);
		System.out.println("d06: " + d06);
		System.out.println("d07: " + d07);
		System.out.println("----------------------------");
		System.out.println("d08: " + d08);
		System.out.println("d09: " + d09);
		System.out.println("----------------------------");
		System.out.println("d10: " + d10);
		System.out.println("d11: " + d11);
		System.out.println("----------------------------");
		System.out.println("d04: " + d04.format(fmt1)); // respeitando o formato fmt1.
		System.out.println("d04: " + fmt1.format(d04)); // respeitando o formato fmt1.
		System.out.println("d04: " + d04.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); // respeitando o formato.
		System.out.println("----------------------------");
		System.out.println("d05: " + d05.format(fmt1)); // respeitando o formato fmt1.
		System.out.println("d05: " + d05.format(fmt2)); // respeitando o formato fmt2.
		System.out.println("----------------------------");
		System.out.println("d06: " + fmt3.format(d06)); // para imprimir uma data customizada em horaio Z,é necessario dizer qual fusoH irá considerar.
		System.out.println("d06: " + fmt5.format(d06)); // o mesmo de cima, mas com minutos.
		System.out.println("d06: " + d06.toString()); // o mesmo de cima.
		System.out.println("----------------------------");
		System.out.println("Conversão Data-Hora local para global:");
		System.out.println("r1: " + r1);
		System.out.println("r2: " + r2);
		System.out.println("r3: " + r3);
		System.out.println("r4: " + r4);
		System.out.println("----------------------------");
		System.out.println("d04 Dia: " + d04.getDayOfMonth()); // para pegar apenas o dia.
		System.out.println("d04 Mês: " + d04.getMonthValue()); // para pegar apenas o mês.
		System.out.println("d04 Ano: " + d04.getYear()); // para pegar apenas o ano.
		System.out.println("d05 Hora: " + d05.getHour()); // para pegar apenas a hora.
		System.out.println("d05 Minuto: " + d05.getMinute()); // para pegar apenas o minuto.
		System.out.println("----------------------------");
		System.out.println("Calculos com Data-Hora:");
		System.out.println("Before: " + d04 +" / pastWeekLocalDate: " + pastWeekLocalDate);
		System.out.println("Before: " + d04 +" / pextWeekLocalDate: " + nextWeekLocalDate);
		System.out.println("Before: " + d06 +" / pastWeekInstant: " + pastWeekInstant);
		System.out.println("Before: " + d06 +" / nextWeekInstant: " + nextWeekInstant);
		System.out.println("t1 dias: " + t1.toDays()); // duração.
		System.out.println("----------------------------");
		
		
		
	}

}
