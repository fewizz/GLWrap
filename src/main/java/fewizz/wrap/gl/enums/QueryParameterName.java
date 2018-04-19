package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum QueryParameterName {
	CURRENT_QUERY(GLConstants.GL_CURRENT_QUERY),
	QUERY_COUNTER_BITS(GLConstants.GL_QUERY_COUNTER_BITS);

	QueryParameterName(int token) {
		this.token = token;
	}

	public final int token;

	public static final QueryParameterName[] VALUES = values();
	private static Map<Integer, QueryParameterName> getMap() {
		Map<Integer, QueryParameterName> map = new HashMap<>();
		for(QueryParameterName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, QueryParameterName> MAP = Collections.unmodifiableMap(getMap());
	public static QueryParameterName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(QueryParameterName... enums) { int i = 0; for(QueryParameterName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(QueryParameterName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}