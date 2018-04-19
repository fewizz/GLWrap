package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum BufferAccessARB {
	READ_ONLY(GLConstants.GL_READ_ONLY),
	WRITE_ONLY(GLConstants.GL_WRITE_ONLY),
	READ_WRITE(GLConstants.GL_READ_WRITE);

	BufferAccessARB(int token) {
		this.token = token;
	}

	public final int token;

	public static final BufferAccessARB[] VALUES = values();
	private static Map<Integer, BufferAccessARB> getMap() {
		Map<Integer, BufferAccessARB> map = new HashMap<>();
		for(BufferAccessARB val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, BufferAccessARB> MAP = Collections.unmodifiableMap(getMap());
	public static BufferAccessARB get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(BufferAccessARB... enums) { int i = 0; for(BufferAccessARB e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(BufferAccessARB... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}