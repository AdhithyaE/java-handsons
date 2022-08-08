package mock24;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Call {
	String contactName;
	String type;
	String callType;
	Date duration;
	Date date;
	Contact contact;
	Double cost=0d;
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	SimpleDateFormat du=new SimpleDateFormat("HH:mm:ss");
	public Call() {
		super();
	}
	
	public Call(String contactName,String type, String callType, Date duration, Date date, Contact contact,
			Double cost) {
		super();
		this.contactName=contactName;
		this.type = type;
		this.callType = callType;
		this.duration = duration;
		this.date = date;
		this.contact = contact;
		this.cost = cost;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Call(String contactName, String type, String callType, Date duration, Date date, Double cost) {
		super();
		this.contactName = contactName;
		this.type = type;
		this.callType = callType;
		this.duration = duration;
		this.date = date;
		this.cost = cost;
	}

	public Call(String contactName, String type, String callType, Date duration, Date date) {
		super();
		this.contactName = contactName;
		this.type = type;
		this.callType = callType;
		this.duration = duration;
		this.date = date;
		this.computeCost();
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration;
	}
	
	public Double getCost() {
		return cost;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void computeCost() {
		SimpleDateFormat h=new SimpleDateFormat("HH");
		SimpleDateFormat m=new SimpleDateFormat("mm");
		SimpleDateFormat s=new SimpleDateFormat("ss");
		Integer hour=Integer.parseInt(h.format(this.getDuration()));
		Integer min=Integer.parseInt(m.format(this.getDuration()));
		Integer sec=Integer.parseInt(s.format(this.getDuration()));
		Integer total_duration=hour*3600+min*60+sec;
		
		if(this.getType().equalsIgnoreCase("Incoming")){
			switch(this.getCallType()) {
			case "Local": this.cost+=0.0*total_duration;break;
			case "STD":this.cost+=0.0*total_duration;break;
			case "ISD":this.cost+=7.5*total_duration;break;
			case "Roaming":this.cost+=.6*total_duration;break;
			}
		}
		if(this.getType().equalsIgnoreCase("Outgoing")){
			switch(this.getCallType()) {
			case "Local": this.cost+=0.9*total_duration;break;
			case "STD":this.cost+=1.2*total_duration;break;
			case "ISD":this.cost+=15.0*total_duration;break;
			case "Roaming":this.cost+=1.2*total_duration;break;
			}
		}
		this.cost=this.cost/100;
	}
	public static Map<String,Integer> monthWiseCount(List<Call> callList) throws ParseException{
		Map<String,Integer> tmp=new TreeMap<String,Integer>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for(Call c:callList) {
			LocalDate ld=LocalDate.parse(sdf.format(c.getDate()));
			String mon=ld.getMonth().toString();
			//System.out.println(mon);
			Integer count=0;
			count=tmp.get(mon);
			if(count==null)
				count=0;
			count++;
			tmp.put(mon,count);
		}
		return tmp;
	}
}
