package fewizz.wrap.gl;

public abstract class GLBindableObject<SELF> extends GLObjectWithId<SELF> {
	public GLBindableObject(GLContext c, int name) {
		super(c, name);
	}

	protected abstract void bind();
}
