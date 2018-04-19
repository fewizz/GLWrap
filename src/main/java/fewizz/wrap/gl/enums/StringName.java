package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum StringName {
	EXTENSIONS(GLConstants.GL_EXTENSIONS),
	RENDERER(GLConstants.GL_RENDERER),
	VENDOR(GLConstants.GL_VENDOR),
	VERSION(GLConstants.GL_VERSION),
	SHADING_LANGUAGE_VERSION(GLConstants.GL_SHADING_LANGUAGE_VERSION);

	StringName(int token) {
		this.token = token;
	}

	public final int token;

	public static final StringName[] VALUES = values();
	private static Map<Integer, StringName> getMap() {
		Map<Integer, StringName> map = new HashMap<>();
		for(StringName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, StringName> MAP = Collections.unmodifiableMap(getMap());
	public static StringName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(StringName... enums) { int i = 0; for(StringName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(StringName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}