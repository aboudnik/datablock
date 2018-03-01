package org.boudnik.datablock.core.test;

import org.boudnik.framework.Store;
import org.boudnik.framework.Transaction;

/**
 * @author Alexandre_Boudnik
 * @since 02/13/2018
 */
public class Main {
    public static void main(String[] args) {
        Store store = Store.instance();
        store.create(Entry.class);
        try (Transaction tx = store.begin()) {
            new Entry("http://localhost/1").save("");
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (Transaction tx = store.begin()) {
            Entry entry = tx.get(Entry.class, "http://localhost/1");
            System.out.println("entry = " + entry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Main.main");
    }
}
