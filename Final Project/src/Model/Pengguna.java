package Model;

public class Pengguna {
    
    private String id;
    private String nama;
    private String nomor;
    private String username;
    private String password;
    private String role;

    public Pengguna(String id, String nama, String nomor, String username, String password, String role) {
        this.id = id;
        this.nama = nama;
        this.nomor = nomor;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    
}
