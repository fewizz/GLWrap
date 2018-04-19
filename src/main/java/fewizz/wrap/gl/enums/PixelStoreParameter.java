package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum PixelStoreParameter {
	PACK_ALIGNMENT(GLConstants.GL_PACK_ALIGNMENT),
	PACK_IMAGE_HEIGHT(GLConstants.GL_PACK_IMAGE_HEIGHT),
	PACK_LSB_FIRST(GLConstants.GL_PACK_LSB_FIRST),
	PACK_ROW_LENGTH(GLConstants.GL_PACK_ROW_LENGTH),
	PACK_SKIP_IMAGES(GLConstants.GL_PACK_SKIP_IMAGES),
	PACK_SKIP_PIXELS(GLConstants.GL_PACK_SKIP_PIXELS),
	PACK_SKIP_ROWS(GLConstants.GL_PACK_SKIP_ROWS),
	PACK_SWAP_BYTES(GLConstants.GL_PACK_SWAP_BYTES),
	UNPACK_ALIGNMENT(GLConstants.GL_UNPACK_ALIGNMENT),
	UNPACK_IMAGE_HEIGHT(GLConstants.GL_UNPACK_IMAGE_HEIGHT),
	UNPACK_LSB_FIRST(GLConstants.GL_UNPACK_LSB_FIRST),
	UNPACK_ROW_LENGTH(GLConstants.GL_UNPACK_ROW_LENGTH),
	UNPACK_SKIP_IMAGES(GLConstants.GL_UNPACK_SKIP_IMAGES),
	UNPACK_SKIP_PIXELS(GLConstants.GL_UNPACK_SKIP_PIXELS),
	UNPACK_SKIP_ROWS(GLConstants.GL_UNPACK_SKIP_ROWS),
	UNPACK_SWAP_BYTES(GLConstants.GL_UNPACK_SWAP_BYTES);

	PixelStoreParameter(int token) {
		this.token = token;
	}

	public final int token;

	public static final PixelStoreParameter[] VALUES = values();
	private static Map<Integer, PixelStoreParameter> getMap() {
		Map<Integer, PixelStoreParameter> map = new HashMap<>();
		for(PixelStoreParameter val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, PixelStoreParameter> MAP = Collections.unmodifiableMap(getMap());
	public static PixelStoreParameter get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(PixelStoreParameter... enums) { int i = 0; for(PixelStoreParameter e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(PixelStoreParameter... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}