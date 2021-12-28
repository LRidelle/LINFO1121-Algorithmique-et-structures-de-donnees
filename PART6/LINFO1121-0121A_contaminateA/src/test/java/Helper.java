import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Helper {
    // Rend le graphe donne en entree immutable, pour s'assurer que vous ne le modifiez pas...
    public static Map<String, Set<String>> makeImmutable(Map<String, Set<String>> map) {
        for (Map.Entry<String, Set<String>> entry : map.entrySet())
            entry.setValue(Collections.unmodifiableSet(entry.getValue()));
        return Collections.unmodifiableMap(map);
    }
}
