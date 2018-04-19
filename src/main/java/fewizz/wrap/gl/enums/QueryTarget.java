package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum QueryTarget {
	SAMPLES_PASSED(GLConstants.GL_SAMPLES_PASSED),
	ANY_SAMPLES_PASSED(GLConstants.GL_ANY_SAMPLES_PASSED),
	ANY_SAMPLES_PASSED_CONSERVATIVE(GLConstants.GL_ANY_SAMPLES_PASSED_CONSERVATIVE),
	PRIMITIVES_GENERATED(GLConstants.GL_PRIMITIVES_GENERATED),
	TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN(GLConstants.GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN),
	TIME_ELAPSED(GLConstants.GL_TIME_ELAPSED);

	QueryTarget(int token) {
		this.token = token;
	}

	public final int token;

	public static final QueryTarget[] VALUES = values();
	private static Map<Integer, QueryTarget> getMap() {
		Map<Integer, QueryTarget> map = new HashMap<>();
		for(QueryTarget val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, QueryTarget> MAP = Collections.unmodifiableMap(getMap());
	public static QueryTarget get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(QueryTarget... enums) { int i = 0; for(QueryTarget e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(QueryTarget... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}