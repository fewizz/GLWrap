package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum UniformPName {
	UNIFORM_TYPE(GLConstants.GL_UNIFORM_TYPE),
	UNIFORM_SIZE(GLConstants.GL_UNIFORM_SIZE),
	UNIFORM_NAME_LENGTH(GLConstants.GL_UNIFORM_NAME_LENGTH),
	UNIFORM_BLOCK_INDEX(GLConstants.GL_UNIFORM_BLOCK_INDEX),
	UNIFORM_OFFSET(GLConstants.GL_UNIFORM_OFFSET),
	UNIFORM_ARRAY_STRIDE(GLConstants.GL_UNIFORM_ARRAY_STRIDE),
	UNIFORM_MATRIX_STRIDE(GLConstants.GL_UNIFORM_MATRIX_STRIDE),
	UNIFORM_IS_ROW_MAJOR(GLConstants.GL_UNIFORM_IS_ROW_MAJOR),
	UNIFORM_ATOMIC_COUNTER_BUFFER_INDEX(GLConstants.GL_UNIFORM_ATOMIC_COUNTER_BUFFER_INDEX);

	UniformPName(int token) {
		this.token = token;
	}

	public final int token;

	public static final UniformPName[] VALUES = values();
	private static Map<Integer, UniformPName> getMap() {
		Map<Integer, UniformPName> map = new HashMap<>();
		for(UniformPName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, UniformPName> MAP = Collections.unmodifiableMap(getMap());
	public static UniformPName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(UniformPName... enums) { int i = 0; for(UniformPName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(UniformPName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}