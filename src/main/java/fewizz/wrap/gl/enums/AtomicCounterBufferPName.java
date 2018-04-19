package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum AtomicCounterBufferPName {
	ATOMIC_COUNTER_BUFFER_BINDING(GLConstants.GL_ATOMIC_COUNTER_BUFFER_BINDING),
	ATOMIC_COUNTER_BUFFER_DATA_SIZE(GLConstants.GL_ATOMIC_COUNTER_BUFFER_DATA_SIZE),
	ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTERS(GLConstants.GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTERS),
	ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTER_INDICES(GLConstants.GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTER_INDICES),
	ATOMIC_COUNTER_BUFFER_REFERENCED_BY_VERTEX_SHADER(GLConstants.GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_VERTEX_SHADER),
	ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_CONTROL_SHADER(GLConstants.GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_CONTROL_SHADER),
	ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_EVALUATION_SHADER(GLConstants.GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_EVALUATION_SHADER),
	ATOMIC_COUNTER_BUFFER_REFERENCED_BY_GEOMETRY_SHADER(GLConstants.GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_GEOMETRY_SHADER),
	ATOMIC_COUNTER_BUFFER_REFERENCED_BY_FRAGMENT_SHADER(GLConstants.GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_FRAGMENT_SHADER),
	ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER(GLConstants.GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER);

	AtomicCounterBufferPName(int token) {
		this.token = token;
	}

	public final int token;

	public static final AtomicCounterBufferPName[] VALUES = values();
	private static Map<Integer, AtomicCounterBufferPName> getMap() {
		Map<Integer, AtomicCounterBufferPName> map = new HashMap<>();
		for(AtomicCounterBufferPName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, AtomicCounterBufferPName> MAP = Collections.unmodifiableMap(getMap());
	public static AtomicCounterBufferPName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(AtomicCounterBufferPName... enums) { int i = 0; for(AtomicCounterBufferPName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(AtomicCounterBufferPName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}