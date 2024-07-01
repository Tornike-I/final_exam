package task1;

public class Computer {

    private String brand;
    private int memory; // in GB
    private int ssd;    // in GB
    private int hdd;    // in GB

    public Computer(String brand, int memory, int ssd, int hdd) {
        this.brand = brand;
        this.memory = memory;
        this.ssd = ssd;
        this.hdd = hdd;
    }

    @Override
    public String toString() {
        int score = 0;

        // Adjust score based on brand
        switch (brand.toLowerCase()) {
            case "apple":
            case "dell":
            case "hp":
                score += 20;
                break;
            case "lenovo":
            case "asus":
                score += 10;
                break;
            default:
                score -= 10; // unknown or less known brands
        }

        // Adjust score based on memory
        if (memory >= 32) {
            score += 20;
        } else if (memory >= 16) {
            score += 10;
        } else if (memory >= 8) {
            score += 5;
        } else {
            score -= 5;
        }

        // Adjust score based on SSD
        if (ssd >= 1000) {
            score += 20;
        } else if (ssd >= 512) {
            score += 10;
        } else if (ssd >= 256) {
            score += 5;
        } else {
            score -= 5;
        }

        // Adjust score based on HDD
        if (hdd >= 2000) {
            score += 10;
        } else if (hdd >= 1000) {
            score += 5;
        } else if (hdd >= 500) {
            score += 2;
        } else {
            score -= 5;
        }

        // Determine speed message based on score
        String speedMessage;
        switch (score / 10) {
            case 6:
            case 5:
                speedMessage = "Wow! It's really fast!";
                break;
            case 4:
            case 3:
                speedMessage = "Your computer is pretty decent.";
                break;
            case 2:
            case 1:
                speedMessage = "Your computer is average.";
                break;
            default:
                speedMessage = "Your computer is like a turtle.";
                break;
        }

        return String.format("Brand: %s, Memory: %dGB, SSD: %dGB, HDD: %dGB. %s", brand, memory, ssd, hdd, speedMessage);
    }

    public static void main(String[] args) {
        Computer comp1 = new Computer("Apple", 16, 512, 1000);
        System.out.println(comp1.toString());

        Computer comp2 = new Computer("Unknown", 4, 128, 500);
        System.out.println(comp2.toString());
    }
}
