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
	private List<Map.Entry<String, List<String>>> brands;
	private List<Map.Entry<String, List<String>>> firms;
	private List<Map.Entry<String, List<Integer>>> types;
	private List<Map.Entry<Integer, List<String>>> years;

	private ConstantData(O2ODao o2oDao) {
		Map<String, List<String>> letterMap;
		Map<String, List<String>> brandMap;
		Map<String, List<String>> firmMap;
		Map<String, List<Integer>> typeMap;
		Map<Integer, List<String>> yearMap;
		List<Car> carList = o2oDao.queryForList("Car.queryAll", null);
		letterMap = new HashMap<String, List<String>>();
		brandMap = new HashMap<String, List<String>>();
		firmMap = new HashMap<String, List<String>>();
		typeMap = new HashMap<String, List<Integer>>();
		yearMap = new HashMap<Integer, List<String>>();

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
			firmMap.get(car.getFirm()).add(car.getType());

			if (!typeMap.containsKey(car.getType())) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(car.getYear());
				typeMap.put(car.getType(), list);
			} else if (!typeMap.get(car.getType()).contains(car.getYear())) {
				typeMap.get(car.getType()).add(car.getYear());
			}

			if (!yearMap.containsKey(car.getYear())) {
				List<String> list = new ArrayList<String>();
				list.add(car.getModel());
				yearMap.put(car.getYear(), list);
			} else if (!yearMap.get(car.getYear()).contains(car.getModel())) {
				yearMap.get(car.getYear()).add(car.getModel());
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

		brands = new ArrayList<Map.Entry<String, List<String>>>(
				brandMap.entrySet());
		Collections.sort(brands,
				new Comparator<Map.Entry<String, List<String>>>() {
					public int compare(Map.Entry<String, List<String>> o1,
							Map.Entry<String, List<String>> o2) {
						return (o1.getKey().compareTo(o2.getKey()));
					}
				});

		firms = new ArrayList<Map.Entry<String, List<String>>>(
				firmMap.entrySet());
		Collections.sort(firms,
				new Comparator<Map.Entry<String, List<String>>>() {
					public int compare(Map.Entry<String, List<String>> o1,
							Map.Entry<String, List<String>> o2) {
						return (o1.getKey().compareTo(o2.getKey()));
					}
				});

		types = new ArrayList<Map.Entry<String, List<Integer>>>(
				typeMap.entrySet());
		Collections.sort(types,
				new Comparator<Map.Entry<String, List<Integer>>>() {
					public int compare(Map.Entry<String, List<Integer>> o1,
							Map.Entry<String, List<Integer>> o2) {
						return (o1.getKey().compareTo(o2.getKey()));
					}
				});

		years = new ArrayList<Map.Entry<Integer, List<String>>>(
				yearMap.entrySet());
		Collections.sort(years,
				new Comparator<Map.Entry<Integer, List<String>>>() {
					public int compare(Map.Entry<Integer, List<String>> o1,
							Map.Entry<Integer, List<String>> o2) {
						return (o1.getKey().compareTo(o2.getKey()));
					}
				});
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

	public List<Map.Entry<String, List<String>>> getBrands() {
		return brands;
	}

	public void setBrands(List<Map.Entry<String, List<String>>> brands) {
		this.brands = brands;
	}

	public List<Map.Entry<String, List<String>>> getFirms() {
		return firms;
	}

	public void setFirms(List<Map.Entry<String, List<String>>> firms) {
		this.firms = firms;
	}

	public List<Map.Entry<String, List<Integer>>> getTypes() {
		return types;
	}

	public void setTypes(List<Map.Entry<String, List<Integer>>> types) {
		this.types = types;
	}

	public List<Map.Entry<Integer, List<String>>> getYears() {
		return years;
	}

	public void setYears(List<Map.Entry<Integer, List<String>>> years) {
		this.years = years;
	}

	

}
