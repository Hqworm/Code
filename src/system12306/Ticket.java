package system12306;

public class Ticket {
    private String startName;
    private String endName;
    private Float price;

    public Ticket() {
    }

    public Ticket(String startName, String endName, Float price) {
        this.startName = startName;
        this.endName = endName;
        this.price = price;
    }

    public String getStartName() {
        return startName;
    }

    public void setStartName(String startName) {
        this.startName = startName;
    }

    public String getEndName() {
        return endName;
    }

    public void setEndName(String endName) {
        this.endName = endName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder("[");
        builder.append(this.startName);
        builder.append("-->");
        builder.append(this.endName);
        builder.append(":");
        builder.append(this.price);
        builder.append("]");
        return builder.toString();

    }
}
