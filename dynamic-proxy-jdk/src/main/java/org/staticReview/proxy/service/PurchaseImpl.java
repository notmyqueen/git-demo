package org.staticReview.proxy.service;

public class PurchaseImpl implements PurchaseService {
    @Override
    public void generate() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("正在下单");
    }

    @Override
    public void modify() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("正在修改订单");
    }
}
