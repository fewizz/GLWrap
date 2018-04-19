import fewizz.wrap.gl.*
import fewizz.wrap.gl.enums.*
import fewizz.wrap.gl.wrapper.*
import org.lwjgl.glfw.GLFW.*
import java.nio.*

fun main(args: Array<String>) {
    glfwInit()
    glfwSetErrorCallback { error, description ->  kotlin.error(description)}
    glfwDefaultWindowHints()
    glfwWindowHint(GLFW_OPENGL_DEBUG_CONTEXT, GLFW_TRUE)
    val window = glfwCreateWindow(600, 400, "Test1", 0, 0)
    if(window == 0L) println("GLFW Error")
    glfwShowWindow(window)

    val gl = GLContext.create(LWJGLGLFWContextProvider(window), LWJGLWrapper())
    gl.dedugMessageCallback { source, type, id, severity, message -> println("$source: $message")}

    glfwSetFramebufferSizeCallback(window, { win, w, h -> gl.viewport(0, 0, w, h) })

    val vbo = GLVertexBuffer(
            ByteBuffer.allocateDirect(4*2*3)
                .order(ByteOrder.nativeOrder())
                .putFloat(-1F).putFloat(-1F)
                .putFloat(0F).putFloat(1F)
                .putFloat(1F).putFloat(-1F)
                .rewind(),
            BufferUsage.STATIC_DRAW)

    val program = GLShaderProgram(
            ShaderType.VERTEX_SHADER,
            """
            #version 120
            attribute vec2 pos;
            void main() {
                gl_Position = vec4(pos, 0, 1);
            }
            """,
            ShaderType.FRAGMENT_SHADER,
            """
            #version 120
            void main() {
                gl_FragColor = vec4(1, 0, 0, 1);
            }
            """)

    val vao = GLVertexArray()
    vao.vertexAttribPointer(GLVertexArray.VertexAttribFormat.pos2f(program.attribLocation("pos")), vbo).enable()

    while(!glfwWindowShouldClose(window)) {
        glfwPollEvents()
        gl.clear(ClearBuffer.COLOR_BUFFER_BIT)
        program.use()
        gl.drawArrays(vao, PrimitiveType.TRIANGLES, 3)
        glfwSwapBuffers(window)
    }
}