package com.aero.o2o.web.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class GetIP {
	public static String getipString() {
		 
		InetAddress ip = null;
		Enumeration allNetInterfaces;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces
						.nextElement();
				System.out.println(netInterface.getName());
				Enumeration addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					ip = (InetAddress) addresses.nextElement();
					if (ip != null ) {
						System.out.println("本机的IP = " + ip.getHostAddress());
						//return ip.getHostAddress();
						
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	public static void main(String[] args) {
		 getipString() ;
	}
	
}
