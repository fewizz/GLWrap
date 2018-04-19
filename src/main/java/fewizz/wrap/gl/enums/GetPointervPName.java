package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum GetPointervPName {
	COLOR_ARRAY_POINTER(GLConstants.GL_COLOR_ARRAY_POINTER),
	NORMAL_ARRAY_POINTER(GLConstants.GL_NORMAL_ARRAY_POINTER),
	TEXTURE_COORD_ARRAY_POINTER(GLConstants.GL_TEXTURE_COORD_ARRAY_POINTER),
	VERTEX_ARRAY_POINTER(GLConstants.GL_VERTEX_ARRAY_POINTER),
	DEBUG_CALLBACK_FUNCTION(GLConstants.GL_DEBUG_CALLBACK_FUNCTION),
	DEBUG_CALLBACK_USER_PARAM(GLConstants.GL_DEBUG_CALLBACK_USER_PARAM);

	GetPointervPName(int token) {
		this.token = token;
	}

	public final int token;

	public static final GetPointervPName[] VALUES = values();
	private static Map<Integer, GetPointervPName> getMap() {
		Map<Integer, GetPointervPName> map = new HashMap<>();
		for(GetPointervPName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, GetPointervPName> MAP = Collections.unmodifiableMap(getMap());
	public static GetPointervPName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(GetPointervPName... enums) { int i = 0; for(GetPointervPName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(GetPointervPName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}