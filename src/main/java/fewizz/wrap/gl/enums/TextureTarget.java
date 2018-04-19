package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum TextureTarget {
	PROXY_TEXTURE_1D(GLConstants.GL_PROXY_TEXTURE_1D),
	PROXY_TEXTURE_1D_ARRAY(GLConstants.GL_PROXY_TEXTURE_1D_ARRAY),
	PROXY_TEXTURE_2D(GLConstants.GL_PROXY_TEXTURE_2D),
	PROXY_TEXTURE_2D_ARRAY(GLConstants.GL_PROXY_TEXTURE_2D_ARRAY),
	PROXY_TEXTURE_2D_MULTISAMPLE(GLConstants.GL_PROXY_TEXTURE_2D_MULTISAMPLE),
	PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY(GLConstants.GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY),
	PROXY_TEXTURE_3D(GLConstants.GL_PROXY_TEXTURE_3D),
	PROXY_TEXTURE_CUBE_MAP(GLConstants.GL_PROXY_TEXTURE_CUBE_MAP),
	PROXY_TEXTURE_CUBE_MAP_ARRAY(GLConstants.GL_PROXY_TEXTURE_CUBE_MAP_ARRAY),
	PROXY_TEXTURE_RECTANGLE(GLConstants.GL_PROXY_TEXTURE_RECTANGLE),
	TEXTURE_1D(GLConstants.GL_TEXTURE_1D),
	TEXTURE_2D(GLConstants.GL_TEXTURE_2D),
	TEXTURE_3D(GLConstants.GL_TEXTURE_3D),
	TEXTURE_RECTANGLE(GLConstants.GL_TEXTURE_RECTANGLE),
	TEXTURE_CUBE_MAP(GLConstants.GL_TEXTURE_CUBE_MAP),
	TEXTURE_CUBE_MAP_POSITIVE_X(GLConstants.GL_TEXTURE_CUBE_MAP_POSITIVE_X),
	TEXTURE_CUBE_MAP_NEGATIVE_X(GLConstants.GL_TEXTURE_CUBE_MAP_NEGATIVE_X),
	TEXTURE_CUBE_MAP_POSITIVE_Y(GLConstants.GL_TEXTURE_CUBE_MAP_POSITIVE_Y),
	TEXTURE_CUBE_MAP_NEGATIVE_Y(GLConstants.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y),
	TEXTURE_CUBE_MAP_POSITIVE_Z(GLConstants.GL_TEXTURE_CUBE_MAP_POSITIVE_Z),
	TEXTURE_CUBE_MAP_NEGATIVE_Z(GLConstants.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z),
	TEXTURE_CUBE_MAP_ARRAY(GLConstants.GL_TEXTURE_CUBE_MAP_ARRAY),
	TEXTURE_1D_ARRAY(GLConstants.GL_TEXTURE_1D_ARRAY),
	TEXTURE_2D_ARRAY(GLConstants.GL_TEXTURE_2D_ARRAY),
	TEXTURE_2D_MULTISAMPLE(GLConstants.GL_TEXTURE_2D_MULTISAMPLE),
	TEXTURE_2D_MULTISAMPLE_ARRAY(GLConstants.GL_TEXTURE_2D_MULTISAMPLE_ARRAY);

	TextureTarget(int token) {
		this.token = token;
	}

	public final int token;

	public static final TextureTarget[] VALUES = values();
	private static Map<Integer, TextureTarget> getMap() {
		Map<Integer, TextureTarget> map = new HashMap<>();
		for(TextureTarget val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, TextureTarget> MAP = Collections.unmodifiableMap(getMap());
	public static TextureTarget get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(TextureTarget... enums) { int i = 0; for(TextureTarget e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(TextureTarget... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}