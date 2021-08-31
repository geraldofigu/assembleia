package com.example.pauta;

public class ThreadA {

    public static void main(String[] args){
        ThreadB b = new ThreadB();
        b.start();

        synchronized(b){
            try{
                System.out.println("Aguardando o b completar...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Total é igual a: " + b.total);
        }
    }
}
