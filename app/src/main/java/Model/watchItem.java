package Model;

public class watchItem {
    String image,name,price,description;

    public watchItem() {
    }

    public watchItem(String image,String name,String price,String description) {
        this.image = image;
        this.name=name;
        this.price=price;
        this.description=description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
