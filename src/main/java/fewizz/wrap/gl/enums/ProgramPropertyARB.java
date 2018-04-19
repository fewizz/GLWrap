package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum ProgramPropertyARB {
	DELETE_STATUS(GLConstants.GL_DELETE_STATUS),
	LINK_STATUS(GLConstants.GL_LINK_STATUS),
	VALIDATE_STATUS(GLConstants.GL_VALIDATE_STATUS),
	INFO_LOG_LENGTH(GLConstants.GL_INFO_LOG_LENGTH),
	ATTACHED_SHADERS(GLConstants.GL_ATTACHED_SHADERS),
	ACTIVE_ATOMIC_COUNTER_BUFFERS(GLConstants.GL_ACTIVE_ATOMIC_COUNTER_BUFFERS),
	ACTIVE_ATTRIBUTES(GLConstants.GL_ACTIVE_ATTRIBUTES),
	ACTIVE_ATTRIBUTE_MAX_LENGTH(GLConstants.GL_ACTIVE_ATTRIBUTE_MAX_LENGTH),
	ACTIVE_UNIFORMS(GLConstants.GL_ACTIVE_UNIFORMS),
	ACTIVE_UNIFORM_BLOCKS(GLConstants.GL_ACTIVE_UNIFORM_BLOCKS),
	ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH(GLConstants.GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH),
	ACTIVE_UNIFORM_MAX_LENGTH(GLConstants.GL_ACTIVE_UNIFORM_MAX_LENGTH),
	COMPUTE_WORK_GROUP_SIZE(GLConstants.GL_COMPUTE_WORK_GROUP_SIZE),
	PROGRAM_BINARY_LENGTH(GLConstants.GL_PROGRAM_BINARY_LENGTH),
	TRANSFORM_FEEDBACK_BUFFER_MODE(GLConstants.GL_TRANSFORM_FEEDBACK_BUFFER_MODE),
	TRANSFORM_FEEDBACK_VARYINGS(GLConstants.GL_TRANSFORM_FEEDBACK_VARYINGS),
	TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH(GLConstants.GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH),
	GEOMETRY_VERTICES_OUT(GLConstants.GL_GEOMETRY_VERTICES_OUT),
	GEOMETRY_INPUT_TYPE(GLConstants.GL_GEOMETRY_INPUT_TYPE),
	GEOMETRY_OUTPUT_TYPE(GLConstants.GL_GEOMETRY_OUTPUT_TYPE);

	ProgramPropertyARB(int token) {
		this.token = token;
	}

	public final int token;

	public static final ProgramPropertyARB[] VALUES = values();
	private static Map<Integer, ProgramPropertyARB> getMap() {
		Map<Integer, ProgramPropertyARB> map = new HashMap<>();
		for(ProgramPropertyARB val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ProgramPropertyARB> MAP = Collections.unmodifiableMap(getMap());
	public static ProgramPropertyARB get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(ProgramPropertyARB... enums) { int i = 0; for(ProgramPropertyARB e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(ProgramPropertyARB... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}