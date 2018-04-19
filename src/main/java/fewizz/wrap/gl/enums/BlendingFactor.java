package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum BlendingFactor {
	ZERO(GLConstants.GL_ZERO),
	ONE(GLConstants.GL_ONE),
	SRC_COLOR(GLConstants.GL_SRC_COLOR),
	ONE_MINUS_SRC_COLOR(GLConstants.GL_ONE_MINUS_SRC_COLOR),
	DST_COLOR(GLConstants.GL_DST_COLOR),
	ONE_MINUS_DST_COLOR(GLConstants.GL_ONE_MINUS_DST_COLOR),
	SRC_ALPHA(GLConstants.GL_SRC_ALPHA),
	ONE_MINUS_SRC_ALPHA(GLConstants.GL_ONE_MINUS_SRC_ALPHA),
	DST_ALPHA(GLConstants.GL_DST_ALPHA),
	ONE_MINUS_DST_ALPHA(GLConstants.GL_ONE_MINUS_DST_ALPHA),
	CONSTANT_COLOR(GLConstants.GL_CONSTANT_COLOR),
	ONE_MINUS_CONSTANT_COLOR(GLConstants.GL_ONE_MINUS_CONSTANT_COLOR),
	CONSTANT_ALPHA(GLConstants.GL_CONSTANT_ALPHA),
	ONE_MINUS_CONSTANT_ALPHA(GLConstants.GL_ONE_MINUS_CONSTANT_ALPHA),
	SRC_ALPHA_SATURATE(GLConstants.GL_SRC_ALPHA_SATURATE),
	SRC1_COLOR(GLConstants.GL_SRC1_COLOR),
	SRC1_ALPHA(GLConstants.GL_SRC1_ALPHA);

	BlendingFactor(int token) {
		this.token = token;
	}

	public final int token;

	public static final BlendingFactor[] VALUES = values();
	private static Map<Integer, BlendingFactor> getMap() {
		Map<Integer, BlendingFactor> map = new HashMap<>();
		for(BlendingFactor val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, BlendingFactor> MAP = Collections.unmodifiableMap(getMap());
	public static BlendingFactor get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(BlendingFactor... enums) { int i = 0; for(BlendingFactor e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(BlendingFactor... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}