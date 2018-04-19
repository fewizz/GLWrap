package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.ShaderType;

public class GLShader extends GLObjectWithId<GLShader> {
	final ShaderType type;
	public String source;

	public GLShader(ShaderType type) {
		this(GLContext.current(), type);
	}
	
	GLShader(GLContext c, ShaderType type) {
		super(c, c.wrap.shader.create(type.token));
		this.type = type;
	}
	
	public GLShader(ShaderType type, String src) throws GLShaderCompilationError {
		this(type);
		source(src);
		compile();
	}

	public void delete() {
		ctx.wrap.shader.delete(name);
	}

	public GLShader source(String source) {
		this.source = source;
		ctx.wrap.shader.source(name, source);
		return this;
	}

	public GLShader compile() throws GLShaderCompilationError {
		ctx.wrap.shader.compile(name);
		
		if (ctx.wrap.shader.geti(name, GLConstants.GL_COMPILE_STATUS) == GLConstants.GL_FALSE) {
			throw new GLShaderCompilationError(source + " \n" + type.name() + " not compiled!\n" + ctx.wrap.shader.getInfoLog(name));
		}
		return this;
	}

	public class GLShaderCompilationError extends GLError {
		private static final long serialVersionUID = 4104267426370159580L;

		public GLShaderCompilationError(String message) {
			super(message);
		}
	}
}
