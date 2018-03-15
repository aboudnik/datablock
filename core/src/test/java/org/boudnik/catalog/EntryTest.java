package org.boudnik.catalog;

import org.junit.Test;
import org.mvel2.templates.TemplateRuntime;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexandre_Boudnik
 * @since 03/15/18 14:02
 */
public class EntryTest {
    @Test
    public void sql() throws MalformedURLException, UnsupportedEncodingException {
        URL.setURLStreamHandlerFactory(protocol -> new URLStreamHandler() {
            @Override
            protected URLConnection openConnection(URL u) throws IOException {
                return null;
            }
        });

        URL u = new URL("jdbc:sqlserver://localhost:1433/AdventureWorks?select id, name, rate\nfrom salary, employees\nwhere salary.id=employees.id and month='${month}' and department=${department}&month=2016-12-01&department=42");
        String[] split = u.getQuery().split("&");
        String select = URLDecoder.decode(split[0], "UTF-8");
        System.out.println("select = " + select);
        Map<String, String> parameters = new HashMap<>();
        for (int i = 1; i < split.length; i++) {
            String[] s = split[i].split("=");
            parameters.put(s[0], s[1]);
        }
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            System.out.println("entry = " + entry);
        }

        Object eval = TemplateRuntime.eval(select, parameters);
        System.out.println("eval = " + eval);
    }
}