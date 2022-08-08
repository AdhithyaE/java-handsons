package mock24;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Req5_Main {
	public static void main(String args[]) throws ParseException {
		Scanner sc=new Scanner(System.in);
		List<Call> call_list=new ArrayList<Call>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat du=new SimpleDateFormat("HH:mm:ss");
		System.out.println("Enter the number of calls:");
		Integer n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++) {
			String[] inp=sc.nextLine().split(",");
			call_list.add(new Call(inp[0],inp[1],inp[2],du.parse(inp[4]),sdf.parse(inp[5]),Double.parseDouble(inp[3])));
			
		}
		Map<String,Integer> result=new TreeMap<String,Integer>();
		result=new Call().monthWiseCount(call_list);
		if(!result.isEmpty()) {
			System.out.printf("%-10s %s\n","Month", "Count");
			for(Entry<String,Integer> e:result.entrySet()) {
				System.out.printf("%-10s %s %s\n",e.getKey().substring(0,3)," ",e.getValue().toString());
			}
		}

}}
