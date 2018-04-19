package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum DebugType {
	DEBUG_TYPE_ERROR(GLConstants.GL_DEBUG_TYPE_ERROR),
	DEBUG_TYPE_DEPRECATED_BEHAVIOR(GLConstants.GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR),
	DEBUG_TYPE_UNDEFINED_BEHAVIOR(GLConstants.GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR),
	DEBUG_TYPE_PORTABILITY(GLConstants.GL_DEBUG_TYPE_PORTABILITY),
	DEBUG_TYPE_PERFORMANCE(GLConstants.GL_DEBUG_TYPE_PERFORMANCE),
	DEBUG_TYPE_MARKER(GLConstants.GL_DEBUG_TYPE_MARKER),
	DEBUG_TYPE_PUSH_GROUP(GLConstants.GL_DEBUG_TYPE_PUSH_GROUP),
	DEBUG_TYPE_POP_GROUP(GLConstants.GL_DEBUG_TYPE_POP_GROUP),
	DEBUG_TYPE_OTHER(GLConstants.GL_DEBUG_TYPE_OTHER),
	DONT_CARE(GLConstants.GL_DONT_CARE);

	DebugType(int token) {
		this.token = token;
	}

	public final int token;

	public static final DebugType[] VALUES = values();
	private static Map<Integer, DebugType> getMap() {
		Map<Integer, DebugType> map = new HashMap<>();
		for(DebugType val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, DebugType> MAP = Collections.unmodifiableMap(getMap());
	public static DebugType get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(DebugType... enums) { int i = 0; for(DebugType e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(DebugType... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}