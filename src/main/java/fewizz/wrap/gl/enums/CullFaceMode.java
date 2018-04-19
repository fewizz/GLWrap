package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum CullFaceMode {
	BACK(GLConstants.GL_BACK),
	FRONT(GLConstants.GL_FRONT),
	FRONT_AND_BACK(GLConstants.GL_FRONT_AND_BACK);

	CullFaceMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final CullFaceMode[] VALUES = values();
	private static Map<Integer, CullFaceMode> getMap() {
		Map<Integer, CullFaceMode> map = new HashMap<>();
		for(CullFaceMode val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, CullFaceMode> MAP = Collections.unmodifiableMap(getMap());
	public static CullFaceMode get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(CullFaceMode... enums) { int i = 0; for(CullFaceMode e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(CullFaceMode... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}