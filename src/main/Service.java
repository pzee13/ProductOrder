package main;

import java.util.Map;

public interface Service {

	public int checkWrap();
	public void findDiscount(Map<Integer,Integer> map);
	public int packageFee(int total_unit);

	
}
