package net.golovach._1_hardware_math._x_monitor;

/**
 * Created by kruart on 28.09.2017.
 */
public class App02 {
    public static void main(String[] args) throws InterruptedException {
        App02 app = new App02();
        app.f();
    }

    private /*synchronized*/ void f() {
        synchronized (this) {
            g();
        }
    }

    private static /*synchronized*/ void g() {
        synchronized (App02.class) {
            h();
        }
    }

    private static synchronized void h() {
        System.out.println("hello! = " + Thread.holdsLock(App02.class));
    }
}
