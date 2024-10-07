package vn.edu.iuh.fit.week01.beans;

import jakarta.servlet.http.HttpServlet;

public class LoginBeans {
    /**
     * Phuong thuc dang nhap tai khoan nguoi dung
     * @param us la username
     * @param pw la password
     * @param tra ve true neu dang nhap thanh cong <br/>
     *        tra ve false neu dang nhap that bai
     */
    public boolean login(String us, String pw) {
        if (us.equalsIgnoreCase("ty") && pw.equals("123"))
            return true;
        return false;
    }
}
