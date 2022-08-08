package mock24;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Req2_Main {
	public static void main(String args[]) throws ParseException {
		Scanner sc=new Scanner(System.in);
		List<Call> call_list=new ArrayList<Call>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat du=new SimpleDateFormat("HH:mm:ss");
		System.out.println("Enter the number of calls:");
		Integer n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++) {
			String[] inp=sc.nextLine().split(",");
			call_list.add(new Call(inp[0],inp[1],inp[2],du.parse(inp[3]),sdf.parse(inp[4])));
			
		}
		System.out.printf("%-8s %-8s %-10s %-12s %-10s %s\n","Contact","Type","Call Type","Date","Duration","Cost");
		for(Call cc:call_list) {
			System.out.printf("%-8s %-8s %-10s %-12s %-10s %.02f\n",cc.getContactName(),
					cc.getType(),cc.getCallType(),sdf.format(cc.getDate()),du.format(cc.getDuration()),cc.getCost());
		}
	}
}
