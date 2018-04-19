package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum FrontFaceDirection {
	CCW(GLConstants.GL_CCW),
	CW(GLConstants.GL_CW);

	FrontFaceDirection(int token) {
		this.token = token;
	}

	public final int token;

	public static final FrontFaceDirection[] VALUES = values();
	private static Map<Integer, FrontFaceDirection> getMap() {
		Map<Integer, FrontFaceDirection> map = new HashMap<>();
		for(FrontFaceDirection val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, FrontFaceDirection> MAP = Collections.unmodifiableMap(getMap());
	public static FrontFaceDirection get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(FrontFaceDirection... enums) { int i = 0; for(FrontFaceDirection e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(FrontFaceDirection... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}