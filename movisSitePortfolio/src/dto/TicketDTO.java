package dto;

public class TicketDTO {
	private String ticketCd;
	private String screenCd;
	private String seatCd;
	
	public TicketDTO(String ticketCd, String screenCd, String seatCd) {
		super();
		this.ticketCd = ticketCd;
		this.screenCd = screenCd;
		this.seatCd = seatCd;
	}

	public String getTicketCd() {
		return ticketCd;
	}

	public void setTicketCd(String ticketCd) {
		this.ticketCd = ticketCd;
	}

	public String getScreenCd() {
		return screenCd;
	}

	public void setScreenCd(String screenCd) {
		this.screenCd = screenCd;
	}

	public String getSeatCd() {
		return seatCd;
	}

	public void setSeatCd(String seatCd) {
		this.seatCd = seatCd;
	}
	
	
}
