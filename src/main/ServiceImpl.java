package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ServiceImpl implements Service {
	
	static Scanner scanner = new Scanner(System.in);
	static double maxKey;
	static double total_price=0.0;
	static String discount_rule;


	public int checkWrap() {
		String wrap;
		int wrap_fee = 0;
		System.out.println("Do you need Gift Wrap: y/n");
		wrap = scanner.next();
		if(wrap.equals("y")) {
			wrap_fee=1;
		}
		return wrap_fee;
	}


	public  void findDiscount(Map<Integer,Integer> map) {
		int totalQuantity = 0;
        int maxSingleProductQuantity = 0;
        double totalCartPrice = 0.0;
        double maxSingleProductPrice = 0.0;
        // Calculate total quantity and cart price
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int price = pair.getKey();
            int quantity = pair.getValue();
//            int price = prices.get(i);
            int total =quantity*price;
         
            total_price = total_price + total;
            totalQuantity += quantity;
            totalCartPrice += price * quantity;

            if (quantity > maxSingleProductQuantity) {
                maxSingleProductQuantity = quantity;
                maxSingleProductPrice = price;
            }
        }

        // Apply discount rules
        Map<Double, String> dis = new HashMap<>();
        if (totalCartPrice > 200.0) {
        	dis.put(10.0, "flat_10_discount");
        }
         if (maxSingleProductQuantity > 10) {
        	 dis.put(maxSingleProductPrice * maxSingleProductQuantity * 0.05, "bulk_5_discount");
         }
        if (totalQuantity > 20) {
        	dis.put(totalCartPrice * 0.1, "bulk_10_discount");
        }
       if (totalQuantity > 30 && maxSingleProductQuantity > 15) {
    	   dis.put(maxSingleProductPrice * (maxSingleProductQuantity - 15) * 0.5,"tiered_50_discount");
        	}
       

       for (double key : dis.keySet()) {
           if (key > maxKey) {
               maxKey = key;
           }
       }
        discount_rule = dis.get(maxKey);  
	}

	
	public int packageFee(int total_unit) {
		
		return  (int) Math.ceil(total_unit /10.0);
	}

}
