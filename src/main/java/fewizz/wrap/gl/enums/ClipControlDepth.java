package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum ClipControlDepth {
	NEGATIVE_ONE_TO_ONE(GLConstants.GL_NEGATIVE_ONE_TO_ONE),
	ZERO_TO_ONE(GLConstants.GL_ZERO_TO_ONE);

	ClipControlDepth(int token) {
		this.token = token;
	}

	public final int token;

	public static final ClipControlDepth[] VALUES = values();
	private static Map<Integer, ClipControlDepth> getMap() {
		Map<Integer, ClipControlDepth> map = new HashMap<>();
		for(ClipControlDepth val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ClipControlDepth> MAP = Collections.unmodifiableMap(getMap());
	public static ClipControlDepth get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(ClipControlDepth... enums) { int i = 0; for(ClipControlDepth e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(ClipControlDepth... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}