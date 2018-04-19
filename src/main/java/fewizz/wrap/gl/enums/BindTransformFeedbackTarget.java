package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum BindTransformFeedbackTarget {
	TRANSFORM_FEEDBACK(GLConstants.GL_TRANSFORM_FEEDBACK);

	BindTransformFeedbackTarget(int token) {
		this.token = token;
	}

	public final int token;

	public static final BindTransformFeedbackTarget[] VALUES = values();
	private static Map<Integer, BindTransformFeedbackTarget> getMap() {
		Map<Integer, BindTransformFeedbackTarget> map = new HashMap<>();
		for(BindTransformFeedbackTarget val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, BindTransformFeedbackTarget> MAP = Collections.unmodifiableMap(getMap());
	public static BindTransformFeedbackTarget get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(BindTransformFeedbackTarget... enums) { int i = 0; for(BindTransformFeedbackTarget e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(BindTransformFeedbackTarget... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}