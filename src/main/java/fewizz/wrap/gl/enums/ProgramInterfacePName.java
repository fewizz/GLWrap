package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum ProgramInterfacePName {
	ACTIVE_RESOURCES(GLConstants.GL_ACTIVE_RESOURCES),
	MAX_NAME_LENGTH(GLConstants.GL_MAX_NAME_LENGTH),
	MAX_NUM_ACTIVE_VARIABLES(GLConstants.GL_MAX_NUM_ACTIVE_VARIABLES),
	MAX_NUM_COMPATIBLE_SUBROUTINES(GLConstants.GL_MAX_NUM_COMPATIBLE_SUBROUTINES);

	ProgramInterfacePName(int token) {
		this.token = token;
	}

	public final int token;

	public static final ProgramInterfacePName[] VALUES = values();
	private static Map<Integer, ProgramInterfacePName> getMap() {
		Map<Integer, ProgramInterfacePName> map = new HashMap<>();
		for(ProgramInterfacePName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ProgramInterfacePName> MAP = Collections.unmodifiableMap(getMap());
	public static ProgramInterfacePName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(ProgramInterfacePName... enums) { int i = 0; for(ProgramInterfacePName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(ProgramInterfacePName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}