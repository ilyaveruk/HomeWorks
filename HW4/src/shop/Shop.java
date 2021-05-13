package shop;

import java.util.ArrayList;

import java.util.List;

public class Shop {

	List<Instrument> InsArr = new ArrayList<Instrument>();
	List<Instrument> deletedArr = new ArrayList<Instrument>();

	public void add(Instrument i) {
		InsArr.add(i);
	}

	public Instrument get(int serial) {

		for (Instrument a : InsArr)
			if (a.getSerial() == serial)
				return a;
		return null;

	}

	public List<Integer> allSerials() {

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < InsArr.size(); i++)
			list.add(InsArr.get(i).getSerial());

		return list;
	}

	public List<Integer> guitarsOfType(Type t) {

		List<Integer> typeList = new ArrayList<Integer>();

		for (Instrument ins : InsArr)
			if (ins instanceof Guitar) {
				Guitar temp = (Guitar) ins;
				if (temp.getType() == t)
					typeList.add(ins.getSerial());
			}

		return typeList;
	}

	public void sell(int serial) throws MusicShopException {

		for (int i = 0; i < InsArr.size(); i++) {
		

			if (InsArr.get(i).getSerial() == serial) {
				deletedArr.add(InsArr.get(i));
				InsArr.remove(i);
			}

		}

	}

}
