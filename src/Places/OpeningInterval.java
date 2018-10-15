package Places;

public class OpeningInterval {
	private boolean isOpen;
	private MyTime from;
	private MyTime to;
	
	public boolean getOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public MyTime getFrom() {
		return from;
	}
	public void setFrom(MyTime from) {
		this.from = from;
	}
	public MyTime getTo() {
		return to;
	}
	public void setTo(MyTime to) {
		this.to = to;
	}
}
