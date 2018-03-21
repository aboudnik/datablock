package org.boudnik.builder;

import org.junit.Test;

/**
 * @author Alexandre_Boudnik
 * @since 03/14/2018
 */
public class EntryTest {
    @Test
    public void main() {
        Entry e2 = new Entry("http://localhost/1 2/")
                .union(new Entry("http://localhost/1"))
                .union(new Entry("ftp://ftp.hoat.com/data/file1.txt"));
        System.out.println("e2 = " + e2);
    }

    @Test
    public void dedup() {
        Entry e2 = new Entry("http://localhost/1 2/3")
                .union(new Entry("http://localhost/././././1 2/3"))
                .union(new Entry("ftp://ftp.host.com/data/file1.txt"));
        System.out.println("union = " + e2.set());
    }

    @Test
    public void sql() {
        Entry e2 = new Entry("sqlserver://localhost:1433/NorthWind/?select * from sales where state=${state}&state='VA'");
        System.out.println("union = " + e2.set());
    }
}