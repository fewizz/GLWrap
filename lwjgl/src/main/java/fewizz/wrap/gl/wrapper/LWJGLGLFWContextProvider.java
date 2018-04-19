package fewizz.wrap.gl.wrapper;

import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;

public class LWJGLGLFWContextProvider extends ContextProvider {

	private final long window;
	
	public LWJGLGLFWContextProvider(long window) {
		this.window = window;
	}
	
	@Override
	public void createContext() {
		glfwMakeContextCurrent(window);
	}

}
