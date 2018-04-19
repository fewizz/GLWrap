package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum PolygonMode {
	FILL(GLConstants.GL_FILL),
	LINE(GLConstants.GL_LINE),
	POINT(GLConstants.GL_POINT);

	PolygonMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final PolygonMode[] VALUES = values();
	private static Map<Integer, PolygonMode> getMap() {
		Map<Integer, PolygonMode> map = new HashMap<>();
		for(PolygonMode val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, PolygonMode> MAP = Collections.unmodifiableMap(getMap());
	public static PolygonMode get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(PolygonMode... enums) { int i = 0; for(PolygonMode e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(PolygonMode... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}