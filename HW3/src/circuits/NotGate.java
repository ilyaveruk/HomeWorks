package circuits;

public class NotGate extends Gate {

	public NotGate(Gate in) {
		// constructor
		super(new Gate[] { in });

	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {

		if (inValues[0] != true && inValues[0] != false)
			throw new CircuitException();
		return (!inValues[0]);

	}

	@Override
	public String getName() {
		return "NOT";
	}

	@Override
	public Gate simplify() {
		// checks the value of the gate and return the opposite
		if (inGates[0].simplify() instanceof TrueGate)
			return FalseGate.instance();
		if (inGates[0].simplify() instanceof FalseGate)
			return TrueGate.instance();
		if (inGates[0] instanceof NotGate)
			return inGates[0].inGates[0].simplify();
		return this;
	}

}
