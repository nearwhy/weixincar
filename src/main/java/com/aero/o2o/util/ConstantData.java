package com.aero.o2o.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aero.o2o.dao.O2ODao;
import com.aero.o2o.model.Car;

public class ConstantData {

	private static ConstantData data;

	private List<Map.Entry<String, List<String>>> letters;
//	private List<Map.Entry<String, List<String>>> brands;
//	private List<Map.Entry<String, List<String>>> firms;
//	private List<Map.Entry<String, List<Integer>>> types;
//	private List<Map.Entry<Integer, List<String>>> years;

	private Map<String, List<String>> brandMap;
	private Map<String, List<String>> firmMap;
	private Map<String, List<Integer>> typeMap;
	private Map<String, List<Car>> yearMap;

	private ConstantData(O2ODao o2oDao) {
		Map<String, List<String>> letterMap;
		List<Car> carList = o2oDao.queryForList("Car.queryAll", null);
		letterMap = new HashMap<String, List<String>>();
		brandMap = new HashMap<String, List<String>>();
		firmMap = new HashMap<String, List<String>>();
		typeMap = new HashMap<String, List<Integer>>();
		yearMap = new HashMap<String, List<Car>>();

		for (Car car : carList) {
			if (!letterMap.containsKey(car.getLetter())) {
				List<String> list = new ArrayList<String>();
				list.add(car.getBrand());
				letterMap.put(car.getLetter(), list);
			} else if (!letterMap.get(car.getLetter()).contains(car.getBrand())) {
				letterMap.get(car.getLetter()).add(car.getBrand());
			}

			if (!brandMap.containsKey(car.getBrand())) {
				List<String> list = new ArrayList<String>();
				list.add(car.getFirm());
				brandMap.put(car.getBrand(), list);
			} else if (!brandMap.get(car.getBrand()).contains(car.getFirm())) {
				brandMap.get(car.getBrand()).add(car.getFirm());
			}

			if (!firmMap.containsKey(car.getFirm())) {
				List<String> list = new ArrayList<String>();
				list.add(car.getType());
				firmMap.put(car.getFirm(), list);
			} else if (!firmMap.get(car.getFirm()).contains(car.getType())) {
				firmMap.get(car.getFirm()).add(car.getType());
			}

			if (!typeMap.containsKey(car.getType())) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(car.getYear());
				typeMap.put(car.getType(), list);
			} else if (!typeMap.get(car.getType()).contains(car.getYear())) {
				typeMap.get(car.getType()).add(car.getYear());
			}

			if (!yearMap.containsKey(car.getYear()+"-"+car.getType())) {
				List<Car> list = new ArrayList<Car>();
				list.add(car);
				yearMap.put(car.getYear()+"-"+car.getType(), list);
			} else if (!yearMap.get(car.getYear()+"-"+car.getType()).contains(car)) {
				yearMap.get(car.getYear()+"-"+car.getType()).add(car);
			}
		}

		letters = new ArrayList<Map.Entry<String, List<String>>>(
				letterMap.entrySet());
		Collections.sort(letters,
				new Comparator<Map.Entry<String, List<String>>>() {
					public int compare(Map.Entry<String, List<String>> o1,
							Map.Entry<String, List<String>> o2) {
						return (o1.getKey().compareTo(o2.getKey()));
					}
				});

//		brands = new ArrayList<Map.Entry<String, List<String>>>(
//				brandMap.entrySet());
//		Collections.sort(brands,
//				new Comparator<Map.Entry<String, List<String>>>() {
//					public int compare(Map.Entry<String, List<String>> o1,
//							Map.Entry<String, List<String>> o2) {
//						return (o1.getKey().compareTo(o2.getKey()));
//					}
//				});
//
//		firms = new ArrayList<Map.Entry<String, List<String>>>(
//				firmMap.entrySet());
//		Collections.sort(firms,
//				new Comparator<Map.Entry<String, List<String>>>() {
//					public int compare(Map.Entry<String, List<String>> o1,
//							Map.Entry<String, List<String>> o2) {
//						return (o1.getKey().compareTo(o2.getKey()));
//					}
//				});
//
//		types = new ArrayList<Map.Entry<String, List<Integer>>>(
//				typeMap.entrySet());
//		Collections.sort(types,
//				new Comparator<Map.Entry<String, List<Integer>>>() {
//					public int compare(Map.Entry<String, List<Integer>> o1,
//							Map.Entry<String, List<Integer>> o2) {
//						return (o1.getKey().compareTo(o2.getKey()));
//					}
//				});
//
//		years = new ArrayList<Map.Entry<Integer, List<String>>>(
//				yearMap.entrySet());
//		Collections.sort(years,
//				new Comparator<Map.Entry<Integer, List<String>>>() {
//					public int compare(Map.Entry<Integer, List<String>> o1,
//							Map.Entry<Integer, List<String>> o2) {
//						return (o1.getKey().compareTo(o2.getKey()));
//					}
//				});
	}

	public static ConstantData getInstance(O2ODao o2oDao) {
		if (data == null) {
			data = new ConstantData(o2oDao);
		}
		return data;
	}

	public static ConstantData getData() {
		return data;
	}

	public static void setData(ConstantData data) {
		ConstantData.data = data;
	}

	public List<Map.Entry<String, List<String>>> getLetters() {
		return letters;
	}

	public void setLetters(List<Map.Entry<String, List<String>>> letters) {
		this.letters = letters;
	}

	public Map<String, List<String>> getBrandMap() {
		return brandMap;
	}

	public void setBrandMap(Map<String, List<String>> brandMap) {
		this.brandMap = brandMap;
	}

	public Map<String, List<String>> getFirmMap() {
		return firmMap;
	}

	public void setFirmMap(Map<String, List<String>> firmMap) {
		this.firmMap = firmMap;
	}

	public Map<String, List<Integer>> getTypeMap() {
		return typeMap;
	}

	public void setTypeMap(Map<String, List<Integer>> typeMap) {
		this.typeMap = typeMap;
	}

	public Map<String, List<Car>> getYearMap() {
		return yearMap;
	}

	public void setYearMap(Map<String, List<Car>> yearMap) {
		this.yearMap = yearMap;
	}


	

}
