package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {

	ArrayList<Instrument> InsArr = new ArrayList<Instrument>();

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

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < InsArr.size(); i++) {
			if (InsArr.get(i) instanceof Guitar) {
				Guitar temp = (Guitar) InsArr.get(i);
				if (temp.getType() == t)
					list.add(InsArr.get(i).getSerial());
			}
		}

		return list;
	}
	
	public void sell(int serial) throws MusicShopException{
		
		
	}

}
