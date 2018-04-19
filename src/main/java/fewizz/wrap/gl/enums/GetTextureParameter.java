package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum GetTextureParameter {
	TEXTURE_ALPHA_SIZE(GLConstants.GL_TEXTURE_ALPHA_SIZE),
	TEXTURE_BLUE_SIZE(GLConstants.GL_TEXTURE_BLUE_SIZE),
	TEXTURE_BORDER_COLOR(GLConstants.GL_TEXTURE_BORDER_COLOR),
	TEXTURE_GREEN_SIZE(GLConstants.GL_TEXTURE_GREEN_SIZE),
	TEXTURE_HEIGHT(GLConstants.GL_TEXTURE_HEIGHT),
	TEXTURE_INTERNAL_FORMAT(GLConstants.GL_TEXTURE_INTERNAL_FORMAT),
	TEXTURE_MAG_FILTER(GLConstants.GL_TEXTURE_MAG_FILTER),
	TEXTURE_MIN_FILTER(GLConstants.GL_TEXTURE_MIN_FILTER),
	TEXTURE_RED_SIZE(GLConstants.GL_TEXTURE_RED_SIZE),
	TEXTURE_WIDTH(GLConstants.GL_TEXTURE_WIDTH),
	TEXTURE_WRAP_S(GLConstants.GL_TEXTURE_WRAP_S),
	TEXTURE_WRAP_T(GLConstants.GL_TEXTURE_WRAP_T);

	GetTextureParameter(int token) {
		this.token = token;
	}

	public final int token;

	public static final GetTextureParameter[] VALUES = values();
	private static Map<Integer, GetTextureParameter> getMap() {
		Map<Integer, GetTextureParameter> map = new HashMap<>();
		for(GetTextureParameter val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, GetTextureParameter> MAP = Collections.unmodifiableMap(getMap());
	public static GetTextureParameter get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(GetTextureParameter... enums) { int i = 0; for(GetTextureParameter e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(GetTextureParameter... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}