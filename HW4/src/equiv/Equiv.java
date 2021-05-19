package equiv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equiv<E> {

	private List<Set<E>> list = new ArrayList<>();

	public void add(E e1, E e2) {
		int Num1 = -1;
		int Num2 = -1;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains(e1))
				Num1 = i;
			if (list.get(i).contains(e2))
				Num2 = i;
		}
		if (Num1 == -1 && Num2 == -1) {
			Set<E> newSet = new HashSet<E>();
			newSet.add(e1);
			newSet.add(e2);
			list.add(newSet);
		}

		if (Num1 != Num2)// if at least one of the elements exists in a set
		{
			if (Num1 == -1 && Num2 != -1) {
				list.get(Num2).add(e1);
			}

			if (Num1 != -1 && Num2 == -1) {
				list.get(Num1).add(e2);
			}

			if (Num1 != -1 && Num2 != -1) {
				list.get(Num1).addAll(list.get(Num2));
				list.remove(Num2);
			}
		}
	}

	public boolean are(E e1, E e2) {
		if (e1.equals(e2))
			return true;
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).contains(e1) && list.get(i).contains(e2))
				return true;
		return false;
	}

}
