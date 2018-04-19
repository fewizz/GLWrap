package fewizz.wrap.gl.wrapper;

import fewizz.wrap.gl.API;
import fewizz.wrap.gl.enums.*;
import org.lwjgl.opengl.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class LWJGLWrapper extends Wrapper {

	@Override
	public API getApi() {
		return API.GL;
	}
	
	@Override
	public void preContextObjectCreatrion() {
		GL.createCapabilities();
	}
	
	@Override
	CoreWrap createCoreWrap() {
		return new CoreWrap() {
			
			@Override
			public void clear(int mask) {
				GL11.glClear(mask);
			}

			@Override
			public void activeTexture(int index) {
				GL13.glActiveTexture(index);
			}

			@Override
			public int getError() {
				return GL11.glGetError();
			}

			@Override
			public void clearColor(float r, float g, float b, float a) {
				GL11.glClearColor(r, g, b, a);
			}

			@Override
			public void drawArrays(int mode, int first, int count) {
				GL11.glDrawArrays(mode, first, count);
			}

			@Override
			public int getInteger(int pname) {
				return GL11.glGetInteger(pname);
			}

			@Override
			public String getString(int pname) {
				return GL11.glGetString(pname);
			}

			@Override
			public void viewport(int x, int y, int w, int h) {
				GL11.glViewport(x, y, w, h);
			}

			@Override
			public void debugMessageCallback(final DebugMessageCallback callback) {
				GL43.glDebugMessageCallback((int source, int type, int id, int severity, int length, long message, long userParam) ->
					callback.callback(DebugSource.get(source), DebugType.get(type), id, DebugSeverity.get(severity), GLDebugMessageCallback.getMessage(length, message))
				, 0);
			}

			@Override
			public boolean isEnabled(int cap) {
				return GL11.glIsEnabled(cap);
			}

			@Override
			public void enable(int cap) {
				GL11.glEnable(cap);
			}

			@Override
			public void disable(int cap) {
				GL11.glDisable(cap);
			}
		};
	}
	
	@Override
	public TexWrap createTexWrap() {
		return new TexWrap() {
			
			@Override
			public int gen() {
				return GL11.glGenTextures();
			}
			
			@Override
			public void delete(int name) {
				GL11.glDeleteTextures(name);
			}
			
			@Override
			public void bind(int target, int name) {
				GL11.glBindTexture(target, name);
			}
			
			@Override
			public void parameteri(int tar, int pname, int val) {
				GL11.glTexParameteri(tar, pname, tar);
			}
			
			@Override
			public void parameterf(int tar, int pname, float val) {
				GL11.glTexParameterf(tar, pname, tar);
			}

			@Override
			public int getTexLevelParameteri(int target, int level, int param) {
				return GL11.glGetTexLevelParameteri(target, level, param);
			}

			@Override
			public void image2D(int tar, int level, int intfor, int w, int h, int border, int bufferPixelFormat, int bufferDataType, ByteBuffer buf) {
				GL11.glTexImage2D(tar, level, intfor, w, h, border, bufferPixelFormat, bufferDataType, buf);
			}

			@Override
			public void subImage2D(int tar, int level, int xOff, int yOff, int w, int h, int bufferPixelFormat, int bufferDataType, ByteBuffer buf) {
				GL11.glTexSubImage2D(tar, level, xOff, yOff, w, h, bufferPixelFormat, bufferDataType, buf);
			}

			@Override
			public void image3D(int tar, int level, int internalFormat, int w, int h, int d, int border, int bufferPixelFormat, int bufferDataType, ByteBuffer buf) {
				GL12.glTexImage3D(tar, level, internalFormat, w, h, d, border, bufferPixelFormat, bufferDataType, buf);
			}

			@Override
			public void subImage3D(int tar, int level, int xOff, int yOff, int zOff, int w, int h, int d, int bufferPixelFormat, int bufferDataType, ByteBuffer buf) {
				GL12.glTexSubImage3D(tar, level, xOff, yOff, zOff, w, h, d, bufferPixelFormat, bufferDataType, buf);
			}
		};
	}

	@Override
	BuffWrap createBuffWrap() {
		return new BuffWrap() {
			
			@Override
			public void delete(int name) {
				GL15.glDeleteBuffers(name);
			}
			
			@Override
			public int gen() {
				return GL15.glGenBuffers();
			}
			
			@Override
			public void bind(int target, int name) {
				GL15.glBindBuffer(target, name);
			}

			@Override
			public void data(int target, long size, ByteBuffer buf, int usage) {
			GL15.nglBufferData(target, size, memAddress(buf), usage);
			}

			@Override
			public void subData(int target, long offset, long size, ByteBuffer buf) {
				GL15.nglBufferSubData(target, offset, size, memAddress(buf));
			}

			@Override
			public ByteBuffer mapBufferRange(int target, long offset, long length, ByteBuffer buf, int access) {
				return GL30.glMapBufferRange(target, offset, length, access, buf);
			}

			@Override
			public void unmap(int target) {
				GL15.glUnmapBuffer(target);
			}

			@Override
			public int getVBOParameteri(BufferTarget tar, VertexBufferObjectParameter pname) {
				return GL15.glGetBufferParameteri(tar.token, pname.token);
			}
		};
	}

	@Override
	ShaderWrap createShaderWrap() {
		return new ShaderWrap() {
			
			@Override
			public void delete(int name) {
				GL20.glDeleteShader(name);
			}
			
			@Override
			public int create(int target) {
				return GL20.glCreateShader(target);
			}
			
			@Override
			public void source(int name, String src) {
				GL20.glShaderSource(name, src);
			}

			@Override
			public void compile(int name) {
				GL20.glCompileShader(name);
			}

			@Override
			public int geti(int name, int pname) {
				return GL20.glGetShaderi(name, pname);
			}

			@Override
			public String getInfoLog(int name) {
				return GL20.glGetShaderInfoLog(name);
			}
		};
	}

	@Override
	ShaderProgramWrap createShaderProgramWrap() {
		return new ShaderProgramWrap() {
			
			@Override
			public void delete(int name) {
				GL20.glDeleteProgram(name);
			}
			
			@Override
			public int create(int target) {
				return GL20.glCreateProgram();
			}

			@Override
			public void use(int name) {
				GL20.glUseProgram(name);
			}

			@Override
			public int geti(int name, int pname) {
				return GL20.glGetProgrami(name, pname);
			}

			@Override
			public void attachShader(int name, int shader) {
				GL20.glAttachShader(name, shader);
			}

			@Override
			public int attribLoc(int name, String attribName) {
				return GL20.glGetAttribLocation(name, attribName);	
			}

			@Override
			public int uniformLoc(int name, String uniformName) {
				return GL20.glGetUniformLocation(name, uniformName);
			}

			@Override
			public void link(int prog) {
				GL20.glLinkProgram(prog);
			}

			@Override
			public String getInfoLog(int name) {
				return GL20.glGetProgramInfoLog(name);
			}

			@Override
			public void uniform1iv(int loc, int count, IntBuffer buf) {
				GL20.nglUniform1iv(loc, count, memAddress(buf));
			}

			@Override
			public void uniformMatrix4fv(int loc, int count, boolean trans, FloatBuffer buf) {
				GL20.nglUniformMatrix4fv(loc, count, trans, memAddress(buf));
			}

			@Override
			public void uniform1i(int loc, int val) {
				GL20.glUniform1i(loc, val);
			}

			@Override
			public void attrib1fv(int loc, FloatBuffer buf) {
				GL20.glVertexAttrib1fv(loc, buf);
			}
		};
	}

	@Override
	VertexArrayWrap createVertexArrayWrap() {
		return new VertexArrayWrap() {
			
			@Override
			public void delete(int name) {
				GL30.glDeleteVertexArrays(name);
			}
			
			@Override
			public int gen() {
				return GL30.glGenVertexArrays();
			}
			
			@Override
			public void bind(int target, int name) {
				GL30.glBindVertexArray(name);
			}
			
			@Override
			public void vertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long pointer) {
				GL20.nglVertexAttribPointer(index, size, type, normalized, stride, pointer);
			}
			
			@Override
			public void vertexAttribIPointer(int index, int size, int type, int stride, long pointer) {
				GL30.nglVertexAttribIPointer(index, size, type, stride, pointer);
			}

			@Override
			public void enableAttrib(int index) {
				GL20.glEnableVertexAttribArray(index);
			}

			@Override
			public void disableAttrib(int index) {
				GL20.glDisableVertexAttribArray(index);
			}
		};
	}

	@Override
	FrameBuffWrap createFrameBuffWrap() {
		return new FrameBuffWrap() {
			
			@Override
			public void delete(int name) {
				GL30.glDeleteFramebuffers(name);
			}
			
			@Override
			public int gen() {
				return GL30.glGenFramebuffers();
			}
			
			@Override
			public void bind(int target, int name) {
				GL30.glBindFramebuffer(target, name);
			}
		};
	}

	@Override
	QueryWrap createQueryWrap() {
		return new QueryWrap() {
			
			@Override
			public void delete(int name) {
				GL15.glDeleteQueries(name);
			}
			
			@Override
			public int create(int target) {
				return GL15.glGenQueries();
			}
			
			@Override
			public void end(int target) {
				GL15.glEndQuery(target);
			}
			
			@Override
			public void begin(int target, int name) {
				GL15.glBeginQuery(target, name);
			}
		};
	}

}
