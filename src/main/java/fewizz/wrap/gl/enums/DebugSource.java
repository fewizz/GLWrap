package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum DebugSource {
	DEBUG_SOURCE_API(GLConstants.GL_DEBUG_SOURCE_API),
	DEBUG_SOURCE_WINDOW_SYSTEM(GLConstants.GL_DEBUG_SOURCE_WINDOW_SYSTEM),
	DEBUG_SOURCE_SHADER_COMPILER(GLConstants.GL_DEBUG_SOURCE_SHADER_COMPILER),
	DEBUG_SOURCE_THIRD_PARTY(GLConstants.GL_DEBUG_SOURCE_THIRD_PARTY),
	DEBUG_SOURCE_APPLICATION(GLConstants.GL_DEBUG_SOURCE_APPLICATION),
	DEBUG_SOURCE_OTHER(GLConstants.GL_DEBUG_SOURCE_OTHER),
	DONT_CARE(GLConstants.GL_DONT_CARE);

	DebugSource(int token) {
		this.token = token;
	}

	public final int token;

	public static final DebugSource[] VALUES = values();
	private static Map<Integer, DebugSource> getMap() {
		Map<Integer, DebugSource> map = new HashMap<>();
		for(DebugSource val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, DebugSource> MAP = Collections.unmodifiableMap(getMap());
	public static DebugSource get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(DebugSource... enums) { int i = 0; for(DebugSource e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(DebugSource... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}