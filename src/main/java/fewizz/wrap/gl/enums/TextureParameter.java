package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum TextureParameter {
	GENERATE_MIPMAP(GLConstants.GL_GENERATE_MIPMAP),
	TEXTURE_BORDER_COLOR(GLConstants.GL_TEXTURE_BORDER_COLOR),
	TEXTURE_MAG_FILTER(GLConstants.GL_TEXTURE_MAG_FILTER),
	TEXTURE_MIN_FILTER(GLConstants.GL_TEXTURE_MIN_FILTER),
	TEXTURE_WRAP_R(GLConstants.GL_TEXTURE_WRAP_R),
	TEXTURE_WRAP_S(GLConstants.GL_TEXTURE_WRAP_S),
	TEXTURE_WRAP_T(GLConstants.GL_TEXTURE_WRAP_T),
	TEXTURE_BASE_LEVEL(GLConstants.GL_TEXTURE_BASE_LEVEL),
	TEXTURE_COMPARE_MODE(GLConstants.GL_TEXTURE_COMPARE_MODE),
	TEXTURE_COMPARE_FUNC(GLConstants.GL_TEXTURE_COMPARE_FUNC),
	TEXTURE_LOD_BIAS(GLConstants.GL_TEXTURE_LOD_BIAS),
	TEXTURE_MIN_LOD(GLConstants.GL_TEXTURE_MIN_LOD),
	TEXTURE_MAX_LOD(GLConstants.GL_TEXTURE_MAX_LOD),
	TEXTURE_MAX_LEVEL(GLConstants.GL_TEXTURE_MAX_LEVEL),
	TEXTURE_SWIZZLE_R(GLConstants.GL_TEXTURE_SWIZZLE_R),
	TEXTURE_SWIZZLE_G(GLConstants.GL_TEXTURE_SWIZZLE_G),
	TEXTURE_SWIZZLE_B(GLConstants.GL_TEXTURE_SWIZZLE_B),
	TEXTURE_SWIZZLE_A(GLConstants.GL_TEXTURE_SWIZZLE_A),
	TEXTURE_SWIZZLE_RGBA(GLConstants.GL_TEXTURE_SWIZZLE_RGBA),
	DEPTH_STENCIL_TEXTURE_MODE(GLConstants.GL_DEPTH_STENCIL_TEXTURE_MODE),
	TEXTURE_ALPHA_SIZE(GLConstants.GL_TEXTURE_ALPHA_SIZE),
	TEXTURE_BLUE_SIZE(GLConstants.GL_TEXTURE_BLUE_SIZE),
	TEXTURE_GREEN_SIZE(GLConstants.GL_TEXTURE_GREEN_SIZE),
	TEXTURE_HEIGHT(GLConstants.GL_TEXTURE_HEIGHT),
	TEXTURE_INTERNAL_FORMAT(GLConstants.GL_TEXTURE_INTERNAL_FORMAT),
	TEXTURE_RED_SIZE(GLConstants.GL_TEXTURE_RED_SIZE),
	TEXTURE_WIDTH(GLConstants.GL_TEXTURE_WIDTH);

	TextureParameter(int token) {
		this.token = token;
	}

	public final int token;

	public static final TextureParameter[] VALUES = values();
	private static Map<Integer, TextureParameter> getMap() {
		Map<Integer, TextureParameter> map = new HashMap<>();
		for(TextureParameter val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, TextureParameter> MAP = Collections.unmodifiableMap(getMap());
	public static TextureParameter get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(TextureParameter... enums) { int i = 0; for(TextureParameter e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(TextureParameter... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}