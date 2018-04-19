package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum ProgramInterface {
	UNIFORM(GLConstants.GL_UNIFORM),
	UNIFORM_BLOCK(GLConstants.GL_UNIFORM_BLOCK),
	PROGRAM_INPUT(GLConstants.GL_PROGRAM_INPUT),
	PROGRAM_OUTPUT(GLConstants.GL_PROGRAM_OUTPUT),
	VERTEX_SUBROUTINE(GLConstants.GL_VERTEX_SUBROUTINE),
	TESS_CONTROL_SUBROUTINE(GLConstants.GL_TESS_CONTROL_SUBROUTINE),
	TESS_EVALUATION_SUBROUTINE(GLConstants.GL_TESS_EVALUATION_SUBROUTINE),
	GEOMETRY_SUBROUTINE(GLConstants.GL_GEOMETRY_SUBROUTINE),
	FRAGMENT_SUBROUTINE(GLConstants.GL_FRAGMENT_SUBROUTINE),
	COMPUTE_SUBROUTINE(GLConstants.GL_COMPUTE_SUBROUTINE),
	VERTEX_SUBROUTINE_UNIFORM(GLConstants.GL_VERTEX_SUBROUTINE_UNIFORM),
	TESS_CONTROL_SUBROUTINE_UNIFORM(GLConstants.GL_TESS_CONTROL_SUBROUTINE_UNIFORM),
	TESS_EVALUATION_SUBROUTINE_UNIFORM(GLConstants.GL_TESS_EVALUATION_SUBROUTINE_UNIFORM),
	GEOMETRY_SUBROUTINE_UNIFORM(GLConstants.GL_GEOMETRY_SUBROUTINE_UNIFORM),
	FRAGMENT_SUBROUTINE_UNIFORM(GLConstants.GL_FRAGMENT_SUBROUTINE_UNIFORM),
	COMPUTE_SUBROUTINE_UNIFORM(GLConstants.GL_COMPUTE_SUBROUTINE_UNIFORM),
	TRANSFORM_FEEDBACK_VARYING(GLConstants.GL_TRANSFORM_FEEDBACK_VARYING),
	TRANSFORM_FEEDBACK_BUFFER(GLConstants.GL_TRANSFORM_FEEDBACK_BUFFER),
	BUFFER_VARIABLE(GLConstants.GL_BUFFER_VARIABLE),
	SHADER_STORAGE_BLOCK(GLConstants.GL_SHADER_STORAGE_BLOCK);

	ProgramInterface(int token) {
		this.token = token;
	}

	public final int token;

	public static final ProgramInterface[] VALUES = values();
	private static Map<Integer, ProgramInterface> getMap() {
		Map<Integer, ProgramInterface> map = new HashMap<>();
		for(ProgramInterface val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ProgramInterface> MAP = Collections.unmodifiableMap(getMap());
	public static ProgramInterface get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(ProgramInterface... enums) { int i = 0; for(ProgramInterface e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(ProgramInterface... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}