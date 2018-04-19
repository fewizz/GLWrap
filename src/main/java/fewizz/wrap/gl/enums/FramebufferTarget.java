package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum FramebufferTarget {
	FRAMEBUFFER(GLConstants.GL_FRAMEBUFFER),
	DRAW_FRAMEBUFFER(GLConstants.GL_DRAW_FRAMEBUFFER),
	READ_FRAMEBUFFER(GLConstants.GL_READ_FRAMEBUFFER);

	FramebufferTarget(int token) {
		this.token = token;
	}

	public final int token;

	public static final FramebufferTarget[] VALUES = values();
	private static Map<Integer, FramebufferTarget> getMap() {
		Map<Integer, FramebufferTarget> map = new HashMap<>();
		for(FramebufferTarget val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, FramebufferTarget> MAP = Collections.unmodifiableMap(getMap());
	public static FramebufferTarget get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(FramebufferTarget... enums) { int i = 0; for(FramebufferTarget e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(FramebufferTarget... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}