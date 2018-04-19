package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum StencilFaceDirection {
	FRONT(GLConstants.GL_FRONT),
	BACK(GLConstants.GL_BACK),
	FRONT_AND_BACK(GLConstants.GL_FRONT_AND_BACK);

	StencilFaceDirection(int token) {
		this.token = token;
	}

	public final int token;

	public static final StencilFaceDirection[] VALUES = values();
	private static Map<Integer, StencilFaceDirection> getMap() {
		Map<Integer, StencilFaceDirection> map = new HashMap<>();
		for(StencilFaceDirection val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, StencilFaceDirection> MAP = Collections.unmodifiableMap(getMap());
	public static StencilFaceDirection get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(StencilFaceDirection... enums) { int i = 0; for(StencilFaceDirection e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(StencilFaceDirection... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}