package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum TextureEnvTarget {
	TEXTURE_ENV(GLConstants.GL_TEXTURE_ENV);

	TextureEnvTarget(int token) {
		this.token = token;
	}

	public final int token;

	public static final TextureEnvTarget[] VALUES = values();
	private static Map<Integer, TextureEnvTarget> getMap() {
		Map<Integer, TextureEnvTarget> map = new HashMap<>();
		for(TextureEnvTarget val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, TextureEnvTarget> MAP = Collections.unmodifiableMap(getMap());
	public static TextureEnvTarget get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(TextureEnvTarget... enums) { int i = 0; for(TextureEnvTarget e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(TextureEnvTarget... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}