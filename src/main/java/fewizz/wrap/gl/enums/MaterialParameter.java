package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum MaterialParameter {
	AMBIENT(GLConstants.GL_AMBIENT),
	AMBIENT_AND_DIFFUSE(GLConstants.GL_AMBIENT_AND_DIFFUSE),
	DIFFUSE(GLConstants.GL_DIFFUSE),
	EMISSION(GLConstants.GL_EMISSION),
	SHININESS(GLConstants.GL_SHININESS),
	SPECULAR(GLConstants.GL_SPECULAR);

	MaterialParameter(int token) {
		this.token = token;
	}

	public final int token;

	public static final MaterialParameter[] VALUES = values();
	private static Map<Integer, MaterialParameter> getMap() {
		Map<Integer, MaterialParameter> map = new HashMap<>();
		for(MaterialParameter val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, MaterialParameter> MAP = Collections.unmodifiableMap(getMap());
	public static MaterialParameter get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(MaterialParameter... enums) { int i = 0; for(MaterialParameter e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(MaterialParameter... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}