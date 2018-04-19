package fewizz.wrap.gl.enums;

import java.util.*;
import fewizz.wrap.gl.GLConstants;

public enum FramebufferAttachmentParameterName {
	FRAMEBUFFER_ATTACHMENT_RED_SIZE(GLConstants.GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE),
	FRAMEBUFFER_ATTACHMENT_GREEN_SIZE(GLConstants.GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE),
	FRAMEBUFFER_ATTACHMENT_BLUE_SIZE(GLConstants.GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE),
	FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE(GLConstants.GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE),
	FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE(GLConstants.GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE),
	FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE(GLConstants.GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE),
	FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE(GLConstants.GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE),
	FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING(GLConstants.GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING),
	FRAMEBUFFER_ATTACHMENT_OBJECT_NAME(GLConstants.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME),
	FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL(GLConstants.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL),
	FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE(GLConstants.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE),
	FRAMEBUFFER_ATTACHMENT_LAYERED(GLConstants.GL_FRAMEBUFFER_ATTACHMENT_LAYERED),
	FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER(GLConstants.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER);

	FramebufferAttachmentParameterName(int token) {
		this.token = token;
	}

	public final int token;

	public static final FramebufferAttachmentParameterName[] VALUES = values();
	private static Map<Integer, FramebufferAttachmentParameterName> getMap() {
		Map<Integer, FramebufferAttachmentParameterName> map = new HashMap<>();
		for(FramebufferAttachmentParameterName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, FramebufferAttachmentParameterName> MAP = Collections.unmodifiableMap(getMap());
	public static FramebufferAttachmentParameterName get(int raw) { return MAP.get(raw); }

	public static int intMaskOf(FramebufferAttachmentParameterName... enums) { int i = 0; for(FramebufferAttachmentParameterName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = new ThreadLocal<>();
		int value;

		public static Mask of(FramebufferAttachmentParameterName... enums) {
			Mask m = MASKS.get();
			if(m == null){ m = new Mask(); MASKS.set(m); }			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}