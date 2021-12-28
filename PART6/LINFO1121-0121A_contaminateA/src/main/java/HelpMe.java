import java.util.Map;
import java.util.Set;

public class HelpMe {
    public static Map<String, Set<String>> genGraph(Map<String, Set<String>> peopleToPlaces) {
        if(peopleToPlaces.equals(ExampleGraphs.ex0))
            return ExampleGraphs.convertedEx0;
        if(peopleToPlaces.equals(ExampleGraphs.ex1))
            return ExampleGraphs.convertedEx1;
        if(peopleToPlaces.equals(ExampleGraphs.ex2))
            return ExampleGraphs.convertedEx2;
        if(peopleToPlaces.equals(ExampleGraphs.ex3))
            return ExampleGraphs.convertedEx3;
        if(peopleToPlaces.equals(ExampleGraphs.ex4))
            return ExampleGraphs.convertedEx4;
        if(peopleToPlaces.equals(ExampleGraphs.ex5))
            return ExampleGraphs.convertedEx5;

        throw new RuntimeException("Vous devez ajouter la reponse a HelpMe.genGraph si vous l'utilisez avec un graph" +
                "custom.");
    }
}
