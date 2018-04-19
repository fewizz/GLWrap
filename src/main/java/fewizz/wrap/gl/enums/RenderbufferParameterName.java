package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum RenderbufferParameterName {
	RENDERBUFFER_WIDTH(GLConstants.GL_RENDERBUFFER_WIDTH),
	RENDERBUFFER_HEIGHT(GLConstants.GL_RENDERBUFFER_HEIGHT),
	RENDERBUFFER_INTERNAL_FORMAT(GLConstants.GL_RENDERBUFFER_INTERNAL_FORMAT),
	RENDERBUFFER_SAMPLES(GLConstants.GL_RENDERBUFFER_SAMPLES),
	RENDERBUFFER_RED_SIZE(GLConstants.GL_RENDERBUFFER_RED_SIZE),
	RENDERBUFFER_GREEN_SIZE(GLConstants.GL_RENDERBUFFER_GREEN_SIZE),
	RENDERBUFFER_BLUE_SIZE(GLConstants.GL_RENDERBUFFER_BLUE_SIZE),
	RENDERBUFFER_ALPHA_SIZE(GLConstants.GL_RENDERBUFFER_ALPHA_SIZE),
	RENDERBUFFER_DEPTH_SIZE(GLConstants.GL_RENDERBUFFER_DEPTH_SIZE),
	RENDERBUFFER_STENCIL_SIZE(GLConstants.GL_RENDERBUFFER_STENCIL_SIZE);

	RenderbufferParameterName(int token) {
		this.token = token;
	}

	public final int token;

	public static final RenderbufferParameterName[] VALUES = values();
	private static Map<Integer, RenderbufferParameterName> getMap() {
		Map<Integer, RenderbufferParameterName> map = new HashMap<>();
		for(RenderbufferParameterName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, RenderbufferParameterName> MAP = Collections.unmodifiableMap(getMap());
	public static RenderbufferParameterName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(RenderbufferParameterName... enums) { int i = 0; for(RenderbufferParameterName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(RenderbufferParameterName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}