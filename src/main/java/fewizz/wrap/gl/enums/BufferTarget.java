package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum BufferTarget {
	ARRAY_BUFFER(GLConstants.GL_ARRAY_BUFFER),
	ATOMIC_COUNTER_BUFFER(GLConstants.GL_ATOMIC_COUNTER_BUFFER),
	COPY_READ_BUFFER(GLConstants.GL_COPY_READ_BUFFER),
	COPY_WRITE_BUFFER(GLConstants.GL_COPY_WRITE_BUFFER),
	DISPATCH_INDIRECT_BUFFER(GLConstants.GL_DISPATCH_INDIRECT_BUFFER),
	DRAW_INDIRECT_BUFFER(GLConstants.GL_DRAW_INDIRECT_BUFFER),
	ELEMENT_ARRAY_BUFFER(GLConstants.GL_ELEMENT_ARRAY_BUFFER),
	PIXEL_PACK_BUFFER(GLConstants.GL_PIXEL_PACK_BUFFER),
	PIXEL_UNPACK_BUFFER(GLConstants.GL_PIXEL_UNPACK_BUFFER),
	QUERY_BUFFER(GLConstants.GL_QUERY_BUFFER),
	SHADER_STORAGE_BUFFER(GLConstants.GL_SHADER_STORAGE_BUFFER),
	TEXTURE_BUFFER(GLConstants.GL_TEXTURE_BUFFER),
	TRANSFORM_FEEDBACK_BUFFER(GLConstants.GL_TRANSFORM_FEEDBACK_BUFFER),
	UNIFORM_BUFFER(GLConstants.GL_UNIFORM_BUFFER);

	BufferTarget(int token) {
		this.token = token;
	}

	public final int token;

	public static final BufferTarget[] VALUES = values();
	private static Map<Integer, BufferTarget> getMap() {
		Map<Integer, BufferTarget> map = new HashMap<>();
		for(BufferTarget val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, BufferTarget> MAP = Collections.unmodifiableMap(getMap());
	public static BufferTarget get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(BufferTarget... enums) { int i = 0; for(BufferTarget e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(BufferTarget... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}