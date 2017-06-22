package com.mangosis.ssh.util;

/**
 * Created by admin on 2017/5/25.
 */
public class Outer {

    private String name = "hello";

    class Inner{
         private String name = "world";
        void print() {
            System.out.println(Inner.this.name);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
        inner.print();
    }
}
