package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.FramebufferTarget;

public class GLFrameBuffer extends GLBindableObject<GLFrameBuffer> {
	public final FramebufferTarget target;
	
	
	GLFrameBuffer(GLContext c, FramebufferTarget target) {
		super(c, c.wrap.frameBuff.gen());
		this.target = target;
		bind();
	}

	@Override
	public void bind() {
		ctx.wrap.frameBuff.bind(target.token, name);
	}

	@Override
	public void delete() {
		ctx.wrap.frameBuff.delete(name);
	}

}
