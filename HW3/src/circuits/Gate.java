package circuits;

public abstract class Gate {
	protected Gate[] inGates;
	
	public Gate(Gate[] inGates) {
		this.inGates=inGates;
	}
	
	public boolean calc() throws CircuitException {
		
	}
	
	
	protected abstract boolean func(boolean[] inValues) throws CircuitException;
	
	public abstract String getName();
	
	public abstract Gate simplify();
	
	public String toString() {
		
	}
}
