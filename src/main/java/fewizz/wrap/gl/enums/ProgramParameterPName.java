package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum ProgramParameterPName {
	PROGRAM_BINARY_RETRIEVABLE_HINT(GLConstants.GL_PROGRAM_BINARY_RETRIEVABLE_HINT),
	PROGRAM_SEPARABLE(GLConstants.GL_PROGRAM_SEPARABLE);

	ProgramParameterPName(int token) {
		this.token = token;
	}

	public final int token;

	public static final ProgramParameterPName[] VALUES = values();
	private static Map<Integer, ProgramParameterPName> getMap() {
		Map<Integer, ProgramParameterPName> map = new HashMap<>();
		for(ProgramParameterPName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ProgramParameterPName> MAP = Collections.unmodifiableMap(getMap());
	public static ProgramParameterPName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(ProgramParameterPName... enums) { int i = 0; for(ProgramParameterPName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(ProgramParameterPName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}