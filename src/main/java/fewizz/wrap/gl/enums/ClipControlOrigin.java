package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum ClipControlOrigin {
	LOWER_LEFT(GLConstants.GL_LOWER_LEFT),
	UPPER_LEFT(GLConstants.GL_UPPER_LEFT);

	ClipControlOrigin(int token) {
		this.token = token;
	}

	public final int token;

	public static final ClipControlOrigin[] VALUES = values();
	private static Map<Integer, ClipControlOrigin> getMap() {
		Map<Integer, ClipControlOrigin> map = new HashMap<>();
		for(ClipControlOrigin val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ClipControlOrigin> MAP = Collections.unmodifiableMap(getMap());
	public static ClipControlOrigin get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(ClipControlOrigin... enums) { int i = 0; for(ClipControlOrigin e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(ClipControlOrigin... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}