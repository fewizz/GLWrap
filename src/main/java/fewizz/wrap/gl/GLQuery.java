package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.QueryTarget;

public class GLQuery extends GLObjectWithId<GLQuery> {
	public final QueryTarget target;
	
	public GLQuery(GLContext c, QueryTarget target) {
		super(c, c.wrap.query.create(-1));
		this.target = target;
	}

	public void begin() {
		ctx.wrap.query.begin(target.token, name);
	}
	
	public void end() {
		ctx.wrap.query.end(target.token);
	}
	
	/*public void getResult(int type, IntBuffer buffer) {
		GL15.glGetQueryObjectiv(getName(), type, buffer);
	}
	
	public int getResult(int type) {
		return GL15.glGetQueryObjecti(getName(), type);
	}*/

	@Override
	public void delete() {
		ctx.wrap.query.delete(name);
	}

}
