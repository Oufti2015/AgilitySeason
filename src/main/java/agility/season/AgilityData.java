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
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2018, Month.APRIL, 14), "Hannut", true));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2018, Month.APRIL, 14), "Hannut", "0", 6));

	hyuma.setResultats(resultats);

	Chien muse = new Chien("Muse");
	addChien(muse);

	resultats = new ArrayList<>();
	resultats.add(new Resultat(Activite.AGILITY, LocalDate.of(2018, Month.APRIL, 14), "Hannut", true));
	resultats.add(new Resultat(Activite.JUMPING, LocalDate.of(2018, Month.APRIL, 14), "Hannut", "15",
		200 - (3000 - 2846)));

	muse.setResultats(resultats);
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
