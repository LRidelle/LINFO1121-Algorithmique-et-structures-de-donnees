import java.util.*;

public class Contaminate {
    /**
     * Vous recevez en entree un dictionnaire personne -> ensemble de lieux dans lesquelles cette personne
     * va *chaque jour*. Chaque personne se trouvant dans un de ces lieux sera contaminé le jour d'apres.
     *
     * On vous demande de retourner le graphe des personnes qu'une personne contamine, sous la forme d'un dictionnaire
     * contaminant -> ensemble des contamines.
     *
     * Example:
     *
     * Alexandre -> {coiffeur, intermarche, examen}
     * Aurelien -> {coiffeur, delhaize}
     * Marine -> {examen}
     * Helene -> {delhaize, examen}
     *
     * Donnera le graphe suivant
     *
     * Alexandre -> {Aurelien, Marine, Helene}
     * Aurelien -> {Alexandre, Helene}
     * Marine -> {Alexandre, Helene}
     * Helene -> {Aurelien, Alexandre, Marine}
     *
     * Attention qu'une personne n'est jamais dans son ensemble de contamines (Alexandre n'est pas un dans l'ensemble
     * d'Alexandre, ...)
     */
    public static Map<String, Set<String>> genGraph(Map<String, Set<String>> peopleToPlaces) {
        return null;
    }

    /**
     * Vous recevez en entree un dictionnaire personne -> ensemble de lieux dans lesquelles cette personne
     * va *chaque jour*. Chaque personne se trouvant dans un de ces lieux sera contaminé le jour d'apres.
     *
     * Par exemple, si Alice va chez le coiffeur (chaque jour) et que Bob va chez le coiffeur (chaque jour),
     * et que Alice est contaminee, alors Bob sera contamine le jour d'apres.
     *
     * Etant donne une personne initialement contaminee, combien de jour faudra t'il au minimum pour contaminer
     * tout le monde?
     *
     * (on vous assure qu'il y a moyen de contaminer tout le monde)
     *
     * @param first la seule personne initialement contaminee, au jour 0
     * @param peopleToPlaces dictionnaire personne -> ensemble de lieux
     * @return le nombre de jour nécessaire pour contaminer tout le monde à partir de la personne first.
     */
    public static int minTime(String first, Map<String, Set<String>> peopleToPlaces) {
        // D'abord, convertissons le probleme en un joli graphe
        // Si vous n'arrivez pas a coder la fonction genGraph, commentez cette ligne et decommentez celle en dessous.
        // La classe HelpMe qui vous est donnee ne fonctionne qu'avec les tests donnes. Sur INGInious, elle contient
        // l'implementation optimale.
        Map<String, Set<String>> graphe = HelpMe.genGraph(peopleToPlaces);
        //Map<String, Set<String>> graphe = HelpMe.genGraph(peopleToPlaces);

        // Vous etes libre d'utiliser le graphe ou pas, mais ca devrait vous simplifier la vie.
        // Il est obligatoire d'implementer genGraph cela dit, meme si vous ne l'utilisez pas.

        // TODO Le reste, c'est a vous de le faire!
        return -1;
    }
}
