package Model;

public class womenGrid {
    private String userId;
    String image,price,name,description;
    womenGrid()
    {

    }

    public womenGrid(String userId) {
        this.userId = userId;
    }

    public womenGrid(String image, String price, String name, String description) {
        this.image = image;
        this.price=price;
        this.name=name;
        this.description=description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return userId;
    }
}
