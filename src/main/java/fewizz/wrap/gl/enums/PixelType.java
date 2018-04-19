package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum PixelType {
	BYTE(GLConstants.GL_BYTE),
	FLOAT(GLConstants.GL_FLOAT),
	INT(GLConstants.GL_INT),
	SHORT(GLConstants.GL_SHORT),
	UNSIGNED_BYTE(GLConstants.GL_UNSIGNED_BYTE),
	UNSIGNED_BYTE_3_3_2(GLConstants.GL_UNSIGNED_BYTE_3_3_2),
	UNSIGNED_INT(GLConstants.GL_UNSIGNED_INT),
	UNSIGNED_INT_10_10_10_2(GLConstants.GL_UNSIGNED_INT_10_10_10_2),
	UNSIGNED_INT_8_8_8_8(GLConstants.GL_UNSIGNED_INT_8_8_8_8),
	UNSIGNED_SHORT(GLConstants.GL_UNSIGNED_SHORT),
	UNSIGNED_SHORT_4_4_4_4(GLConstants.GL_UNSIGNED_SHORT_4_4_4_4),
	UNSIGNED_SHORT_5_5_5_1(GLConstants.GL_UNSIGNED_SHORT_5_5_5_1);

	PixelType(int token) {
		this.token = token;
	}

	public final int token;

	public static final PixelType[] VALUES = values();
	private static Map<Integer, PixelType> getMap() {
		Map<Integer, PixelType> map = new HashMap<>();
		for(PixelType val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, PixelType> MAP = Collections.unmodifiableMap(getMap());
	public static PixelType get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(PixelType... enums) { int i = 0; for(PixelType e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(PixelType... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}