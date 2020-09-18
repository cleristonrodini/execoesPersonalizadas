package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Entre com o numero do quarto: ");
		int quarto = sc.nextInt();
		sc.nextLine();
		System.out.print("Entre com a data de checkin: (dd/mm/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Entre com a data de checkout: (dd/mm/yyyy)");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Data de saida tem que ser posterior que a de entrada!");
		}else {
			Reservation reservation = new Reservation(quarto, checkIn, checkOut);
			System.out.println("Reserva: "+reservation);
			System.out.println();
			System.out.println("Entre com os dados prara atualiza��o reserva:");
			System.out.print("Entre com a data de checkin: (dd/mm/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.print("Entre com a data de checkout: (dd/mm/yyyy)");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("ERRO na atualiza��o: As datas tem que ser datas futuras!");
			}else if (!checkOut.after(checkIn)) {
				System.out.println("Data de saida tem que ser posterior que a de entrada!");
			}else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reserva Atualizada: "+reservation);
			}
		}
		
		sc.close();

	}

}