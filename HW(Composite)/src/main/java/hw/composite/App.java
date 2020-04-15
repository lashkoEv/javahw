package hw.composite;

public class App {
    public static void main(String[] args) {
        Corporation ms = new Corporation("MS");

        SimpleDepartment hh = new SimpleDepartment("HH");

        CompoundDepartment market = new CompoundDepartment("Market");
        market.add(new SimpleDepartment("USA"));
        market.add(new SimpleDepartment("UK"));
        market.add(new SimpleDepartment("EU"));

        CompoundDepartment development = new CompoundDepartment("Development");
        development.add(new SimpleDepartment("Game"));
        development.add(new SimpleDepartment("Office"));
        development.add(new SimpleDepartment("OS"));

        ms.add(hh);
        ms.add(market);
        ms.add(development);

        System.out.println(ms.report());
        System.out.println("\n\n" + hh.report());
        System.out.println("\n\n" + market.report());
    }
}
