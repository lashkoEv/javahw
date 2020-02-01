package hw;

public class CDDisk {
    private String name;
    private String typeOfContent;
    private double cost;

    public CDDisk(String name, String typeOfContent, double cost) {
        this.name = name;
        this.typeOfContent = typeOfContent;
        this.cost = cost;
    }

    public CDDisk() {
        this.name = "";
        this.typeOfContent = "";
        this.cost = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfContent() {
        return typeOfContent;
    }

    public void setTypeOfContent(String typeOfContent) {
        this.typeOfContent = typeOfContent;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Type of content: " + typeOfContent + '\n' +
                "Cost: " + cost +
                "\n\n";
    }
}
