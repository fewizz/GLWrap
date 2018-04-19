package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum ShaderParameterName {
	SHADER_TYPE(GLConstants.GL_SHADER_TYPE),
	DELETE_STATUS(GLConstants.GL_DELETE_STATUS),
	COMPILE_STATUS(GLConstants.GL_COMPILE_STATUS),
	INFO_LOG_LENGTH(GLConstants.GL_INFO_LOG_LENGTH),
	SHADER_SOURCE_LENGTH(GLConstants.GL_SHADER_SOURCE_LENGTH);

	ShaderParameterName(int token) {
		this.token = token;
	}

	public final int token;

	public static final ShaderParameterName[] VALUES = values();
	private static Map<Integer, ShaderParameterName> getMap() {
		Map<Integer, ShaderParameterName> map = new HashMap<>();
		for(ShaderParameterName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ShaderParameterName> MAP = Collections.unmodifiableMap(getMap());
	public static ShaderParameterName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(ShaderParameterName... enums) { int i = 0; for(ShaderParameterName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(ShaderParameterName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}