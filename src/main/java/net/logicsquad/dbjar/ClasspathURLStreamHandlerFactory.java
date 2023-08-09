package net.logicsquad.dbjar;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 * <p>
 * Factory for providing a {@link URLStreamHandler} for "cp:/" URLs for accessing resources in the classpath.
 * Supports a leading slash in the the path so that the scheme is treated as a hierarchical scheme for
 * resolving relative URL references.
 * </p>
 * 
 * <p>
 * Register this provider by calling {@link URL#setURLStreamHandlerFactory(URLStreamHandlerFactory)}:
 * </p>
 * 
 * <pre>
 * URL.setURLStreamHandlerFactory(new ClasspathURLStreamHandlerFactory());
 * </pre>
 * 
 * @author jkmatila
 */
public class ClasspathURLStreamHandlerFactory implements URLStreamHandlerFactory {
	private static final String PROTOCOL = "cp";

	@Override
	public URLStreamHandler createURLStreamHandler(String protocol) {
		if (PROTOCOL.equals(protocol)) {
			return new URLStreamHandler() {
				@Override
				protected URLConnection openConnection(URL url) throws IOException {
					String urlPath = url.getPath();
					String resourcePath = urlPath.startsWith("/") ? urlPath.substring(1) : urlPath;
					return ClassLoader.getSystemClassLoader().getResource(resourcePath).openConnection();
				}
			};
		}
		return null;
	}
}
