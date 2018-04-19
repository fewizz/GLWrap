package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum ClipPlaneName {
	CLIP_DISTANCE0(GLConstants.GL_CLIP_DISTANCE0),
	CLIP_DISTANCE1(GLConstants.GL_CLIP_DISTANCE1),
	CLIP_DISTANCE2(GLConstants.GL_CLIP_DISTANCE2),
	CLIP_DISTANCE3(GLConstants.GL_CLIP_DISTANCE3),
	CLIP_DISTANCE4(GLConstants.GL_CLIP_DISTANCE4),
	CLIP_DISTANCE5(GLConstants.GL_CLIP_DISTANCE5),
	CLIP_DISTANCE6(GLConstants.GL_CLIP_DISTANCE6),
	CLIP_DISTANCE7(GLConstants.GL_CLIP_DISTANCE7),
	CLIP_PLANE0(GLConstants.GL_CLIP_PLANE0),
	CLIP_PLANE1(GLConstants.GL_CLIP_PLANE1),
	CLIP_PLANE2(GLConstants.GL_CLIP_PLANE2),
	CLIP_PLANE3(GLConstants.GL_CLIP_PLANE3),
	CLIP_PLANE4(GLConstants.GL_CLIP_PLANE4),
	CLIP_PLANE5(GLConstants.GL_CLIP_PLANE5);

	ClipPlaneName(int token) {
		this.token = token;
	}

	public final int token;

	public static final ClipPlaneName[] VALUES = values();
	private static Map<Integer, ClipPlaneName> getMap() {
		Map<Integer, ClipPlaneName> map = new HashMap<>();
		for(ClipPlaneName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ClipPlaneName> MAP = Collections.unmodifiableMap(getMap());
	public static ClipPlaneName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(ClipPlaneName... enums) { int i = 0; for(ClipPlaneName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(ClipPlaneName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}