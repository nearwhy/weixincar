package com.aero.o2o.util;

public class LatitudeAndLongitudeCompute {
	public  static long calDistance(Double a_x_point, Double a_y_point,  
            Double b_x_point, Double b_y_point) {  
        Double R = new Double(6371);  
        Double dlat = (b_x_point - a_x_point) * Math.PI / 180;  
        Double dlon = (b_y_point - a_y_point) * Math.PI / 180;  
        Double aDouble = Math.sin(dlat / 2) * Math.sin(dlat / 2)  
                + Math.cos(a_x_point * Math.PI / 180)  
                * Math.cos(b_x_point * Math.PI / 180) * Math.sin(dlon / 2)  
                * Math.sin(dlon / 2);  
        Double cDouble = 2 * Math.atan2(Math.sqrt(aDouble), Math  
                .sqrt(1 - aDouble));  
        long d = Math.round((R * cDouble) * 1000) / 1000;  
        return d;  
  
    }  
	
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Timestamp ts = stringToTimestamp("2012-12-12", "yyyy-mm-dd");
		 
		long d = calDistance( 39.75756073,116.04115295,31.17107201,121.4705658);
		System.out.println(d);
	}

 
}
