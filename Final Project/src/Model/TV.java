package Model;

public class TV {
    
    private String id;
    private String jenis;
    private String status;

    public TV(String id, String jenis, String status) {
        this.id = id;
        this.jenis = jenis;
        this.status = status;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
