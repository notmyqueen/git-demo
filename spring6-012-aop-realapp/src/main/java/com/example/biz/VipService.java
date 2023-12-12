package com.example.biz;

import org.springframework.stereotype.Service;

@Service
public class VipService {
        public void saveVip() {
            System.out.println("新增Vip会员");
        }

        public void deleteVip() {
            System.out.println("删除Vip会员");
        }

        public void modifyVip() {
            System.out.println("修改Vip会员");
        }

        public void getVip() {
            System.out.println("查询Vip会员");
        }

}
