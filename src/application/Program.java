package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		try {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Entre com o numero do quarto: ");
		int quarto = sc.nextInt();
		sc.nextLine();
		System.out.print("Entre com a data de checkin: (dd/mm/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Entre com a data de checkout: (dd/mm/yyyy)");
		Date checkOut = sdf.parse(sc.next());

		Reservation reservation = new Reservation(quarto, checkIn, checkOut);
		System.out.println("Reserva: " + reservation);
		System.out.println();
		System.out.println("Entre com os dados para atualização reserva:");
		System.out.print("Entre com a data de checkin: (dd/mm/yyyy)");
		checkIn = sdf.parse(sc.next());
		System.out.print("Entre com a data de checkout: (dd/mm/yyyy)");
		checkOut = sdf.parse(sc.next());

		reservation.updateDates(checkIn, checkOut);
		System.out.println("Reserva Atualizada: " + reservation);
		
		}catch (ParseException e){
			System.out.println("Erro: Formato de Data Invalido!");
		}catch (DomainException e) {
			System.out.println(e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Erro Inesperado!");
		}
		sc.close();
	}

}
