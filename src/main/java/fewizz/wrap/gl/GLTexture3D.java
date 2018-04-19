package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.InternalFormat;
import fewizz.wrap.gl.enums.PixelFormat;
import fewizz.wrap.gl.enums.PixelType;
import fewizz.wrap.gl.enums.TextureTarget;

import java.nio.ByteBuffer;

public class GLTexture3D extends GLTexture {
	
	public GLTexture3D() {
		super(TextureTarget.TEXTURE_3D);
	}
	
	protected GLTexture3D(TextureTarget tar) {
		super(tar);
	}
	
	public void data3D(int level, InternalFormat inernalFormat, int width, int height, int depth, PixelFormat bufferPixelFormat, PixelType bufferDataType, ByteBuffer buf) {
		bind();
		ctx.wrap.tex.image3D(target.token, level, inernalFormat.token, width, height, depth, 0, bufferPixelFormat.token, bufferDataType.token, buf);
	}

	public void subData3D(int level, int xOff, int yOff, int zOff, int width, int height, int depth, PixelFormat bufferPixelFormat, PixelType bufferDataType, ByteBuffer buf) {
		bind();
		ctx.wrap.tex.subImage3D(target.token, level, xOff, yOff, zOff, width, height, depth, bufferPixelFormat.token, bufferDataType.token, buf);
	}

}
