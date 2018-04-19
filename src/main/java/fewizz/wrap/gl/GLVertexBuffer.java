package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.BufferTarget;
import fewizz.wrap.gl.enums.BufferUsage;

import java.nio.ByteBuffer;

public class GLVertexBuffer extends GLBuffer<GLVertexBuffer> {
	
	public GLVertexBuffer() {
		super(BufferTarget.ARRAY_BUFFER);
	}

	public GLVertexBuffer(ByteBuffer buf, BufferUsage usage) {
		this(buf.remaining(), buf, usage);
	}

	public GLVertexBuffer(int size, ByteBuffer buf, BufferUsage usage) {
		super(BufferTarget.ARRAY_BUFFER);
		data(size, buf, usage);
	}
}