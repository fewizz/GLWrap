package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum TextureEnvParameter {
	TEXTURE_ENV_COLOR(GLConstants.GL_TEXTURE_ENV_COLOR),
	TEXTURE_ENV_MODE(GLConstants.GL_TEXTURE_ENV_MODE);

	TextureEnvParameter(int token) {
		this.token = token;
	}

	public final int token;

	public static final TextureEnvParameter[] VALUES = values();
	private static Map<Integer, TextureEnvParameter> getMap() {
		Map<Integer, TextureEnvParameter> map = new HashMap<>();
		for(TextureEnvParameter val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, TextureEnvParameter> MAP = Collections.unmodifiableMap(getMap());
	public static TextureEnvParameter get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(TextureEnvParameter... enums) { int i = 0; for(TextureEnvParameter e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(TextureEnvParameter... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}