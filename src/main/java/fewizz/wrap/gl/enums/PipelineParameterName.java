package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum PipelineParameterName {
	ACTIVE_PROGRAM(GLConstants.GL_ACTIVE_PROGRAM),
	VERTEX_SHADER(GLConstants.GL_VERTEX_SHADER),
	TESS_CONTROL_SHADER(GLConstants.GL_TESS_CONTROL_SHADER),
	TESS_EVALUATION_SHADER(GLConstants.GL_TESS_EVALUATION_SHADER),
	GEOMETRY_SHADER(GLConstants.GL_GEOMETRY_SHADER),
	FRAGMENT_SHADER(GLConstants.GL_FRAGMENT_SHADER),
	INFO_LOG_LENGTH(GLConstants.GL_INFO_LOG_LENGTH);

	PipelineParameterName(int token) {
		this.token = token;
	}

	public final int token;

	public static final PipelineParameterName[] VALUES = values();
	private static Map<Integer, PipelineParameterName> getMap() {
		Map<Integer, PipelineParameterName> map = new HashMap<>();
		for(PipelineParameterName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, PipelineParameterName> MAP = Collections.unmodifiableMap(getMap());
	public static PipelineParameterName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(PipelineParameterName... enums) { int i = 0; for(PipelineParameterName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(PipelineParameterName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}