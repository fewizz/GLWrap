package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum ColorPointerType {
	BYTE(GLConstants.GL_BYTE),
	DOUBLE(GLConstants.GL_DOUBLE),
	FLOAT(GLConstants.GL_FLOAT),
	INT(GLConstants.GL_INT),
	SHORT(GLConstants.GL_SHORT),
	UNSIGNED_BYTE(GLConstants.GL_UNSIGNED_BYTE),
	UNSIGNED_INT(GLConstants.GL_UNSIGNED_INT),
	UNSIGNED_SHORT(GLConstants.GL_UNSIGNED_SHORT);

	ColorPointerType(int token) {
		this.token = token;
	}

	public final int token;

	public static final ColorPointerType[] VALUES = values();
	private static Map<Integer, ColorPointerType> getMap() {
		Map<Integer, ColorPointerType> map = new HashMap<>();
		for(ColorPointerType val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ColorPointerType> MAP = Collections.unmodifiableMap(getMap());
	public static ColorPointerType get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(ColorPointerType... enums) { int i = 0; for(ColorPointerType e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(ColorPointerType... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}