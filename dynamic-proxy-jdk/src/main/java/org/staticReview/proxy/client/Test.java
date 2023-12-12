package org.staticReview.proxy.client;

import org.staticReview.proxy.service.PurchaseImpl;
import org.staticReview.proxy.service.PurchaseProxy;

public class Test {
    public static void main(String[] args) {
        PurchaseProxy pp = new PurchaseProxy();
        pp.generate();
        pp.modify();
    }
}
