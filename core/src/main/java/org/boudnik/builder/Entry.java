package org.boudnik.builder;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Alexandre_Boudnik
 * @since 03/14/2018
 */
public class Entry {
    static {
        URL.setURLStreamHandlerFactory(protocol -> {
            switch (protocol) {
                case "sqlserver":
                    return new URLStreamHandler() {
                        protected URLConnection openConnection(URL url) throws IOException {
                            return new URLConnection(url) {
                                public void connect() throws IOException {
                                    System.out.println("Connected!");
                                }
                            };
                        }
                    };
                default:
                    throw new RuntimeException(protocol);
            }
        });
    }

    private final String u;

    private Entry(Entry e0, Entry e1) {
        this.u = e0.u + '\n' + e1.u;
    }

    public Entry(String u) {
        this.u = normalize(u);
    }

    private String normalize(String u) {
        try {
            URL url = new URL(u);
            return new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).normalize().toString();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Entry union(Entry e) {
        return new Entry(this, e);
    }

    @Override
    public String toString() {
        return u + '\n';
    }

    public Set<URI> set() {
        return Arrays.stream(u.split("\n")).map(URI::create).collect(Collectors.toSet());
    }
}
