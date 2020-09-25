package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exception.DomainException;

public class Reservation {

	private Integer roomNunber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNunber, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Data de saida tem que ser posterior a data de entrada!");
		}
		this.roomNunber = roomNunber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNunber() {
		return roomNunber;
	}

	public void setRoomNunber(Integer roomNunber) {
		this.roomNunber = roomNunber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}


	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("ERRO na atualiza��o: As datas tem de ser datas futuras!");
		}else if (!checkOut.after(checkIn)) {
			throw new DomainException("Data de saida tem que ser posterior a data de entrada!");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		}
	
	@Override
	public String toString() {
		return "Quarto: "
				+roomNunber
				+", Chechin: "
				+sdf.format(checkIn)
				+", Checkout: "
				+sdf.format(checkOut)
				+", Dura��o: "
				+duration()
				+" Noites.";
	}
}
