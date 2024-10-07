package vn.edu.iuh.fit.session02.asyncSvl;

import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;

import java.io.IOException;

public class TeoAsycListener implements AsyncListener {
    @Override
    public void onComplete(AsyncEvent asyncEvent) throws IOException {
        System.out.println("start complete.....");
    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {

    }

    @Override
    public void onError(AsyncEvent asyncEvent) throws IOException {
        System.out.println("Erroorrrrrrrrrrrrrrrrrrrrrr");
    }

    @Override
    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
        System.out.println("start async.....");
    }
}
