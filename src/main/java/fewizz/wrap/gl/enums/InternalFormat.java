package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum InternalFormat {
	RED(GLConstants.GL_RED),
	R8(GLConstants.GL_R8),
	R8_SNORM(GLConstants.GL_R8_SNORM),
	R16(GLConstants.GL_R16),
	R16_SNORM(GLConstants.GL_R16_SNORM),
	R16F(GLConstants.GL_R16F),
	R32F(GLConstants.GL_R32F),
	R8I(GLConstants.GL_R8I),
	R16I(GLConstants.GL_R16I),
	R32I(GLConstants.GL_R32I),
	R8UI(GLConstants.GL_R8UI),
	R16UI(GLConstants.GL_R16UI),
	R32UI(GLConstants.GL_R32UI),
	RG(GLConstants.GL_RG),
	RG8(GLConstants.GL_RG8),
	RG8_SNORM(GLConstants.GL_RG8_SNORM),
	RG16(GLConstants.GL_RG16),
	RG16_SNORM(GLConstants.GL_RG16_SNORM),
	RG16F(GLConstants.GL_RG16F),
	RG32F(GLConstants.GL_RG32F),
	RG8I(GLConstants.GL_RG8I),
	RG16I(GLConstants.GL_RG16I),
	RG32I(GLConstants.GL_RG32I),
	RG8UI(GLConstants.GL_RG8UI),
	RG16UI(GLConstants.GL_RG16UI),
	RG32UI(GLConstants.GL_RG32UI),
	RGB(GLConstants.GL_RGB),
	RGB4(GLConstants.GL_RGB4),
	RGB5(GLConstants.GL_RGB5),
	RGB8(GLConstants.GL_RGB8),
	RGB8_SNORM(GLConstants.GL_RGB8_SNORM),
	RGB10(GLConstants.GL_RGB10),
	RGB12(GLConstants.GL_RGB12),
	RGB16(GLConstants.GL_RGB16),
	RGB16F(GLConstants.GL_RGB16F),
	RGB16_SNORM(GLConstants.GL_RGB16_SNORM),
	RGB8I(GLConstants.GL_RGB8I),
	RGB16I(GLConstants.GL_RGB16I),
	RGB32I(GLConstants.GL_RGB32I),
	RGB8UI(GLConstants.GL_RGB8UI),
	RGB16UI(GLConstants.GL_RGB16UI),
	RGB32UI(GLConstants.GL_RGB32UI),
	SRGB(GLConstants.GL_SRGB),
	SRGB_ALPHA(GLConstants.GL_SRGB_ALPHA),
	SRGB8(GLConstants.GL_SRGB8),
	SRGB8_ALPHA8(GLConstants.GL_SRGB8_ALPHA8),
	R3_G3_B2(GLConstants.GL_R3_G3_B2),
	R11F_G11F_B10F(GLConstants.GL_R11F_G11F_B10F),
	RGB9_E5(GLConstants.GL_RGB9_E5),
	RGBA(GLConstants.GL_RGBA),
	RGBA4(GLConstants.GL_RGBA4),
	RGB5_A1(GLConstants.GL_RGB5_A1),
	RGBA8(GLConstants.GL_RGBA8),
	RGBA8_SNORM(GLConstants.GL_RGBA8_SNORM),
	RGB10_A2(GLConstants.GL_RGB10_A2),
	RGBA12(GLConstants.GL_RGBA12),
	RGBA16(GLConstants.GL_RGBA16),
	RGBA16F(GLConstants.GL_RGBA16F),
	RGBA32F(GLConstants.GL_RGBA32F),
	RGBA8I(GLConstants.GL_RGBA8I),
	RGBA16I(GLConstants.GL_RGBA16I),
	RGBA32I(GLConstants.GL_RGBA32I),
	RGBA8UI(GLConstants.GL_RGBA8UI),
	RGBA16UI(GLConstants.GL_RGBA16UI),
	RGBA32UI(GLConstants.GL_RGBA32UI),
	RGB10_A2UI(GLConstants.GL_RGB10_A2UI),
	DEPTH_COMPONENT(GLConstants.GL_DEPTH_COMPONENT),
	DEPTH_COMPONENT16(GLConstants.GL_DEPTH_COMPONENT16),
	DEPTH_COMPONENT32F(GLConstants.GL_DEPTH_COMPONENT32F),
	DEPTH_STENCIL(GLConstants.GL_DEPTH_STENCIL),
	DEPTH24_STENCIL8(GLConstants.GL_DEPTH24_STENCIL8),
	DEPTH32F_STENCIL8(GLConstants.GL_DEPTH32F_STENCIL8),
	COMPRESSED_RED(GLConstants.GL_COMPRESSED_RED),
	COMPRESSED_RG(GLConstants.GL_COMPRESSED_RG),
	COMPRESSED_RGB(GLConstants.GL_COMPRESSED_RGB),
	COMPRESSED_RGBA(GLConstants.GL_COMPRESSED_RGBA),
	COMPRESSED_SRGB(GLConstants.GL_COMPRESSED_SRGB),
	COMPRESSED_SRGB_ALPHA(GLConstants.GL_COMPRESSED_SRGB_ALPHA),
	COMPRESSED_RED_RGTC1(GLConstants.GL_COMPRESSED_RED_RGTC1),
	COMPRESSED_SIGNED_RED_RGTC1(GLConstants.GL_COMPRESSED_SIGNED_RED_RGTC1),
	COMPRESSED_R11_EAC(GLConstants.GL_COMPRESSED_R11_EAC),
	COMPRESSED_SIGNED_R11_EAC(GLConstants.GL_COMPRESSED_SIGNED_R11_EAC),
	COMPRESSED_RG_RGTC2(GLConstants.GL_COMPRESSED_RG_RGTC2),
	COMPRESSED_SIGNED_RG_RGTC2(GLConstants.GL_COMPRESSED_SIGNED_RG_RGTC2),
	COMPRESSED_RGBA_BPTC_UNORM(GLConstants.GL_COMPRESSED_RGBA_BPTC_UNORM),
	COMPRESSED_SRGB_ALPHA_BPTC_UNORM(GLConstants.GL_COMPRESSED_SRGB_ALPHA_BPTC_UNORM),
	COMPRESSED_RGB_BPTC_SIGNED_FLOAT(GLConstants.GL_COMPRESSED_RGB_BPTC_SIGNED_FLOAT),
	COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT(GLConstants.GL_COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT),
	COMPRESSED_RGB8_ETC2(GLConstants.GL_COMPRESSED_RGB8_ETC2),
	COMPRESSED_SRGB8_ETC2(GLConstants.GL_COMPRESSED_SRGB8_ETC2),
	COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2(GLConstants.GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2),
	COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2(GLConstants.GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2),
	COMPRESSED_RGBA8_ETC2_EAC(GLConstants.GL_COMPRESSED_RGBA8_ETC2_EAC),
	COMPRESSED_SRGB8_ALPHA8_ETC2_EAC(GLConstants.GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC),
	COMPRESSED_RG11_EAC(GLConstants.GL_COMPRESSED_RG11_EAC),
	COMPRESSED_SIGNED_RG11_EAC(GLConstants.GL_COMPRESSED_SIGNED_RG11_EAC);

	InternalFormat(int token) {
		this.token = token;
	}

	public final int token;

	public static final InternalFormat[] VALUES = values();
	private static Map<Integer, InternalFormat> getMap() {
		Map<Integer, InternalFormat> map = new HashMap<>();
		for(InternalFormat val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, InternalFormat> MAP = Collections.unmodifiableMap(getMap());
	public static InternalFormat get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(InternalFormat... enums) { int i = 0; for(InternalFormat e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(InternalFormat... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}