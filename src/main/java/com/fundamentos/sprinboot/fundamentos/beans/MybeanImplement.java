package com.fundamentos.sprinboot.fundamentos.beans;


public class MybeanImplement implements Mybean {
    @Override
    public void print() {
        System.out.println("Hola Mundo, desde mis propias dependencias");

    }
}
