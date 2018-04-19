package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum BufferUsage {
	STREAM_DRAW(GLConstants.GL_STREAM_DRAW),
	STREAM_READ(GLConstants.GL_STREAM_READ),
	STREAM_COPY(GLConstants.GL_STREAM_COPY),
	STATIC_DRAW(GLConstants.GL_STATIC_DRAW),
	STATIC_READ(GLConstants.GL_STATIC_READ),
	STATIC_COPY(GLConstants.GL_STATIC_COPY),
	DYNAMIC_DRAW(GLConstants.GL_DYNAMIC_DRAW),
	DYNAMIC_READ(GLConstants.GL_DYNAMIC_READ),
	DYNAMIC_COPY(GLConstants.GL_DYNAMIC_COPY);

	BufferUsage(int token) {
		this.token = token;
	}

	public final int token;

	public static final BufferUsage[] VALUES = values();
	private static Map<Integer, BufferUsage> getMap() {
		Map<Integer, BufferUsage> map = new HashMap<>();
		for(BufferUsage val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, BufferUsage> MAP = Collections.unmodifiableMap(getMap());
	public static BufferUsage get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(BufferUsage... enums) { int i = 0; for(BufferUsage e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(BufferUsage... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}