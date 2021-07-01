public class Pyramid {
    private double height;
    private String modern_name;
    private String pharoah;
    private String site;

    public Pyramid(double height, String modern_name, String pharoah, String site) {
        this.height = height;
        this.modern_name = modern_name;
        this.pharoah = pharoah;
        this.site = site;
    }
    public double getHeight() {
        return height;
    }
    public String getModern_name() {
        return modern_name;
    }
    public String getPharoah() {
        return pharoah;
    }
    public String getSite() {
        return site;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    }
    public void setPharoah(String pharoah) {
        this.pharoah = pharoah;
    }
    public void setSite(String site) {
        this.site = site;
    }

    public String toString() {
        return "{Height: " + String.valueOf(height) + ", modern_name: " + modern_name + ", pharoah: " + pharoah + ", sit: " + site + "}";
    }
}
