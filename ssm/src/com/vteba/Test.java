package com.vteba;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> lists = new ArrayList<String>();
		lists.add("adsf");
		
		String aa = lists.get(0);
		
		lists.clear();
		
		lists.add("好啊");
		
		lists.add(aa);
		
		System.out.println(lists);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(new Date()));
		
		List<String> destList = new ArrayList<String>();
		Collections.copy(destList, lists);
	}

}
