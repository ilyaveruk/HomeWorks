package circuits;

public class TrueGate extends Gate {

	private static TrueGate TrueGateton = null;

	private TrueGate(Gate[] inGates) {
		// constructor
		super(inGates);

	}

	public static Gate instance() {
		if (TrueGateton == null)
			TrueGateton = new TrueGate(null);
		return TrueGateton;
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return true;
	}

	@Override
	public String getName() {
		return "T";
	}

	@Override
	public Gate simplify() {
		return this;
	}

}
