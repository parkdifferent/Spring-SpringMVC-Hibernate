package com.mangosis.ssh.util;

/**
 * Created by admin on 2017/5/23.
 */
public enum EnumType {
    HELLO("hello1"),WORLD("world1");

    private String name;

    EnumType(String name) {
        this.name = name;
    }

    private static EnumType getName(String name) {
        for(EnumType enumType : EnumType.values()) {
            if(enumType.name.equalsIgnoreCase(name)) {
                return enumType;
            }
        }
        throw new RuntimeException(name + "is not a valid EnumType");
    }

    public String getStrName() {
        return name;
    }

    public static void main(String[] args) {

        System.out.println(EnumType.HELLO);
        System.out.println(EnumType.WORLD);
        System.out.println(EnumType.HELLO.getStrName());
        System.out.println(EnumType.WORLD.getStrName());
    }

}
