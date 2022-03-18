package Model;

public class Practice {
    private int image;
    private String tilte,info;

    public Practice(int image, String tilte, String info) {
        this.image = image;
        this.tilte = tilte;
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
