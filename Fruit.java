import java.io.Serializable;

public class Fruit implements Comparable<Fruit>, Serializable {
    private String type;
    private double weight;

    public Fruit() {
        this.type = "apple";
        this.weight = 1.0;
    }

    public Fruit(String type, double weight) {
        this.type = validateType(type) ? type : "apple";
        this.weight = (weight > 0) ? weight : 1.0;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public void setType(String type) {
        if (validateType(type)) {
            this.type = type;
        }
    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        }
    }

    private boolean validateType(String type) {
        return type.equals("apple") || type.equals("orange") || type.equals("banana") || type.equals("kiwi") || type.equals("tomato");
    }

    @Override
    public String toString() {
        return "Type: " + type + " Weight: " + weight;
    }

    @Override
    public int compareTo(Fruit other) {
        if (other == null) {
            return -1;
        }
        int weightComparison = Double.compare(this.weight, other.weight);
        if (weightComparison != 0) {
            return weightComparison;
        }
        return this.type.compareTo(other.type);
    }
}