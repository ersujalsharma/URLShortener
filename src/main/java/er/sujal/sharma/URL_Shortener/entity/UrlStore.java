package er.sujal.sharma.URL_Shortener.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "urlstore")
@Data
public class UrlStore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long shortid;
	String longurl;
	
	public long getShortId() {
		return shortid;
	}
	public void setShortId(long shortId) {
		this.shortid = shortId;
	}
	public String getLongurl() {
		return longurl;
	}
	public void setLongurl(String longurl) {
		this.longurl = longurl;
	}
	public UrlStore(String longurl) {
		super();
		this.longurl = longurl;
	}
	public UrlStore() {
	}
	
}
