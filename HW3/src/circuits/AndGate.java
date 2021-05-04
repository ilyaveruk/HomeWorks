package circuits;

public class AndGate extends Gate {

	public AndGate(Gate[] inGates) {
		// constructor
		super(inGates);

	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// checks if there is false value in the gates and return false other wise
		// return true
		int i;
		for (i = 0; i < inValues.length; i++) {
			if (inValues[i] != true && inValues[i] != false)
				throw new CircuitException();
			if (!inValues[i])
				return false;
		}
		return true;
	}

	@Override
	public String getName() {
		return "AND";
	}

	@Override
	public Gate simplify() {
		// checks if there is a instance of false gate and return false gate
		// otherwise if all of the gates are true return true gate
		// and if there is another gates return new Andgate
		int count = 0, trueCount = 0, index = 0;
		int[] indexArr = new int[super.inGates.length];
		for (int i = 0; i < super.inGates.length; i++) {
			if (super.inGates[i].simplify() instanceof FalseGate)
				return FalseGate.instance();
			else if (super.inGates[i].simplify() instanceof TrueGate) {
				trueCount++;
				indexArr[i] = 0;
			} else {
				count++;
				indexArr[i] = 1;
				index = i;
			}
		}
		if (count == 1)
			return inGates[index].simplify();
		if (trueCount == super.inGates.length)
			return TrueGate.instance();
		Gate[] arrayForNewAnd = new Gate[count];
		index = 0;
		for (int i = 0; i < super.inGates.length; i++) {
			if (indexArr[i] == 1)
				arrayForNewAnd[index] = inGates[i].simplify();
			index++;
		}
		Gate newAnd = new AndGate(arrayForNewAnd);
		return newAnd;

	}
}
