package fewizz.wrap.gl.wrapper;

import fewizz.wrap.gl.enums.DebugSeverity;
import fewizz.wrap.gl.enums.DebugSource;
import fewizz.wrap.gl.enums.DebugType;

public interface DebugMessageCallback {
	void callback(DebugSource source, DebugType type, int id, DebugSeverity severity, String message);
}
