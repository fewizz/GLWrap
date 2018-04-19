package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum UniformBlockPName {
	UNIFORM_BLOCK_BINDING(GLConstants.GL_UNIFORM_BLOCK_BINDING),
	UNIFORM_BLOCK_DATA_SIZE(GLConstants.GL_UNIFORM_BLOCK_DATA_SIZE),
	UNIFORM_BLOCK_NAME_LENGTH(GLConstants.GL_UNIFORM_BLOCK_NAME_LENGTH),
	UNIFORM_BLOCK_ACTIVE_UNIFORMS(GLConstants.GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS),
	UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES(GLConstants.GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES),
	UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER(GLConstants.GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER),
	UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER(GLConstants.GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER),
	UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER(GLConstants.GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER),
	UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER(GLConstants.GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER),
	UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER(GLConstants.GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER),
	UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER(GLConstants.GL_UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER);

	UniformBlockPName(int token) {
		this.token = token;
	}

	public final int token;

	public static final UniformBlockPName[] VALUES = values();
	private static Map<Integer, UniformBlockPName> getMap() {
		Map<Integer, UniformBlockPName> map = new HashMap<>();
		for(UniformBlockPName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, UniformBlockPName> MAP = Collections.unmodifiableMap(getMap());
	public static UniformBlockPName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(UniformBlockPName... enums) { int i = 0; for(UniformBlockPName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(UniformBlockPName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}