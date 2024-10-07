package vn.edu.iuh.fit.session01;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SampleListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println();
        System.out.println("*********"+srae.getName()+"="+srae.getValue());
        System.out.println();
    }
}
