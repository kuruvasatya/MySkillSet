public class Cricket extends Sport{
    String rules;

    public Cricket(String name, int noOfPlayers, String rules) {
        super(name, noOfPlayers);
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "Cricket{" +
                "rules='" + rules + '\'' +
                ", name='" + name + '\'' +
                ", noOfPlayers=" + noOfPlayers +
                '}';
    }
}
