package circuits;

public abstract class Gate {

	protected Gate[] inGates;

	public Gate(Gate[] inGates)
	// constructor
	{
		this.inGates = inGates;

	}

	public boolean calc() throws CircuitException {
		// tries to calculate the gate if its can't throw exception
		if (inGates == null)
			return this.func(null);
		else {
			boolean[] boolArray = new boolean[inGates.length];
			try {
				for (int i = 0; i < inGates.length; i++)
					boolArray[i] = inGates[i].calc();
			} catch (CircuitException e) {
				System.out.println(e.getMessage());
			}
			return this.func(boolArray);
		}

	}

	protected abstract boolean func(boolean[] inValues) throws CircuitException;

	public abstract String getName();

	public abstract Gate simplify();

	public String toString()
	// Builds a string out of the gates
	{
		StringBuilder stringToRet = new StringBuilder();
		if (this.inGates == null)
			stringToRet.append(this.getName());
		else {
			stringToRet.append(this.getName());
			stringToRet.append("[");
			for (int i = 0; i < inGates.length; i++) {
				stringToRet.append(this.inGates[i].toString());
				if (i != inGates.length - 1)
					stringToRet.append(", ");
			}
			stringToRet.append("]");
		}

		return stringToRet.toString();
	}

}
