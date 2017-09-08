package agility.season;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import agility.season.model.Activite;
import agility.season.model.Chien;
import agility.season.model.Resultat;

public class AgilityData {
    private List<Chien> chiens = new ArrayList<Chien>();

    public AgilityData() {
	init();
    }

    public void addChien(Chien chien) {
	chiens.add(chien);
    }

    public List<Chien> getChiens() {
	return chiens;
    }

    public void init() {
	Chien hyuma = new Chien("Hyuma");
	addChien(hyuma);

	List<Resultat> resultats = new ArrayList<>();
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.APRIL, 15), "Hannut", true));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.APRIL, 15), "Hannut", "0", 10));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.APRIL, 22), "Senzeille", "20", 20));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.APRIL, 22), "Senzeille", "10", 16));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.APRIL, 23), "Mont-Saint-Guibert", true));
	resultats
		.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.APRIL, 23), "Mont-Saint-Guibert", "0", 3));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.MAY, 7), "Dampremy", "15", 26));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.MAY, 7), "Dampremy", true));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.MAY, 20), "Canis", "15", 61));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.MAY, 20), "Canis", true));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.MAY, 21), "Canis", "13.82", 83));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.MAY, 21), "Canis", "15", 98));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.JUNE, 3), "Feschaux", true));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.JUNE, 3), "Feschaux", "5", 9));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.JUNE, 4), "Feschaux", "10", 16));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.JUNE, 4), "Feschaux", "5", 25));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.JUNE, 10), "Bellecourt", true));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.JUNE, 10), "Bellecourt", "5", 20));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.JUNE, 18), "Marbais", "10", 14));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.JUNE, 18), "Marbais", true));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.JULY, 1), "CCSL", true));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.JULY, 1), "CCSL", "0", 7));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.JULY, 8), "Arlon", "5", 18));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.JULY, 9), "Arlon", "5", 19));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.JULY, 8), "Arlon", "5", 16));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.JULY, 9), "Arlon", "5", 18));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.JULY, 21), "Courcelles", true));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.JULY, 21), "Courcelles", "0", 4));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.JULY, 22), "Crisnee", "15", 19));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.JULY, 22), "Crisnee", "5", 12));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.JULY, 23), "Seneffe", true));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.JULY, 23), "Seneffe", "0", 4));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.AUGUST, 26), "Genebos", "10", 66));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.AUGUST, 26), "Genebos", true));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.AUGUST, 27), "Genebos", "0", 20));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.AUGUST, 27), "Genebos", "0", 1));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.SEPTEMBER, 2), "Jamioulx", "10", 26));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.SEPTEMBER, 2), "Jamioulx", true));
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2017, Month.SEPTEMBER, 3), "Jamioulx", "5", 17));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2017, Month.SEPTEMBER, 3), "Jamioulx", "8.03", 26));

	hyuma.setResultats(resultats);

	System.out.println(hyuma + " : " + resultats.size() + " résultats enregistrés.");

	System.out.println("-----------------------------------------------------------------------------");
	List<Resultat> tableau = tableau(hyuma, Activite.AGILITY);
	tableau.stream().forEach(r -> System.out.println(r));

	int sumAgility = tableau.stream().mapToInt(Resultat::getClassement).sum();
	System.out.println("-----------------------------------------------------------------------------");
	System.out.println(String.format("Total Agility   : %45d", sumAgility));
	System.out.println("-----------------------------------------------------------------------------");
	tableau = tableau(hyuma, Activite.JUMPING);
	tableau.stream().forEach(r -> System.out.println(r));

	int sumJumping = tableau.stream().mapToInt(Resultat::getClassement).sum();
	System.out.println("-----------------------------------------------------------------------------");
	System.out.println(String.format("Total Jumping   : %45d", sumJumping));
	System.out.println("-----------------------------------------------------------------------------");
	System.out.println(String.format("Total           : %45d", (sumAgility + sumJumping)));
    }

    public List<Resultat> tableau(Chien chien, Activite activite) {
	List<Resultat> result;

	result = chien.getResultats().stream()
		.filter(r -> activite.equals(r.getActivite()))
		.sorted()
		.limit(15)
		.collect(Collectors.toList());

	return result;
    }
}
