package shop;

import java.util.ArrayList;

import java.util.List;

public class Shop {

	private List<Instrument> InsArr = new ArrayList<Instrument>();

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

		int guitarCount = 0, index = 0;

		if (get(serial) == null)
			throw new MusicShopException("There is no such instrument in stock");

		for (Instrument ins : InsArr) {
			if (ins.getSerial() == serial)
				index = InsArr.indexOf(ins);
			if (ins instanceof Guitar)
				guitarCount++;
		}
		if (get(serial) instanceof Guitar && (guitarCount) == 1)
			throw new MusicShopException("Only one guitar left");
		else
			InsArr.remove(index);
	}

	public int sellAll(int[] serials) throws MusicShopException {
		int unsold = 0;

		for (int i = 0; i < serials.length; i++)
			try {
				sell(serials[i]);
			} catch (MusicShopException e) {
				unsold++;
			}

		return unsold;

	}

}
