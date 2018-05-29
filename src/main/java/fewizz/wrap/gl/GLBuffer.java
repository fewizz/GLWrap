package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.BufferAccess;
import fewizz.wrap.gl.enums.BufferTarget;
import fewizz.wrap.gl.enums.BufferUsage;
import fewizz.wrap.gl.enums.VertexBufferObjectParameter;

import java.nio.ByteBuffer;

public class GLBuffer<SELF> extends GLBindableObject<SELF> {
	ByteBuffer allocation;
	final protected BufferTarget target;

	public GLBuffer(BufferTarget target) {
		this(GLContext.current(), target);
	}
	
	GLBuffer(GLContext c, BufferTarget target) {
		this(c, target, c.wrap.buff.gen());
	}

	GLBuffer(GLContext c, BufferTarget target, int name) {
		super(c, name);
		this.target = target;
		bind();
	}

	@Override
	public void bind() {
		ctx.wrap.buff.bind(target.token, name);
	}
	
	public int size() {
		return ctx.wrap.buff.getVBOParameteri(BufferTarget.ARRAY_BUFFER, VertexBufferObjectParameter.BUFFER_SIZE);
	}

	public void data(long size, ByteBuffer buf, BufferUsage usage) {
		bind();
		ctx.wrap.buff.data(target.token, size, buf, usage.token);
	}

	public void subData(long offset, long size, ByteBuffer buf) {
		bind();
		ctx.wrap.buff.subData(target.token, offset, size, buf);
	}

	public void allocate(long size, BufferUsage usage) {
		bind();
		ctx.wrap.buff.allocate(target.token, size, usage.token);
	}

	public ByteBuffer mapRange(long offset, long size, BufferAccess... access) {
		bind();
		allocation = ctx.wrap.buff.mapBufferRange(target.token, offset, size, allocation, BufferAccess.intMaskOf(access));
		return allocation;
	}

	public void unmap() {
		BufferUtils.address(allocation, 0);
		bind();
		ctx.wrap.buff.unmap(target.token);
	}

	@Override
	public void delete() {
		ctx.wrap.buff.delete(name);
	}
}
