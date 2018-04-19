package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.*;
import fewizz.wrap.gl.wrapper.ContextProvider;
import fewizz.wrap.gl.wrapper.DebugMessageCallback;
import fewizz.wrap.gl.wrapper.Wrapper;

import java.util.Arrays;
import java.util.EnumMap;

public final class GLContext {
	static final ThreadLocal<GLContext> CONTEXTS = new ThreadLocal<>();
	final EnumMap<Capability, Boolean> capabilityMap = new EnumMap<>(Capability.class);
	final Wrapper wrap;
	final GLTexture[] activeTextures;
	int activeTextureUnit = 0;
	final API api;
	final int versionMajor;
	final int versionMinor;
	
	public final GLTexture defaultTexture;
	public final GLVertexArray defaultVertexArray;
	public final GLBuffer<?> defaultBuffer;
	public final GLShaderProgram defaultProgram;

	GLTexture boundTexture;
	GLVertexArray boundVertexArray;
	GLShaderProgram usingProgram;
	
	public static GLContext create(ContextProvider cp, Wrapper wrapper) {
		if (CONTEXTS.get() != null)
			throw new Error("Already created");
		
		cp.createContext();
		wrapper.preContextObjectCreatrion();
		GLContext c = new GLContext(wrapper);
		CONTEXTS.set(c);
		return c;
	}

	public static GLContext current() {
		return CONTEXTS.get();
	}

	private GLContext(Wrapper w) {
		wrap = w;
		api = wrap.getApi();
		
		versionMajor = getInteger(GLConstants.GL_MAJOR_VERSION);
		versionMinor = getInteger(GLConstants.GL_MINOR_VERSION);
		activeTextures = new GLTexture[getInteger(GLConstants.GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS)];

		defaultTexture = new GLTexture(this, TextureTarget.TEXTURE_2D, 0) {
			@Override
			public void delete() {throw new Error();}
		};
		defaultVertexArray = new GLVertexArray(this, 0) {
			@Override
			public void delete() {throw new Error();}
		};
		defaultBuffer = new GLBuffer<GLBuffer<?>>(this, BufferTarget.ARRAY_BUFFER, 0) {
			public void delete() {throw new Error();}
		};
		defaultProgram = new GLShaderProgram(this, 0) {
			public void delete() {throw new Error();}
		};
		boundTexture = defaultTexture;
		boundVertexArray = defaultVertexArray;
		usingProgram = defaultProgram;
		Arrays.fill(activeTextures, defaultTexture);
		
		for(Capability c : Capability.VALUES) {
			capabilityMap.put(c, wrap.core.isEnabled(c.token));
		}
	}
	
	void onTextureDeleted(GLTexture tex) {
		for (int unit = 0; unit < activeTextures.length; unit++) {
			if (activeTextures[unit] == tex)
				activeTextures[unit] = defaultTexture;
		}
	}
	
	public void set(Capability cap, boolean bool) {
		if(capabilityMap.put(cap, bool) != bool) {
			if(bool)
				wrap.core.enable(cap.token);
			else
				wrap.core.disable(cap.token);
		}
	}
	
	public void enable(Capability cap) {
		set(cap, true);
	}
	
	public void disable(Capability cap) {
		set(cap, false);
	}
	
	public boolean enabled(Capability cap) {
		return capabilityMap.get(cap);
	}

	void setActiveTextureUnitIndex(int index) {
		activeTextureUnit = index;
		wrap.core.activeTexture(GLConstants.GL_TEXTURE0 + activeTextureUnit);
	}

	public int getInteger(GetPName pname) {
		return getInteger(pname.token);
	}
	
	public int getInteger(int pname) { return wrap.core.getInteger(pname); }
	
	public String getString(StringName pname) {
		return wrap.core.getString(pname.token);
	}
	
	public ErrorCode getError() {
		return ErrorCode.get(wrap.core.getError());
	}
	
	public void clearColor(float red, float green, float blue, float alpha) {
		wrap.core.clearColor(red, green, blue, alpha);
	}
	
	public void clear(ClearBuffer... mask) {
		wrap.core.clear(ClearBuffer.intMaskOf(mask));
	}
	
	public void drawArrays(PrimitiveType mode, int count) {
		drawArrays(mode, 0, count);
	}
	
	public void drawArrays(GLVertexArray vao, PrimitiveType mode, int count) {
		vao.bind();
		drawArrays(mode, 0, count);
	}
	
	public void drawArrays(PrimitiveType mode, int first, int count) {
		wrap.core.drawArrays(mode.token, first, count);
	}
	
	public void viewport(int x, int y, int w, int h) {
		wrap.core.viewport(x, y, w, h);
	}
	
	public void dedugMessageCallback(DebugMessageCallback callback) {
		wrap.core.debugMessageCallback(callback);
	}
	
	public void vertexAttribPointer(int index, GLVertexArray.VertexAttribFormat attribInfo, GLVertexBuffer vbo, int stride, long offset) {
		if(boundVertexArray != defaultVertexArray) {
			defaultVertexArray.bind();
		}
		vbo.bind();
		wrap.vertexArray.vertexAttribPointer(index, attribInfo.components, attribInfo.clientDataType.token, attribInfo.normalized, stride, offset);
	}
	
	public void enableVertexAttribArray(int index) {
		if(boundVertexArray != defaultVertexArray) {
			defaultVertexArray.bind();
		}
		wrap.vertexArray.enableAttrib(index);
	}
}
