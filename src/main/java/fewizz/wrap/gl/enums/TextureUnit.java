package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum TextureUnit {
	TEXTURE0(GLConstants.GL_TEXTURE0),
	TEXTURE1(GLConstants.GL_TEXTURE1),
	TEXTURE2(GLConstants.GL_TEXTURE2),
	TEXTURE3(GLConstants.GL_TEXTURE3),
	TEXTURE4(GLConstants.GL_TEXTURE4),
	TEXTURE5(GLConstants.GL_TEXTURE5),
	TEXTURE6(GLConstants.GL_TEXTURE6),
	TEXTURE7(GLConstants.GL_TEXTURE7),
	TEXTURE8(GLConstants.GL_TEXTURE8),
	TEXTURE9(GLConstants.GL_TEXTURE9),
	TEXTURE10(GLConstants.GL_TEXTURE10),
	TEXTURE11(GLConstants.GL_TEXTURE11),
	TEXTURE12(GLConstants.GL_TEXTURE12),
	TEXTURE13(GLConstants.GL_TEXTURE13),
	TEXTURE14(GLConstants.GL_TEXTURE14),
	TEXTURE15(GLConstants.GL_TEXTURE15),
	TEXTURE16(GLConstants.GL_TEXTURE16),
	TEXTURE17(GLConstants.GL_TEXTURE17),
	TEXTURE18(GLConstants.GL_TEXTURE18),
	TEXTURE19(GLConstants.GL_TEXTURE19),
	TEXTURE20(GLConstants.GL_TEXTURE20),
	TEXTURE21(GLConstants.GL_TEXTURE21),
	TEXTURE22(GLConstants.GL_TEXTURE22),
	TEXTURE23(GLConstants.GL_TEXTURE23),
	TEXTURE24(GLConstants.GL_TEXTURE24),
	TEXTURE25(GLConstants.GL_TEXTURE25),
	TEXTURE26(GLConstants.GL_TEXTURE26),
	TEXTURE27(GLConstants.GL_TEXTURE27),
	TEXTURE28(GLConstants.GL_TEXTURE28),
	TEXTURE29(GLConstants.GL_TEXTURE29),
	TEXTURE30(GLConstants.GL_TEXTURE30),
	TEXTURE31(GLConstants.GL_TEXTURE31);

	TextureUnit(int token) {
		this.token = token;
	}

	public final int token;

	public static final TextureUnit[] VALUES = values();
	private static Map<Integer, TextureUnit> getMap() {
		Map<Integer, TextureUnit> map = new HashMap<>();
		for(TextureUnit val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, TextureUnit> MAP = Collections.unmodifiableMap(getMap());
	public static TextureUnit get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(TextureUnit... enums) { int i = 0; for(TextureUnit e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(TextureUnit... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}