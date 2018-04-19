package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.BufferTarget;

public class GLShaderStorageBuffer extends GLBuffer<GLShaderStorageBuffer> {
	
	public GLShaderStorageBuffer() {
		super(BufferTarget.SHADER_STORAGE_BUFFER);
	}
}
