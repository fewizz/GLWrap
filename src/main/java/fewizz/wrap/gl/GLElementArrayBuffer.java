package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.BufferTarget;

public class GLElementArrayBuffer extends GLBuffer<GLElementArrayBuffer> {
	
	public GLElementArrayBuffer() {
		super(BufferTarget.ELEMENT_ARRAY_BUFFER);
	}

}
