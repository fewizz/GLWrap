package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum DrawBufferMode {
	BACK(GLConstants.GL_BACK),
	BACK_LEFT(GLConstants.GL_BACK_LEFT),
	BACK_RIGHT(GLConstants.GL_BACK_RIGHT),
	FRONT(GLConstants.GL_FRONT),
	FRONT_AND_BACK(GLConstants.GL_FRONT_AND_BACK),
	FRONT_LEFT(GLConstants.GL_FRONT_LEFT),
	FRONT_RIGHT(GLConstants.GL_FRONT_RIGHT),
	LEFT(GLConstants.GL_LEFT),
	NONE(GLConstants.GL_NONE),
	RIGHT(GLConstants.GL_RIGHT);

	DrawBufferMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final DrawBufferMode[] VALUES = values();
	private static Map<Integer, DrawBufferMode> getMap() {
		Map<Integer, DrawBufferMode> map = new HashMap<>();
		for(DrawBufferMode val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, DrawBufferMode> MAP = Collections.unmodifiableMap(getMap());
	public static DrawBufferMode get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(DrawBufferMode... enums) { int i = 0; for(DrawBufferMode e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(DrawBufferMode... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}