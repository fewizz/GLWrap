package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum ObjectIdentifier {
	BUFFER(GLConstants.GL_BUFFER),
	SHADER(GLConstants.GL_SHADER),
	PROGRAM(GLConstants.GL_PROGRAM),
	VERTEX_ARRAY(GLConstants.GL_VERTEX_ARRAY),
	QUERY(GLConstants.GL_QUERY),
	PROGRAM_PIPELINE(GLConstants.GL_PROGRAM_PIPELINE),
	TRANSFORM_FEEDBACK(GLConstants.GL_TRANSFORM_FEEDBACK),
	SAMPLER(GLConstants.GL_SAMPLER),
	TEXTURE(GLConstants.GL_TEXTURE),
	RENDERBUFFER(GLConstants.GL_RENDERBUFFER),
	FRAMEBUFFER(GLConstants.GL_FRAMEBUFFER);

	ObjectIdentifier(int token) {
		this.token = token;
	}

	public final int token;

	public static final ObjectIdentifier[] VALUES = values();
	private static Map<Integer, ObjectIdentifier> getMap() {
		Map<Integer, ObjectIdentifier> map = new HashMap<>();
		for(ObjectIdentifier val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ObjectIdentifier> MAP = Collections.unmodifiableMap(getMap());
	public static ObjectIdentifier get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(ObjectIdentifier... enums) { int i = 0; for(ObjectIdentifier e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(ObjectIdentifier... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}