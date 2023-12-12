package org.staticReview.proxy.service;

public class PurchaseProxy implements PurchaseService {
    PurchaseImpl ps = new PurchaseImpl();

    @Override
    public void generate() {
        long start = System.currentTimeMillis();
        ps.generate();
        long end = System.currentTimeMillis();
        System.out.println("Time used " + (end - start) + "ms");
    }

    @Override
    public void modify() {
        long start = System.currentTimeMillis();
        ps.modify();
        long end = System.currentTimeMillis();
        System.out.println("Time used " + (end - start) + "ms");
    }
}
