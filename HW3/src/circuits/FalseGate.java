package circuits;

public class FalseGate extends Gate {

	private static FalseGate FalseGateton = null;

	private FalseGate(Gate[] inGates) {
		// constructor
		super(inGates);

	}

	public static Gate instance() {
		if (FalseGateton == null)
			FalseGateton = new FalseGate(null);
		return FalseGateton;
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return false;
	}

	@Override
	public String getName() {
		return "F";
	}

	@Override
	public Gate simplify() {
		return this;
	}
}
