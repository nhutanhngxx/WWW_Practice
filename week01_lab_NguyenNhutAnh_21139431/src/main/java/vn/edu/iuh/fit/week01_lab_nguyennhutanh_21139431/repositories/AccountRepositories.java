package vn.edu.iuh.fit.week01_lab_nguyennhutanh_21139431.repositories;

import vn.edu.iuh.fit.week01_lab_nguyennhutanh_21139431.models.Account;

import java.util.List;

public interface AccountRepositories {
    public Account login(String username, String password);

    public boolean register(String username, String password);

    public boolean changePassword(String username, String password);

    public boolean deleteAccount(String username);

    public boolean findAccount(String account_id, String password);

    public boolean findAccountByUsername(String username);

    public boolean updateAccount(String account_id);

    public Account findAccountById(String account_id);

    public List<Account> getAllAccount();
}
