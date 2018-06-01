package fewizz.wrap.gl;

import fewizz.wrap.gl.enums.VertexAttribType;

import java.util.HashMap;
import java.util.Map;

public class GLVertexArray extends GLBindableObject<GLVertexArray> {
	final HashMap<Integer, VertexAttribArray> vbos = new HashMap<>();
	
	public GLVertexArray() {
		this(GLContext.current());
	}
	
	GLVertexArray(GLContext c) {
		this(c, c.wrap.vertexArray.gen());
	}

	GLVertexArray(GLContext c, int name) {
		super(c, name);
		bind();
	}

	@Override
	public void bind() {
		ctx.wrap.vertexArray.bind(-1, name);
	}
	
	@Override
	public void delete() {
		ctx.wrap.vertexArray.delete(name);
		vbos.clear();
	}
	
	public void forEachAttribArray(VAAIndexedConsumer action) {
		for(Map.Entry<Integer, VertexAttribArray> e : vbos.entrySet()) {
			action.apply(e.getKey(), e.getValue());
		}
	}

	public void forEachAttribArray(VAAConsumer action) {
		for(VertexAttribArray a : vbos.values()) {
			action.apply(a);
		}
	}

	public int verticiesAvailable() {
		int min = Integer.MAX_VALUE;
		for(VertexAttribArray a : vbos.values()) {
			if(a.getVertexCount() < min) min = a.getVertexCount();
		}
		return min;
	}

	public interface VAAIndexedConsumer {
		void apply(int index, VertexAttribArray vaa);
	}

	public interface VAAConsumer {
		void apply(VertexAttribArray vaa);
	}
	
	public VertexAttribArray getVertexAttribArrayAt(int index) {
		return vbos.get(index);
	}
	
	public VertexAttribArray vertexAttribPointer(VertexAttribFormat attrib, GLVertexBuffer vbo) {
		bind();
		vbo.bind();
		
		if(attrib.serverDataType.isIntegral)
			ctx.wrap.vertexArray.vertexAttribIPointer(attrib.index, attrib.components, attrib.clientDataType.token, 0, 0L);
		else
			ctx.wrap.vertexArray.vertexAttribPointer(attrib.index, attrib.components, attrib.clientDataType.token, attrib.normalized, 0, 0L);
		
		VertexAttribArray arr = new VertexAttribArray(attrib, vbo);
		vbos.put(attrib.index, arr);
		return arr;
	}
	
	public void enableVertexAttribArray(int index) {
		bind();
		ctx.wrap.vertexArray.enableAttrib(index);
	}
	
	public void disableVertexAttribArray(int index) {
		bind();
		ctx.wrap.vertexArray.disableAttrib(index);
	}
	
	public class VertexAttribArray {
		public GLBuffer<?> vbo;
		public final VertexAttribFormat info;
		
		VertexAttribArray(VertexAttribFormat attrib, GLVertexBuffer vbo) {
			this.vbo = vbo;
			this.info = attrib;
		}
		
		public VertexAttribArray enable() {
			enableVertexAttribArray(info.index);
			return this;
		}
		
		public VertexAttribArray disable() {
			disableVertexAttribArray(info.index);
			return this;
		}
		
		public int getVertexCount() {
			return vbo.size() / info.bytes();
		}
	}
	
	public static class VertexAttribFormat {
		public final VertexAttribType clientDataType;
		public final VertexAttribType serverDataType;
		public final int components;
		public final boolean normalized;
		public final int index;
		
		public VertexAttribFormat(int index, VertexAttribType clientDataType, VertexAttribType serverDataType, int components, boolean normalize) {
			this.clientDataType = clientDataType;
			this.serverDataType = serverDataType;
			this.components = components;
			this.normalized = normalize;
			this.index = index;
		}
		
		public int bytes() {
			return components * clientDataType.bytes;
		}
		
		public static VertexAttribFormat intType(int index, VertexAttribType clientDataType, int components) {
			return new VertexAttribFormat(index, clientDataType, VertexAttribType.INT, components, false);
		}
		
		public static VertexAttribFormat floatType(int index, VertexAttribType clientDataType, int components, boolean normalized) {
			return new VertexAttribFormat(index, clientDataType, VertexAttribType.FLOAT, components, normalized);
		}
		
		public static VertexAttribFormat pos3f(int index) {return floatType(index, VertexAttribType.FLOAT, 3, false);}
		public static VertexAttribFormat pos2f(int index) {return floatType(index, VertexAttribType.FLOAT, 2, false);}
		public static VertexAttribFormat normal3f(int index) {return floatType(index, VertexAttribType.FLOAT, 3, false);}
		public static VertexAttribFormat color4ub(int index) {return floatType(index, VertexAttribType.UNSIGNED_BYTE, 4, true);}
		public static VertexAttribFormat uv2f(int index) {return floatType(index, VertexAttribType.FLOAT, 2, false);}
	}
}
