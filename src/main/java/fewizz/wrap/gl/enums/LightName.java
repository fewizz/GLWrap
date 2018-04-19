package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum LightName {
	LIGHT0(GLConstants.GL_LIGHT0),
	LIGHT1(GLConstants.GL_LIGHT1),
	LIGHT2(GLConstants.GL_LIGHT2),
	LIGHT3(GLConstants.GL_LIGHT3),
	LIGHT4(GLConstants.GL_LIGHT4),
	LIGHT5(GLConstants.GL_LIGHT5),
	LIGHT6(GLConstants.GL_LIGHT6),
	LIGHT7(GLConstants.GL_LIGHT7);

	LightName(int token) {
		this.token = token;
	}

	public final int token;

	public static final LightName[] VALUES = values();
	private static Map<Integer, LightName> getMap() {
		Map<Integer, LightName> map = new HashMap<>();
		for(LightName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, LightName> MAP = Collections.unmodifiableMap(getMap());
	public static LightName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(LightName... enums) { int i = 0; for(LightName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(LightName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}