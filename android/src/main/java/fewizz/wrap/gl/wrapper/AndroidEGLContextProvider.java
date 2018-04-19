package fewizz.wrap.gl.wrapper;

import android.opengl.GLSurfaceView;

public class AndroidEGLContextProvider extends ContextProvider {
	GLSurfaceView v;
	final int ma;
	final int mi;
	
	public AndroidEGLContextProvider(GLSurfaceView view, int ma, int mi) {
		this.ma = ma;
		this.mi = mi;
		this.v = view;
	}
	
	@Override
	public void createContext() {
		v.setEGLContextClientVersion(ma);
	}

}
