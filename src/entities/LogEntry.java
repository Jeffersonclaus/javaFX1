package entities;

import java.util.Date;
import java.util.Objects;

public class LogEntry {
	
	private String product;
	private Date date;
	
	
	public LogEntry(String product, Date date) {
	
		this.product = product;
		this.date = date;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogEntry other = (LogEntry) obj;
		return Objects.equals(product, other.product);
	}
	
	
	

}
