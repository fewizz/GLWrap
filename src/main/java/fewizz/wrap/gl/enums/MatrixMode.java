package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum MatrixMode {
	MODELVIEW(GLConstants.GL_MODELVIEW),
	PROJECTION(GLConstants.GL_PROJECTION),
	TEXTURE(GLConstants.GL_TEXTURE);

	MatrixMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final MatrixMode[] VALUES = values();
	private static Map<Integer, MatrixMode> getMap() {
		Map<Integer, MatrixMode> map = new HashMap<>();
		for(MatrixMode val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, MatrixMode> MAP = Collections.unmodifiableMap(getMap());
	public static MatrixMode get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(MatrixMode... enums) { int i = 0; for(MatrixMode e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(MatrixMode... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}