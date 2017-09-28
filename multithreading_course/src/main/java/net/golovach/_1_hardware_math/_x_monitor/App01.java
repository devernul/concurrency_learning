package net.golovach._1_hardware_math._x_monitor;

/**
 * Created by kruart on 28.09.2017.
 */
public class App01 {
    public static void main(String[] args) throws InterruptedException {
        App01 app = new App01();
        app.f();
    }

    private synchronized void f() {
            g();
    }

    private static synchronized void g() {
            h();
    }

    private static synchronized void h() {
        System.out.println("hello! = " + Thread.holdsLock(App01.class));
    }
}
