package Model;

public class bestGrid {
    String image,price;

    public bestGrid() {
    }

    public bestGrid(String image,String price) {
        this.image = image;
        this.price=price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
