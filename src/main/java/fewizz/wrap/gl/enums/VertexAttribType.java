package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum VertexAttribType {
	BYTE(GLConstants.GL_BYTE, true, 1),
	SHORT(GLConstants.GL_SHORT, true, 2),
	INT(GLConstants.GL_INT, true, 4),
	FIXED(GLConstants.GL_FIXED, true, 4),
	FLOAT(GLConstants.GL_FLOAT, false, 4),
	HALF_FLOAT(GLConstants.GL_HALF_FLOAT, false, 4 / 2),
	DOUBLE(GLConstants.GL_DOUBLE, false, 8),
	UNSIGNED_BYTE(GLConstants.GL_UNSIGNED_BYTE, true, 1),
	UNSIGNED_SHORT(GLConstants.GL_UNSIGNED_SHORT, true, 2),
	UNSIGNED_INT(GLConstants.GL_UNSIGNED_INT, true, 4),
	INT_2_10_10_10_REV(GLConstants.GL_INT_2_10_10_10_REV, true, 4),
	UNSIGNED_INT_2_10_10_10_REV(GLConstants.GL_UNSIGNED_INT_2_10_10_10_REV, true, 4),
	UNSIGNED_INT_10F_11F_11F_REV(GLConstants.GL_UNSIGNED_INT_10F_11F_11F_REV, true, 4);

	VertexAttribType(int token, boolean isIntegral, int bytes) {
		this.token = token;
		this.isIntegral = isIntegral;
		this.bytes = bytes;
	}

	public final int token;
	public final boolean isIntegral;
	public final int bytes;

	public static final VertexAttribType[] VALUES = values();
	private static Map<Integer, VertexAttribType> getMap() {
		Map<Integer, VertexAttribType> map = new HashMap<>();
		for(VertexAttribType val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, VertexAttribType> MAP = Collections.unmodifiableMap(getMap());
	public static VertexAttribType get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(VertexAttribType... enums) { int i = 0; for(VertexAttribType e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(VertexAttribType... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}