package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum ReadBufferMode {
	BACK(GLConstants.GL_BACK),
	BACK_LEFT(GLConstants.GL_BACK_LEFT),
	BACK_RIGHT(GLConstants.GL_BACK_RIGHT),
	FRONT(GLConstants.GL_FRONT),
	FRONT_LEFT(GLConstants.GL_FRONT_LEFT),
	FRONT_RIGHT(GLConstants.GL_FRONT_RIGHT),
	LEFT(GLConstants.GL_LEFT),
	RIGHT(GLConstants.GL_RIGHT);

	ReadBufferMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final ReadBufferMode[] VALUES = values();
	private static Map<Integer, ReadBufferMode> getMap() {
		Map<Integer, ReadBufferMode> map = new HashMap<>();
		for(ReadBufferMode val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ReadBufferMode> MAP = Collections.unmodifiableMap(getMap());
	public static ReadBufferMode get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(ReadBufferMode... enums) { int i = 0; for(ReadBufferMode e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(ReadBufferMode... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}