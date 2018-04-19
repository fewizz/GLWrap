package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum UseProgramStage {
	VERTEX_SHADER_BIT(GLConstants.GL_VERTEX_SHADER_BIT),
	FRAGMENT_SHADER_BIT(GLConstants.GL_FRAGMENT_SHADER_BIT),
	GEOMETRY_SHADER_BIT(GLConstants.GL_GEOMETRY_SHADER_BIT),
	TESS_CONTROL_SHADER_BIT(GLConstants.GL_TESS_CONTROL_SHADER_BIT),
	TESS_EVALUATION_SHADER_BIT(GLConstants.GL_TESS_EVALUATION_SHADER_BIT),
	COMPUTE_SHADER_BIT(GLConstants.GL_COMPUTE_SHADER_BIT),
	ALL_SHADER_BITS(GLConstants.GL_ALL_SHADER_BITS);

	UseProgramStage(int token) {
		this.token = token;
	}

	public final int token;

	public static final UseProgramStage[] VALUES = values();
	private static Map<Integer, UseProgramStage> getMap() {
		Map<Integer, UseProgramStage> map = new HashMap<>();
		for(UseProgramStage val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, UseProgramStage> MAP = Collections.unmodifiableMap(getMap());
	public static UseProgramStage get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(UseProgramStage... enums) { int i = 0; for(UseProgramStage e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(UseProgramStage... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}