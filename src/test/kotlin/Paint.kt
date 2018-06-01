import fewizz.wrap.gl.GLConstants
import fewizz.wrap.gl.GLContext
import fewizz.wrap.gl.GLShaderProgram
import fewizz.wrap.gl.GLTexture2D
import fewizz.wrap.gl.enums.*
import fewizz.wrap.gl.wrapper.LWJGLGLFWContextProvider
import fewizz.wrap.gl.wrapper.LWJGLWrapper
import org.lwjgl.glfw.GLFW
import java.awt.Canvas
import java.awt.Graphics
import java.awt.Graphics2D
import java.nio.ByteBuffer
import java.nio.ByteOrder

fun main(args: Array<String>) {
    GLFW.glfwInit()
    GLFW.glfwSetErrorCallback { _, description -> error(description) }
    GLFW.glfwDefaultWindowHints()
    GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_DEBUG_CONTEXT, GLFW.GLFW_TRUE)
    GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE)
    GLFW.glfwWindowHint(GLFW.GLFW_REFRESH_RATE, 0)
    val window = GLFW.glfwCreateWindow(600, 400, "Paint", 0, 0)
    if(window == 0L) println("GLFW Error")
    GLFW.glfwShowWindow(window)

    val gl = GLContext.create(LWJGLGLFWContextProvider(window), LWJGLWrapper())
    gl.dedugMessageCallback { source, type, id, severity, message -> println("$source: $message")}
    gl.viewport(0,0, 600, 400)

    val texBuf = ByteBuffer.allocateDirect(600*400*4*4).order(ByteOrder.nativeOrder()).asFloatBuffer()

    val tex = GLTexture2D()

    val program = GLShaderProgram(
            ShaderType.VERTEX_SHADER,
            """
            #version 130

            void main() {
                vec2[] vecs = vec2[] (vec2(-1, -1), vec2(-1, 1), vec2(1, 1), vec2(1, -1));
                gl_Position = vec4(vecs[gl_VertexID], 0, 1);
            }
            """,
            ShaderType.FRAGMENT_SHADER,
            """
            #version 130
            uniform sampler2D tex;
            void main() {
                gl_FragColor = texture2D(tex, gl_FragCoord.xy / textureSize(tex, 0));
            }
            """)


    val x = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asDoubleBuffer()
    val y = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asDoubleBuffer()

    while(!GLFW.glfwWindowShouldClose(window)) {
        GLFW.glfwPollEvents()
        gl.clear(ClearBuffer.COLOR_BUFFER_BIT)

        GLFW.glfwGetCursorPos(window, x, y)

        if(x.get(0) > 0 && x.get(0) < 600 && y.get(0) > 0 && y.get(0) < 400) {
            val startIndex: Int = (400 - y.get(0).toInt()) * 600 + x.get(0).toInt()
            texBuf.put(startIndex*4, 0F)
            texBuf.put(startIndex*4 + 1, 0F)
            texBuf.put(startIndex*4 + 2, 1F)
            texBuf.put(startIndex*4 + 2, 1F)
        }

        gl.setActiveTextureUnit(tex, 0)
        tex.data2D(0, InternalFormat.RGBA, 600, 400, PixelFormat.RGBA, PixelType.FLOAT, texBuf)
        tex.parameter(GLConstants.GL_TEXTURE_MAG_FILTER, GLConstants.GL_NEAREST)
        tex.parameter(GLConstants.GL_TEXTURE_MIN_FILTER, GLConstants.GL_NEAREST)
        program.setUniformInt(program.getUniformLocation("tex"), 0)
        gl.drawArrays(program, PrimitiveType.QUADS, 4)
        GLFW.glfwSwapBuffers(window)
    }
}