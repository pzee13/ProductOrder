package main;

import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class sample {
	static Scanner scanner = new Scanner(System.in);
	
	static ServiceImpl service = new ServiceImpl();
	
	public static void main(String[] args) {
		List<String> prods =Arrays.asList("A","B","C");
		int total_unit;
		int package_fee;
		int wrap_fee=0;
		double total_price_after_discount;
		
		System.out.println("Quantity of Product A :");
		int quant_A = scanner.nextInt();
		wrap_fee =wrap_fee + service.checkWrap();
		
		
		System.out.println("Quantity of Product B :");
		int quant_B = scanner.nextInt();
		wrap_fee =wrap_fee + service.checkWrap();
		

		System.out.println("Quantity of Product C :");
		int quant_C = scanner.nextInt();
		wrap_fee =wrap_fee + service.checkWrap();
		
		
		total_unit = quant_A + quant_B +quant_C;
		package_fee=service.packageFee(total_unit)*5;
		Map<Integer,Integer> map =Map.of(20,quant_A,40,quant_B,50,quant_C);
		service.findDiscount(map);
		total_price_after_discount = ServiceImpl.total_price + package_fee + wrap_fee - ServiceImpl.maxKey ;
		
		System.out.println("\n\nSl.No \t ProductName   Price   Quantity   SubTotal\n");
		int j=0;
		for (Map.Entry<Integer, Integer> iter : map.entrySet()) {
		    int key = iter.getKey();
		    Integer value = iter.getValue();
		    String name=prods.get(j);
		
		    System.out.println(j+1+" \t   "+name+"    \t "+key+" \t "+value+" \t "+value*key);
		    j++;
		}
		System.out.println("\n\nDiscount rule : "+ServiceImpl.discount_rule);
		System.out.println("Discount Amount: "+ServiceImpl.maxKey);
		System.out.println("Wrap fee :"+wrap_fee);
		System.out.println("Packaging fee :"+package_fee);
		System.out.println("Total Cart Value :"+ServiceImpl.total_price);
		System.out.println("\n****************************************************************\n");
		System.out.println("Discounted Price : "+total_price_after_discount);
		
		
	}

}
