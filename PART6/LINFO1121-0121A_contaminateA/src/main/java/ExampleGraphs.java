import java.util.*;

public class ExampleGraphs {
    //NE TOUCHEZ PAS A CA. ce sont des graphes d'exemple utilises dans les tests.
    //les "converted" sont l'output attendu apres le passage dans genGraph.

    public static final Map<String, Set<String>> ex0;
    public static final Map<String, Set<String>> convertedEx0;
    
    public static final Map<String, Set<String>> ex1;
    public static final Map<String, Set<String>> convertedEx1;

    public static final Map<String, Set<String>> ex2;
    public static final Map<String, Set<String>> convertedEx2;

    public static final Map<String, Set<String>> ex3;
    public static final Map<String, Set<String>> convertedEx3;

    public static final Map<String, Set<String>> ex4;
    public static final Map<String, Set<String>> convertedEx4;

    public static final Map<String, Set<String>> ex5;
    public static final Map<String, Set<String>> convertedEx5;

    static {
        ex0 = new HashMap<>();
        convertedEx0 = new HashMap<>();
        ex0.put("Didier", new HashSet<>(Arrays.asList("Le Piano", "Salle Intel")));
        ex0.put("Bob", new HashSet<>(Arrays.asList("Piscine")));
        ex0.put("Emmanuel", new HashSet<>(Arrays.asList("Delhaize", "Le Piano", "Piscine")));
        ex0.put("Jacky", new HashSet<>(Arrays.asList("Delhaize")));
        ex0.put("Frederic", new HashSet<>(Arrays.asList("Le Piano", "Piscine")));
        
        convertedEx0.put("Bob", new HashSet<>(Arrays.asList("Emmanuel", "Frederic")));
        convertedEx0.put("Didier", new HashSet<>(Arrays.asList("Emmanuel", "Frederic")));
        convertedEx0.put("Emmanuel", new HashSet<>(Arrays.asList("Bob", "Didier", "Frederic", "Jacky")));
        convertedEx0.put("Jacky", new HashSet<>(Arrays.asList("Emmanuel")));
        convertedEx0.put("Frederic", new HashSet<>(Arrays.asList("Bob", "Didier", "Emmanuel")));
        
        ex1 = new HashMap<>();
        convertedEx1 = new HashMap<>();

        ex1.put("Bob", new HashSet<>(Arrays.asList("Coiffeur", "Sandwicherie", "Piscine")));
        ex1.put("Charles", new HashSet<>(Arrays.asList("Delhaize", "Aldi", "Salle Intel")));
        ex1.put("Didier", new HashSet<>(Arrays.asList("Le Piano", "Salle Intel")));
        ex1.put("Emmanuel", new HashSet<>(Arrays.asList("Delhaize", "Le Piano", "Hall Sainte-barbe", "Piscine")));
        ex1.put("Frederic", new HashSet<>(Arrays.asList("Coiffeur", "Le Piano", "Piscine")));
        ex1.put("Guillaume", new HashSet<>(Arrays.asList("Coiffeur", "Sandwicherie", "Le Piano", "Salle Intel")));
        ex1.put("Henry", new HashSet<>(Arrays.asList("Coiffeur")));
        ex1.put("Isidore", new HashSet<>(Arrays.asList("Aldi", "Hall Sainte-barbe")));
        ex1.put("Jacky", new HashSet<>(Arrays.asList("Delhaize")));

        convertedEx1.put("Bob", new HashSet<>(Arrays.asList("Emmanuel", "Frederic", "Guillaume", "Henry")));
        convertedEx1.put("Charles", new HashSet<>(Arrays.asList("Didier", "Emmanuel", "Guillaume", "Isidore", "Jacky")));
        convertedEx1.put("Didier", new HashSet<>(Arrays.asList("Charles", "Emmanuel", "Frederic", "Guillaume")));
        convertedEx1.put("Emmanuel", new HashSet<>(Arrays.asList("Bob", "Charles", "Didier", "Frederic", "Guillaume", "Isidore", "Jacky")));
        convertedEx1.put("Frederic", new HashSet<>(Arrays.asList("Bob", "Didier", "Emmanuel", "Guillaume", "Henry")));
        convertedEx1.put("Guillaume", new HashSet<>(Arrays.asList("Bob", "Charles", "Didier", "Emmanuel", "Frederic", "Henry")));
        convertedEx1.put("Henry", new HashSet<>(Arrays.asList("Bob", "Frederic", "Guillaume")));
        convertedEx1.put("Isidore", new HashSet<>(Arrays.asList("Charles", "Emmanuel")));
        convertedEx1.put("Jacky", new HashSet<>(Arrays.asList("Charles", "Emmanuel")));




        ex2 = new HashMap<>();
        convertedEx2 = new HashMap<>();

        ex2.put("Alice", new HashSet<>(Arrays.asList("Aldi", "Marche")));
        ex2.put("Bob", new HashSet<>(Arrays.asList("Spar")));
        ex2.put("Charles", new HashSet<>(Arrays.asList("Hall Sainte-barbe")));
        ex2.put("Didier", new HashSet<>(Arrays.asList("Hall Sainte-barbe", "Spar")));
        ex2.put("Emmanuel", new HashSet<>(Arrays.asList("Aldi")));
        ex2.put("Frederic", new HashSet<>(Arrays.asList("Marche", "Hall Sainte-barbe", "Salle Intel")));
        ex2.put("Guillaume", new HashSet<>(Arrays.asList("Delhaize", "Marche")));
        ex2.put("Henry", new HashSet<>(Arrays.asList("Aldi")));
        ex2.put("Jacky", new HashSet<>(Arrays.asList("Sandwicherie", "Spar")));

        convertedEx2.put("Alice", new HashSet<>(Arrays.asList("Emmanuel", "Frederic", "Guillaume", "Henry")));
        convertedEx2.put("Bob", new HashSet<>(Arrays.asList("Jacky", "Didier")));
        convertedEx2.put("Charles", new HashSet<>(Arrays.asList("Didier", "Frederic")));
        convertedEx2.put("Didier", new HashSet<>(Arrays.asList("Charles", "Frederic", "Bob", "Jacky")));
        convertedEx2.put("Emmanuel", new HashSet<>(Arrays.asList("Alice", "Henry")));
        convertedEx2.put("Frederic", new HashSet<>(Arrays.asList("Alice", "Charles", "Didier", "Guillaume")));
        convertedEx2.put("Guillaume", new HashSet<>(Arrays.asList("Alice", "Frederic")));
        convertedEx2.put("Henry", new HashSet<>(Arrays.asList("Alice", "Emmanuel")));
        convertedEx2.put("Jacky", new HashSet<>(Arrays.asList("Bob", "Didier")));




        ex3 = new HashMap<>();
        convertedEx3 = new HashMap<>();

        ex3.put("Alice", new HashSet<>(Arrays.asList("Piscine", "Spar", "Delhaize")));
        ex3.put("Bob", new HashSet<>(Arrays.asList("Delhaize")));
        ex3.put("Didier", new HashSet<>(Arrays.asList("Spar", "Delhaize", "Piscine")));
        ex3.put("Emmanuel", new HashSet<>(Arrays.asList("Hall Sainte-barbe", "Marche", "Piscine")));
        ex3.put("Frederic", new HashSet<>(Arrays.asList("Hall Sainte-barbe", "Le Piano")));
        ex3.put("Guillaume", new HashSet<>(Arrays.asList("Hall Sainte-barbe")));
        ex3.put("Henry", new HashSet<>(Arrays.asList("Aldi", "Coiffeur", "Marche")));
        ex3.put("Isidore", new HashSet<>(Arrays.asList("Marche", "Salle Intel")));
        ex3.put("Jacky", new HashSet<>(Arrays.asList("Salle Intel")));

        convertedEx3.put("Alice", new HashSet<>(Arrays.asList("Bob", "Didier", "Emmanuel")));
        convertedEx3.put("Bob", new HashSet<>(Arrays.asList("Alice", "Didier")));
        convertedEx3.put("Didier", new HashSet<>(Arrays.asList("Alice", "Bob", "Emmanuel")));
        convertedEx3.put("Emmanuel", new HashSet<>(Arrays.asList("Alice", "Didier", "Frederic", "Guillaume", "Henry", "Isidore")));
        convertedEx3.put("Frederic", new HashSet<>(Arrays.asList("Emmanuel", "Guillaume")));
        convertedEx3.put("Guillaume", new HashSet<>(Arrays.asList("Emmanuel", "Frederic")));
        convertedEx3.put("Henry", new HashSet<>(Arrays.asList("Isidore", "Emmanuel")));
        convertedEx3.put("Isidore", new HashSet<>(Arrays.asList("Jacky", "Emmanuel", "Henry")));
        convertedEx3.put("Jacky", new HashSet<>(Arrays.asList("Isidore")));




        ex4 = new HashMap<>();
        convertedEx4 = new HashMap<>();

        ex4.put("Alice", new HashSet<>(Arrays.asList("Coiffeur")));
        ex4.put("Bob", new HashSet<>(Arrays.asList("Coiffeur", "Delhaize")));
        ex4.put("Charles", new HashSet<>(Arrays.asList("Delhaize", "Sandwicherie")));
        ex4.put("Didier", new HashSet<>(Arrays.asList("Sandwicherie", "Aldi")));
        ex4.put("Emmanuel", new HashSet<>(Arrays.asList("Aldi", "Le Piano")));
        ex4.put("Frederic", new HashSet<>(Arrays.asList("Le Piano", "Hall Sainte-barbe")));
        ex4.put("Guillaume", new HashSet<>(Arrays.asList("Hall Sainte-barbe", "Salle Intel")));
        ex4.put("Henry", new HashSet<>(Arrays.asList("Salle Intel", "Piscine")));
        ex4.put("Isidore", new HashSet<>(Arrays.asList("Piscine", "Marche")));
        ex4.put("Jacky", new HashSet<>(Arrays.asList("Marche")));

        convertedEx4.put("Alice", new HashSet<>(Arrays.asList("Bob")));
        convertedEx4.put("Bob", new HashSet<>(Arrays.asList("Alice", "Charles")));
        convertedEx4.put("Charles", new HashSet<>(Arrays.asList("Bob", "Didier")));
        convertedEx4.put("Didier", new HashSet<>(Arrays.asList("Charles", "Emmanuel")));
        convertedEx4.put("Emmanuel", new HashSet<>(Arrays.asList("Didier", "Frederic")));
        convertedEx4.put("Frederic", new HashSet<>(Arrays.asList("Emmanuel", "Guillaume")));
        convertedEx4.put("Guillaume", new HashSet<>(Arrays.asList("Frederic", "Henry")));
        convertedEx4.put("Henry", new HashSet<>(Arrays.asList("Guillaume", "Isidore")));
        convertedEx4.put("Isidore", new HashSet<>(Arrays.asList("Henry", "Jacky")));
        convertedEx4.put("Jacky", new HashSet<>(Arrays.asList("Isidore")));




        ex5 = new HashMap<>();
        convertedEx5 = new HashMap<>();

        ex5.put("A", new HashSet<>(Arrays.asList("A", "D", "C")));
        ex5.put("B", new HashSet<>(Arrays.asList("F")));
        ex5.put("C", new HashSet<>(Arrays.asList("C", "J")));
        ex5.put("D", new HashSet<>(Arrays.asList("H", "B")));
        ex5.put("E", new HashSet<>(Arrays.asList("I", "A")));
        ex5.put("F", new HashSet<>(Arrays.asList("A", "F", "E")));
        ex5.put("G", new HashSet<>(Arrays.asList("C")));
        ex5.put("H", new HashSet<>(Arrays.asList("G", "D", "E")));
        ex5.put("I", new HashSet<>(Arrays.asList("I", "H")));
        ex5.put("J", new HashSet<>(Arrays.asList("C", "J")));

        convertedEx5.put("A", new HashSet<>(Arrays.asList("E", "F", "H", "G", "C", "J")));
        convertedEx5.put("B", new HashSet<>(Arrays.asList("F")));
        convertedEx5.put("C", new HashSet<>(Arrays.asList("J", "G", "A")));
        convertedEx5.put("D", new HashSet<>(Arrays.asList("I")));
        convertedEx5.put("E", new HashSet<>(Arrays.asList("I", "A", "F")));
        convertedEx5.put("F", new HashSet<>(Arrays.asList("A", "B", "E", "H")));
        convertedEx5.put("G", new HashSet<>(Arrays.asList("J", "C", "A")));
        convertedEx5.put("H", new HashSet<>(Arrays.asList("A", "F")));
        convertedEx5.put("I", new HashSet<>(Arrays.asList("D", "E")));
        convertedEx5.put("J", new HashSet<>(Arrays.asList("C", "G", "A")));
    }
}
