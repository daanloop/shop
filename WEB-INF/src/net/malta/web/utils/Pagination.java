package net.malta.web.utils;

public class Pagination {
	public int getMax(int rows,int pagesize) {
		int max = (rows / pagesize);
		if((rows%pagesize) !=0){ max++; }
		return max;
	}	
}
