package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.BufferTarget;

public class GLAtomicCounterBuffer extends GLBuffer<GLAtomicCounterBuffer>{
	
	public GLAtomicCounterBuffer() {
		super(BufferTarget.ATOMIC_COUNTER_BUFFER);
	}
}
