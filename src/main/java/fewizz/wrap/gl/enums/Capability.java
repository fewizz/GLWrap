package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum Capability {
	ALPHA_TEST(GLConstants.GL_ALPHA_TEST),
	BLEND(GLConstants.GL_BLEND),
	CLIP_PLANE0(GLConstants.GL_CLIP_PLANE0),
	CLIP_PLANE1(GLConstants.GL_CLIP_PLANE1),
	CLIP_PLANE2(GLConstants.GL_CLIP_PLANE2),
	CLIP_PLANE3(GLConstants.GL_CLIP_PLANE3),
	CLIP_PLANE4(GLConstants.GL_CLIP_PLANE4),
	CLIP_PLANE5(GLConstants.GL_CLIP_PLANE5),
	COLOR_ARRAY(GLConstants.GL_COLOR_ARRAY),
	COLOR_LOGIC_OP(GLConstants.GL_COLOR_LOGIC_OP),
	COLOR_MATERIAL(GLConstants.GL_COLOR_MATERIAL),
	CULL_FACE(GLConstants.GL_CULL_FACE),
	DEPTH_TEST(GLConstants.GL_DEPTH_TEST),
	DITHER(GLConstants.GL_DITHER),
	FOG(GLConstants.GL_FOG),
	LIGHT0(GLConstants.GL_LIGHT0),
	LIGHT1(GLConstants.GL_LIGHT1),
	LIGHT2(GLConstants.GL_LIGHT2),
	LIGHT3(GLConstants.GL_LIGHT3),
	LIGHT4(GLConstants.GL_LIGHT4),
	LIGHT5(GLConstants.GL_LIGHT5),
	LIGHT6(GLConstants.GL_LIGHT6),
	LIGHT7(GLConstants.GL_LIGHT7),
	LIGHTING(GLConstants.GL_LIGHTING),
	LINE_SMOOTH(GLConstants.GL_LINE_SMOOTH),
	NORMALIZE(GLConstants.GL_NORMALIZE),
	NORMAL_ARRAY(GLConstants.GL_NORMAL_ARRAY),
	POINT_SMOOTH(GLConstants.GL_POINT_SMOOTH),
	POLYGON_OFFSET_FILL(GLConstants.GL_POLYGON_OFFSET_FILL),
	POLYGON_OFFSET_LINE(GLConstants.GL_POLYGON_OFFSET_LINE),
	POLYGON_OFFSET_POINT(GLConstants.GL_POLYGON_OFFSET_POINT),
	POLYGON_SMOOTH(GLConstants.GL_POLYGON_SMOOTH),
	SCISSOR_TEST(GLConstants.GL_SCISSOR_TEST),
	STENCIL_TEST(GLConstants.GL_STENCIL_TEST),
	TEXTURE_1D(GLConstants.GL_TEXTURE_1D),
	TEXTURE_2D(GLConstants.GL_TEXTURE_2D),
	TEXTURE_COORD_ARRAY(GLConstants.GL_TEXTURE_COORD_ARRAY),
	VERTEX_ARRAY(GLConstants.GL_VERTEX_ARRAY);

	Capability(int token) {
		this.token = token;
	}

	public final int token;

	public static final Capability[] VALUES = values();
	private static Map<Integer, Capability> getMap() {
		Map<Integer, Capability> map = new HashMap<>();
		for(Capability val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, Capability> MAP = Collections.unmodifiableMap(getMap());
	public static Capability get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(Capability... enums) { int i = 0; for(Capability e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(Capability... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}