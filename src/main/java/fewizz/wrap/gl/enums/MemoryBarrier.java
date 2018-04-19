package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum MemoryBarrier {
	ALL_BARRIER_BITS(GLConstants.GL_ALL_BARRIER_BITS),
	ATOMIC_COUNTER_BARRIER_BIT(GLConstants.GL_ATOMIC_COUNTER_BARRIER_BIT),
	BUFFER_UPDATE_BARRIER_BIT(GLConstants.GL_BUFFER_UPDATE_BARRIER_BIT),
	CLIENT_MAPPED_BUFFER_BARRIER_BIT(GLConstants.GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT),
	COMMAND_BARRIER_BIT(GLConstants.GL_COMMAND_BARRIER_BIT),
	ELEMENT_ARRAY_BARRIER_BIT(GLConstants.GL_ELEMENT_ARRAY_BARRIER_BIT),
	FRAMEBUFFER_BARRIER_BIT(GLConstants.GL_FRAMEBUFFER_BARRIER_BIT),
	PIXEL_BUFFER_BARRIER_BIT(GLConstants.GL_PIXEL_BUFFER_BARRIER_BIT),
	QUERY_BUFFER_BARRIER_BIT(GLConstants.GL_QUERY_BUFFER_BARRIER_BIT),
	SHADER_IMAGE_ACCESS_BARRIER_BIT(GLConstants.GL_SHADER_IMAGE_ACCESS_BARRIER_BIT),
	SHADER_STORAGE_BARRIER_BIT(GLConstants.GL_SHADER_STORAGE_BARRIER_BIT),
	TEXTURE_FETCH_BARRIER_BIT(GLConstants.GL_TEXTURE_FETCH_BARRIER_BIT),
	TEXTURE_UPDATE_BARRIER_BIT(GLConstants.GL_TEXTURE_UPDATE_BARRIER_BIT),
	TRANSFORM_FEEDBACK_BARRIER_BIT(GLConstants.GL_TRANSFORM_FEEDBACK_BARRIER_BIT),
	UNIFORM_BARRIER_BIT(GLConstants.GL_UNIFORM_BARRIER_BIT),
	VERTEX_ATTRIB_ARRAY_BARRIER_BIT(GLConstants.GL_VERTEX_ATTRIB_ARRAY_BARRIER_BIT);

	MemoryBarrier(int token) {
		this.token = token;
	}

	public final int token;

	public static final MemoryBarrier[] VALUES = values();
	private static Map<Integer, MemoryBarrier> getMap() {
		Map<Integer, MemoryBarrier> map = new HashMap<>();
		for(MemoryBarrier val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, MemoryBarrier> MAP = Collections.unmodifiableMap(getMap());
	public static MemoryBarrier get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(MemoryBarrier... enums) { int i = 0; for(MemoryBarrier e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(MemoryBarrier... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}