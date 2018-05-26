package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.ProgramPropertyARB;
import fewizz.wrap.gl.enums.ShaderType;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedHashSet;
import java.util.Set;

public class GLShaderProgram extends GLBindableObject<GLShaderProgram> {
	final Set<GLShader> shaders = new LinkedHashSet<>();
	boolean linked = false;
	
	public GLShaderProgram() {
		this(GLContext.current());
	}
	
	GLShaderProgram(GLContext c) {
		this(c, c.wrap.shaderProg.create(-1));
	}

	GLShaderProgram(GLContext c, int name) {
		super(c, name);
	}
	
	public GLShaderProgram(ShaderType t1, String src1, ShaderType t2, String src2) throws GLShader.GLShaderCompilationError {
		this();
		attachShaders(new GLShader(t1, src1), new GLShader(t2, src2));
		link();
	}

	@Override
	protected void bind() {
		if(!isLinked()) {
			throw new Error("ShaderProgram is not linked");
		}
		ctx.wrap.shaderProg.use(name);
	}

	public void delete() {
		ctx.wrap.shaderProg.delete(name);
	}

	public void attachShader(GLShader shader) {
		ctx.wrap.shaderProg.attachShader(name, shader.name);
		shaders.add(shader);
	}

	public void attachShaders(GLShader... shaders) {
		for (GLShader sh : shaders)
			attachShader(sh);
	}

	public GLShader getShader(ShaderType type) {
		for(GLShader s : shaders) if(s.type == type) return s;
		return null;
	}

	public void link() {
		ctx.wrap.shaderProg.link(name);

		if (ctx.wrap.shaderProg.geti(name, ProgramPropertyARB.LINK_STATUS.token) == 0) {
			throw new GLError(ctx.wrap.shaderProg.getInfoLog(name));
		}
		
		linked = true;
	}
	
	public boolean isLinked() {
		return linked;
	}

	public int attribLocation(String name) {
		return ctx.wrap.shaderProg.attribLoc(this.name, name);
	}

	public int getUniformLocation(String name) {
		return ctx.wrap.shaderProg.uniformLoc(this.name, name);
	}

	public void setUniformInt(int location, int value) {
		bind();
		ctx.wrap.shaderProg.uniform1i(location, value);
	}
	
	public void setUniformMatrix4f(int location, int count, boolean trans, FloatBuffer buf) {
		bind();
		ctx.wrap.shaderProg.uniformMatrix4fv(location, count, trans, buf);
	}

	public void setUniformIntArray(int location, int count, IntBuffer buf) {
		bind();
		ctx.wrap.shaderProg.uniform1iv(location, count, buf);
	}
	
	public void setAttrib() {
		bind();
	}
}
