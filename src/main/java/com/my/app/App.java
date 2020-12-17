package com.my.app;

import com.mypack.Server;

/**
 * Hello world!
 */
public final class App {

    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World Server!");
        Server s = new Server();
        try {
            s.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
