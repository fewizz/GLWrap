package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum FramebufferParameterName {
	FRAMEBUFFER_DEFAULT_WIDTH(GLConstants.GL_FRAMEBUFFER_DEFAULT_WIDTH),
	FRAMEBUFFER_DEFAULT_HEIGHT(GLConstants.GL_FRAMEBUFFER_DEFAULT_HEIGHT),
	FRAMEBUFFER_DEFAULT_LAYERS(GLConstants.GL_FRAMEBUFFER_DEFAULT_LAYERS),
	FRAMEBUFFER_DEFAULT_SAMPLES(GLConstants.GL_FRAMEBUFFER_DEFAULT_SAMPLES),
	FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS(GLConstants.GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS);

	FramebufferParameterName(int token) {
		this.token = token;
	}

	public final int token;

	public static final FramebufferParameterName[] VALUES = values();
	private static Map<Integer, FramebufferParameterName> getMap() {
		Map<Integer, FramebufferParameterName> map = new HashMap<>();
		for(FramebufferParameterName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, FramebufferParameterName> MAP = Collections.unmodifiableMap(getMap());
	public static FramebufferParameterName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(FramebufferParameterName... enums) { int i = 0; for(FramebufferParameterName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(FramebufferParameterName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}