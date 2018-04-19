package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum ShaderType {
	COMPUTE_SHADER(GLConstants.GL_COMPUTE_SHADER),
	VERTEX_SHADER(GLConstants.GL_VERTEX_SHADER),
	TESS_CONTROL_SHADER(GLConstants.GL_TESS_CONTROL_SHADER),
	TESS_EVALUATION_SHADER(GLConstants.GL_TESS_EVALUATION_SHADER),
	GEOMETRY_SHADER(GLConstants.GL_GEOMETRY_SHADER),
	FRAGMENT_SHADER(GLConstants.GL_FRAGMENT_SHADER);

	ShaderType(int token) {
		this.token = token;
	}

	public final int token;

	public static final ShaderType[] VALUES = values();
	private static Map<Integer, ShaderType> getMap() {
		Map<Integer, ShaderType> map = new HashMap<>();
		for(ShaderType val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ShaderType> MAP = Collections.unmodifiableMap(getMap());
	public static ShaderType get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(ShaderType... enums) { int i = 0; for(ShaderType e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(ShaderType... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}