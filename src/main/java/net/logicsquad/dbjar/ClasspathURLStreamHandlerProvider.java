package net.logicsquad.dbjar;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.spi.URLStreamHandlerProvider;

/**
 * URL stream handler for "cp:/" URLs for accessing resources in the classpath.
 * Supports a leading slash in the the path so that the scheme is treated as a
 * hierarchical scheme for resolving relative URL references.
 * 
 * <p>
 * Register this provider by putting the fully qualified name of this class in
 * the configuration file
 * META-INF/services/java.net.spi.URLStreamHandlerProvider.
 */
public class ClasspathURLStreamHandlerProvider extends URLStreamHandlerProvider {

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