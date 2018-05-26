package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.TextureWrapMode;
import fewizz.wrap.gl.enums.TextureMagFilter;
import fewizz.wrap.gl.enums.TextureTarget;

import static fewizz.wrap.gl.GLConstants.*;

public abstract class GLTexture extends GLBindableObject<GLTexture> {
	public final TextureTarget target;
	
	GLTexture(GLContext c, TextureTarget target, int name) {
		super(c, name);
		this.target = target;
		bind();
	}

	GLTexture(GLContext c, TextureTarget tar) {
		this(GLContext.current(), tar, c.wrap.tex.gen());
	}
	public GLTexture(TextureTarget tar) {
		this(GLContext.current(), tar);
	}

	@Override
	protected void bind() {
		ctx.wrap.tex.bind(target.token, name);
		ctx.activeTextures[ctx.activeTextureUnit] = this;
		ctx.boundTexture = this;
	}

	@Override
	public void delete() {
		ctx.wrap.tex.delete(name);
		ctx.onTextureDeleted(this);
	}

	public void wrapMode(TextureWrapMode mode) {
		bind();
		parameter(GL_TEXTURE_WRAP_S, mode.token);
		parameter(GL_TEXTURE_WRAP_T, mode.token);
	}
	
	public void magFilter(TextureMagFilter filter) {
		bind();
		parameter(GL_TEXTURE_MAG_FILTER, filter.token);
	}

	public GLTexture parameter(int pname, int param) {
		bind();
		ctx.wrap.tex.parameteri(target.token, pname, param);
		return getThis();
	}

	protected GLTexture parameter(int pname, float param) {
		bind();
		ctx.wrap.tex.parameterf(target.token, pname, param);
		return getThis();
	}
	
	public int width() {
		bind();
		return ctx.wrap.tex.getTexLevelParameteri(target.token, 0, GL_TEXTURE_WIDTH);
	}
	
	public int height() {
		bind();
		return ctx.wrap.tex.getTexLevelParameteri(target.token, 0, GL_TEXTURE_WIDTH);
	}
	
	public int depth() {
		bind();
		return ctx.wrap.tex.getTexLevelParameteri(target.token, 0, GL_TEXTURE_DEPTH);
	}
}
