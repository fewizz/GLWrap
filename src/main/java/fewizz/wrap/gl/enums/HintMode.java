package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum HintMode {
	DONT_CARE(GLConstants.GL_DONT_CARE),
	FASTEST(GLConstants.GL_FASTEST),
	NICEST(GLConstants.GL_NICEST);

	HintMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final HintMode[] VALUES = values();
	private static Map<Integer, HintMode> getMap() {
		Map<Integer, HintMode> map = new HashMap<>();
		for(HintMode val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, HintMode> MAP = Collections.unmodifiableMap(getMap());
	public static HintMode get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(HintMode... enums) { int i = 0; for(HintMode e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(HintMode... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}