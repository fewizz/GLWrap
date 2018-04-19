package fewizz.wrap.gl;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferUtils {
	static final Field ADDRESS;
	static final Field CAP;

	static {
		Field a = null;
		Field c = null;
		try {
			a = Buffer.class.getDeclaredField("address");
			a.setAccessible(true);

			c = Buffer.class.getDeclaredField("capacity");
			c.setAccessible(true);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		ADDRESS = a;
		CAP = c;
	}

	public static void address(ByteBuffer bb, long address) {
		try {
			ADDRESS.setLong(bb, address);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static long address(ByteBuffer bb) {
		try {
			return ADDRESS.getLong(bb);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void setCapacity(Buffer buffer, int cap) {
		try {
			CAP.setInt(buffer, cap);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}


}
