import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @Test
    void saldoAwalHarusNol() {
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    void depositBerhasil() {
        account.deposit(100000);
        assertEquals(100000, account.getBalance(), 0.001);
    }

    @Test
    void withdrawBerhasil() {
        account.deposit(100000);
        account.withdraw(30000);
        assertEquals(70000, account.getBalance(), 0.001);
    }

    @Test
    void depositNegatifHarusDitolak() {
        assertThrows(
            IllegalArgumentException.class,
            () -> account.deposit(-10000)
        );
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    void withdrawNegatifHarusDitolak() {
        account.deposit(50000);

        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(-10000)
        );
        assertEquals(50000, account.getBalance(), 0.001);
    }

    @Test
    void withdrawMelebihiSaldoHarusDitolak() {
        account.deposit(50000);

        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(100000)
        );
        assertEquals(50000, account.getBalance(), 0.001);
    }

    @Test
    void depositNolTidakMengubahSaldo() {
        account.deposit(0);
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    void withdrawSeluruhSaldoBerhasil() {
        account.deposit(50000);
        account.withdraw(50000);
        assertEquals(0.0, account.getBalance(), 0.001);
    }
}