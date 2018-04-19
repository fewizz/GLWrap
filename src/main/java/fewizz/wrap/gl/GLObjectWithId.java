package fewizz.wrap.gl;

public abstract class GLObjectWithId<SELF> {
	String label;
	final GLContext ctx;
	protected final int name;
	
	protected GLObjectWithId(GLContext c, int name) {
		ctx = c;
		this.name = name;
		
		if(ctx == null)
			throw new Error("There is no GL context on this thread");
	}

	public abstract void delete();
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}

	@SuppressWarnings("unchecked")
	protected SELF getThis() {
		return (SELF) this;
	}
	
	@Override
	protected void finalize() {
		System.out.println("Finalized: " + this);
	}
	
	@Override
	public String toString() {
		return "[" + getClass().getSimpleName() + " id:" +  name + "]";
	}
}
