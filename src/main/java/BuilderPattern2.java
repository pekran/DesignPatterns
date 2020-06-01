public class BuilderPattern2 {
    public static void main(String[] args) {
        // 1 without builder
        Computer computer = new Computer("windows", null, 16, 512);
        System.out.println(computer);
        // 2 with builder
        Computer nvdia = Computer.builder()
                .setGraphicCard("nvdia")
                .setRam(16)
                .build();
        System.out.println(nvdia);
    }

}

class Computer {
    private String os;
    private String graphicCard;
    private int ram;
    private int memory;

    public Computer(String os, String graphicCard, int ram, int memory) {
        this.os = os;
        this.graphicCard = graphicCard;
        this.ram = ram;
        this.memory = memory;
    }

    public static ComputerBuilder builder(){
        return new ComputerBuilder();
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "os='" + os + '\'' +
                ", graphicCard='" + graphicCard + '\'' +
                ", ram=" + ram +
                ", memory=" + memory +
                '}';
    }

    public static class ComputerBuilder {
        private String os;
        private String graphicCard;
        private int ram;
        private int memory;

        public ComputerBuilder setOs(String os) {
            this.os = os;
            return this;
        }

        public ComputerBuilder setGraphicCard(String graphicCard) {
            this.graphicCard = graphicCard;
            return this;
        }

        public ComputerBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setMemory(int memory) {
            this.memory = memory;
            return this;
        }

        public Computer build() {
            return new Computer(os, graphicCard, ram, memory);
        }
    }
}