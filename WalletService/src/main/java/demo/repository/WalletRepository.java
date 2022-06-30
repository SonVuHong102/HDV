package demo.repository;

import demo.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    @Query("SELECT w FROM Wallet w WHERE w.username = ?1 AND w.phone = ?2 AND w.password = ?3 AND w.email = ?4")
    Wallet getWallet(String username, String phone, String password, String email);
}