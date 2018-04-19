package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum VertexArrayPName {
	VERTEX_ATTRIB_ARRAY_ENABLED(GLConstants.GL_VERTEX_ATTRIB_ARRAY_ENABLED),
	VERTEX_ATTRIB_ARRAY_SIZE(GLConstants.GL_VERTEX_ATTRIB_ARRAY_SIZE),
	VERTEX_ATTRIB_ARRAY_STRIDE(GLConstants.GL_VERTEX_ATTRIB_ARRAY_STRIDE),
	VERTEX_ATTRIB_ARRAY_TYPE(GLConstants.GL_VERTEX_ATTRIB_ARRAY_TYPE),
	VERTEX_ATTRIB_ARRAY_NORMALIZED(GLConstants.GL_VERTEX_ATTRIB_ARRAY_NORMALIZED),
	VERTEX_ATTRIB_ARRAY_INTEGER(GLConstants.GL_VERTEX_ATTRIB_ARRAY_INTEGER),
	VERTEX_ATTRIB_ARRAY_LONG(GLConstants.GL_VERTEX_ATTRIB_ARRAY_LONG),
	VERTEX_ATTRIB_ARRAY_DIVISOR(GLConstants.GL_VERTEX_ATTRIB_ARRAY_DIVISOR),
	VERTEX_ATTRIB_RELATIVE_OFFSET(GLConstants.GL_VERTEX_ATTRIB_RELATIVE_OFFSET);

	VertexArrayPName(int token) {
		this.token = token;
	}

	public final int token;

	public static final VertexArrayPName[] VALUES = values();
	private static Map<Integer, VertexArrayPName> getMap() {
		Map<Integer, VertexArrayPName> map = new HashMap<>();
		for(VertexArrayPName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, VertexArrayPName> MAP = Collections.unmodifiableMap(getMap());
	public static VertexArrayPName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(VertexArrayPName... enums) { int i = 0; for(VertexArrayPName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(VertexArrayPName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}