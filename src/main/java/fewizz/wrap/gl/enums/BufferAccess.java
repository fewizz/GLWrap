package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum BufferAccess {
	MAP_COHERENT_BIT(GLConstants.GL_MAP_COHERENT_BIT),
	MAP_FLUSH_EXPLICIT_BIT(GLConstants.GL_MAP_FLUSH_EXPLICIT_BIT),
	MAP_INVALIDATE_BUFFER_BIT(GLConstants.GL_MAP_INVALIDATE_BUFFER_BIT),
	MAP_INVALIDATE_RANGE_BIT(GLConstants.GL_MAP_INVALIDATE_RANGE_BIT),
	MAP_PERSISTENT_BIT(GLConstants.GL_MAP_PERSISTENT_BIT),
	MAP_READ_BIT(GLConstants.GL_MAP_READ_BIT),
	MAP_UNSYNCHRONIZED_BIT(GLConstants.GL_MAP_UNSYNCHRONIZED_BIT),
	MAP_WRITE_BIT(GLConstants.GL_MAP_WRITE_BIT);

	BufferAccess(int token) {
		this.token = token;
	}

	public final int token;

	public static final BufferAccess[] VALUES = values();
	private static Map<Integer, BufferAccess> getMap() {
		Map<Integer, BufferAccess> map = new HashMap<>();
		for(BufferAccess val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, BufferAccess> MAP = Collections.unmodifiableMap(getMap());
	public static BufferAccess get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(BufferAccess... enums) { int i = 0; for(BufferAccess e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(BufferAccess... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}