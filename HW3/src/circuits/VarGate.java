package circuits;

public class VarGate extends Gate {

	private String name;
	private Boolean valueOfGate = null;

	public VarGate(String name)
	// constructor
	{
		super(null);
		this.name = name;
	}

	public String getName() {
		return "V" + name;
	}

	protected boolean func(boolean[] inValues) throws CircuitException {
		if (valueOfGate == null)
			throw new CircuitException();
		return valueOfGate;
	}

	public void setVal(boolean value) {
		valueOfGate = value;
	}

	@Override
	public Gate simplify() {
		// return the instance of the gate
		if (valueOfGate == null)
			return this;
		else if (valueOfGate == true)
			return TrueGate.instance();
		else
			return FalseGate.instance();

	}
}
