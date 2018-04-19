package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum AlphaFunction {
	ALWAYS(GLConstants.GL_ALWAYS),
	EQUAL(GLConstants.GL_EQUAL),
	GEQUAL(GLConstants.GL_GEQUAL),
	GREATER(GLConstants.GL_GREATER),
	LEQUAL(GLConstants.GL_LEQUAL),
	LESS(GLConstants.GL_LESS),
	NEVER(GLConstants.GL_NEVER),
	NOTEQUAL(GLConstants.GL_NOTEQUAL);

	AlphaFunction(int token) {
		this.token = token;
	}

	public final int token;

	public static final AlphaFunction[] VALUES = values();
	private static Map<Integer, AlphaFunction> getMap() {
		Map<Integer, AlphaFunction> map = new HashMap<>();
		for(AlphaFunction val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, AlphaFunction> MAP = Collections.unmodifiableMap(getMap());
	public static AlphaFunction get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(AlphaFunction... enums) { int i = 0; for(AlphaFunction e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(AlphaFunction... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}