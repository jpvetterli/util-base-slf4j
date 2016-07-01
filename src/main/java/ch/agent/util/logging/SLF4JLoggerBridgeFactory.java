package ch.agent.util.logging;

import org.slf4j.LoggerFactory;

/**
 * A logger bridge factory for the SLF4J logger factory.
 * <p>
 * To use it, include something like this early in your code
 * or use the equivalent on the java invocation command line:
 * 
 * <pre>
 * <code>
 * 	static {
 * 		System.setProperty(
 *  		"LoggerBridgeFactory", 
 *  		"ch.agent.util.logging.SLF4JLoggerBridgeFactory");
 * 	}
 * 
 * </code>
 * </pre>
 */
public final class SLF4JLoggerBridgeFactory implements LoggerBridgeFactory {

	private static SLF4JLoggerBridgeFactory factory = new SLF4JLoggerBridgeFactory();
	
	/**
	 * Return the DefaultLoggerFactory instance.
	 * @return the DefaultLoggerFactory instance
	 */
	public static SLF4JLoggerBridgeFactory getInstance() {
		return factory;
	}
	
	private SLF4JLoggerBridgeFactory() {
	}

	@Override
	public LoggerBridge getLogger(String name) {
		return new SLF4JLoggerBridge(LoggerFactory.getLogger(name));
	}

	@Override
	public LoggerBridge getLogger(Class<?> klass) {
		return new SLF4JLoggerBridge(LoggerFactory.getLogger(klass));
	}
	
}
