package circuits;

public class OrGate extends Gate {

	public OrGate(Gate[] inGates) {
		// constructor
		super(inGates);

	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// checks if there is true value in the gates and return true other wise return
		// false
		int i;
		for (i = 0; i < inValues.length; i++) {
			if (inValues[i])
				return true;
		}
		return false;
	}

	@Override
	public String getName() {
		return "OR";
	}

	@Override
	public Gate simplify() {
		// checks if there is a instance of true gate and return true gate
		// otherwise if all of the gates are false return false gate
		// and if there is another gates return new Orgate
		int count = 0, falseCount = 0, index = 0;
		int[] indexArr = new int[super.inGates.length];
		for (int i = 0; i < super.inGates.length; i++) {
			if (super.inGates[i].simplify() instanceof TrueGate)
				return TrueGate.instance();
			else if (super.inGates[i].simplify() instanceof FalseGate) {
				falseCount++;
				indexArr[i] = 0;
			} else {
				count++;
				indexArr[i] = 1;
				index = i;
			}
		}
		if (count == 1)
			return inGates[index].simplify();
		if (falseCount == super.inGates.length)
			return FalseGate.instance();
		Gate[] arrayForNewOr = new Gate[count];
		index = 0;
		for (int i = 0; i < super.inGates.length; i++) {
			if (indexArr[i] == 1)
				arrayForNewOr[index] = inGates[i].simplify();
			index++;
		}
		Gate newOr = new OrGate(arrayForNewOr);
		return newOr;

	}

}
