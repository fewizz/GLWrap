package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum ColorBuffer {
	NONE(GLConstants.GL_NONE),
	FRONT_LEFT(GLConstants.GL_FRONT_LEFT),
	FRONT_RIGHT(GLConstants.GL_FRONT_RIGHT),
	BACK_LEFT(GLConstants.GL_BACK_LEFT),
	BACK_RIGHT(GLConstants.GL_BACK_RIGHT),
	FRONT(GLConstants.GL_FRONT),
	BACK(GLConstants.GL_BACK),
	LEFT(GLConstants.GL_LEFT),
	RIGHT(GLConstants.GL_RIGHT),
	FRONT_AND_BACK(GLConstants.GL_FRONT_AND_BACK),
	COLOR_ATTACHMENT0(GLConstants.GL_COLOR_ATTACHMENT0),
	COLOR_ATTACHMENT1(GLConstants.GL_COLOR_ATTACHMENT1),
	COLOR_ATTACHMENT2(GLConstants.GL_COLOR_ATTACHMENT2),
	COLOR_ATTACHMENT3(GLConstants.GL_COLOR_ATTACHMENT3),
	COLOR_ATTACHMENT4(GLConstants.GL_COLOR_ATTACHMENT4),
	COLOR_ATTACHMENT5(GLConstants.GL_COLOR_ATTACHMENT5),
	COLOR_ATTACHMENT6(GLConstants.GL_COLOR_ATTACHMENT6),
	COLOR_ATTACHMENT7(GLConstants.GL_COLOR_ATTACHMENT7),
	COLOR_ATTACHMENT8(GLConstants.GL_COLOR_ATTACHMENT8),
	COLOR_ATTACHMENT9(GLConstants.GL_COLOR_ATTACHMENT9),
	COLOR_ATTACHMENT10(GLConstants.GL_COLOR_ATTACHMENT10),
	COLOR_ATTACHMENT11(GLConstants.GL_COLOR_ATTACHMENT11),
	COLOR_ATTACHMENT12(GLConstants.GL_COLOR_ATTACHMENT12),
	COLOR_ATTACHMENT13(GLConstants.GL_COLOR_ATTACHMENT13),
	COLOR_ATTACHMENT14(GLConstants.GL_COLOR_ATTACHMENT14),
	COLOR_ATTACHMENT15(GLConstants.GL_COLOR_ATTACHMENT15),
	COLOR_ATTACHMENT16(GLConstants.GL_COLOR_ATTACHMENT16),
	COLOR_ATTACHMENT17(GLConstants.GL_COLOR_ATTACHMENT17),
	COLOR_ATTACHMENT18(GLConstants.GL_COLOR_ATTACHMENT18),
	COLOR_ATTACHMENT19(GLConstants.GL_COLOR_ATTACHMENT19),
	COLOR_ATTACHMENT20(GLConstants.GL_COLOR_ATTACHMENT20),
	COLOR_ATTACHMENT21(GLConstants.GL_COLOR_ATTACHMENT21),
	COLOR_ATTACHMENT22(GLConstants.GL_COLOR_ATTACHMENT22),
	COLOR_ATTACHMENT23(GLConstants.GL_COLOR_ATTACHMENT23),
	COLOR_ATTACHMENT24(GLConstants.GL_COLOR_ATTACHMENT24),
	COLOR_ATTACHMENT25(GLConstants.GL_COLOR_ATTACHMENT25),
	COLOR_ATTACHMENT26(GLConstants.GL_COLOR_ATTACHMENT26),
	COLOR_ATTACHMENT27(GLConstants.GL_COLOR_ATTACHMENT27),
	COLOR_ATTACHMENT28(GLConstants.GL_COLOR_ATTACHMENT28),
	COLOR_ATTACHMENT29(GLConstants.GL_COLOR_ATTACHMENT29),
	COLOR_ATTACHMENT30(GLConstants.GL_COLOR_ATTACHMENT30),
	COLOR_ATTACHMENT31(GLConstants.GL_COLOR_ATTACHMENT31);

	ColorBuffer(int token) {
		this.token = token;
	}

	public final int token;

	public static final ColorBuffer[] VALUES = values();
	private static Map<Integer, ColorBuffer> getMap() {
		Map<Integer, ColorBuffer> map = new HashMap<>();
		for(ColorBuffer val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ColorBuffer> MAP = Collections.unmodifiableMap(getMap());
	public static ColorBuffer get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(ColorBuffer... enums) { int i = 0; for(ColorBuffer e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(ColorBuffer... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}