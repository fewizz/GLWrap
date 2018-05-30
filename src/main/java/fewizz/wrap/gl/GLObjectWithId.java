package fewizz.wrap.gl;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GLObjectWithId<?> that = (GLObjectWithId<?>) o;
		return name == that.name &&
				Objects.equals(ctx, that.ctx);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ctx, name);
	}
}
