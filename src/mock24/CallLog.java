package mock24;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class CallLog {
	List<Call> callList;

	public List<Call> getCallList() {
		return callList;
	}

	public void setCallList(List<Call> callList) {
		this.callList = callList;
	}

	public CallLog(List<Call> callList) {
		super();
		this.callList = callList;
		
	}
	public Contact getFavouriteContact() throws ParseException {
		Map<String,Integer> cmp=new TreeMap<String,Integer>();
	
		for(Call c:callList) {
			
			//System.out.println("0000"+c.getContactName());
			Integer count=0;
			//System.out.println("ghhhh");
			count=cmp.get(c.getContactName());
			//System.out.println("ghhhh");
			if(count==null)
				count=0;
			count++;
			cmp.put(c.getContactName(),count);
			//System.out.println("ghhhh");
			}
	
		Contact result=new Contact();
		String name="";
		int l=0;
		for(Entry<String,Integer> e:cmp.entrySet()) {
			//System.out.println(e.getValue());
			if(l<e.getValue()) {
				l=e.getValue();
				name=e.getKey();
			}
							
				}
		for(Call c:callList) {
			if(name.equals(c.getContactName()))
				{result=c.getContact();
				break;}
		}
		return result;
	}
	}
