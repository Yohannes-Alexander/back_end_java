import java.util.Optional;
// import java.util.Optional;

public class Product {
    private int id;
    private String nama;
    private Integer  harga;
    private Merchant merchant;
    public Product(int id, String nama, int harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }
    Optional<Integer> getHargaOptional() {
        return Optional.ofNullable(harga);
    }
    public int getHarga() {
        return getHargaOptional().orElse(0);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

}
