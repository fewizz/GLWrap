package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum MaterialFace {
	BACK(GLConstants.GL_BACK),
	FRONT(GLConstants.GL_FRONT),
	FRONT_AND_BACK(GLConstants.GL_FRONT_AND_BACK);

	MaterialFace(int token) {
		this.token = token;
	}

	public final int token;

	public static final MaterialFace[] VALUES = values();
	private static Map<Integer, MaterialFace> getMap() {
		Map<Integer, MaterialFace> map = new HashMap<>();
		for(MaterialFace val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, MaterialFace> MAP = Collections.unmodifiableMap(getMap());
	public static MaterialFace get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(MaterialFace... enums) { int i = 0; for(MaterialFace e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(MaterialFace... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}