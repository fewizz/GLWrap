package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.BufferTarget;

public class GLUniformBuffer extends GLBuffer<GLUniformBuffer> {
	
	public GLUniformBuffer() {
		super(BufferTarget.UNIFORM_BUFFER);
	}
}
