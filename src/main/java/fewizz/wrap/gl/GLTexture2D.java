package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.InternalFormat;
import fewizz.wrap.gl.enums.PixelFormat;
import fewizz.wrap.gl.enums.PixelType;
import fewizz.wrap.gl.enums.TextureTarget;

import java.nio.ByteBuffer;

public class GLTexture2D extends GLTexture {
	
	public GLTexture2D() {
		super(TextureTarget.TEXTURE_2D);
	}
	
	public void data2D(int level, InternalFormat inernalFormat, int width, int height, PixelFormat bufferPixelFormat, PixelType bufferDataType, ByteBuffer buf) {
		bind();
		ctx.wrap.tex.image2D(target.token, level, inernalFormat.token, width, height, 0, bufferPixelFormat.token, bufferDataType.token, buf);
	}

	public void subData2D(int level, int xOff, int yOff, int width, int height, PixelFormat bufferPixelFormat, PixelType bufferDataType, ByteBuffer buf) {
		bind();
		ctx.wrap.tex.subImage2D(target.token, level, xOff, yOff, width, height, bufferPixelFormat.token, bufferDataType.token, buf);
	}

}
