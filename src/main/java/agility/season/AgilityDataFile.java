package agility.season;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import agility.season.model.Chien;
import agility.season.model.Resultat;
import agility.season.utils.GsonUtils;
import lombok.extern.log4j.Log4j;
import sst.common.file.output.OutputFile;
import sst.textfile.InputTextFile;
import sst.textfile.InputTextFileImpl;

@Log4j
public class AgilityDataFile {

    private final String filename;

    public AgilityDataFile(String filename) {
	super();
	this.filename = filename;
    }

    public AgilityData load() {
	System.out.println("Loading...");
	AgilityData result = null;
	// JSON from file to Object
	try {
	    InputTextFile textFile = new InputTextFileImpl(new File(filename));
	    result = GsonUtils.buildGson().fromJson(textFile.oneLine(), AgilityData.class);
	} catch (IOException e) {
	    log.fatal("Cannot read file " + filename, e);
	    System.exit(-1);
	}

	if (result == null) {
	    result = new AgilityData();
	}
	print(result);
	return result;
    }

    public void save(AgilityData chiens) {
	System.out.println("Saving...");
	try (OutputFile file = new OutputFile(new File(filename))) {
	    // Object to JSON in file
	    file.println(GsonUtils.buildGson().toJson(chiens));
	} catch (IOException e) {
	    log.fatal("Cannot write file " + filename, e);
	    System.exit(-1);
	}
    }

    private void print(AgilityData result) {
	List<Chien> chiens = result.getChiens();

	chiens.stream()
		.sorted()
		.forEach(chien -> printChien(chien));
    }

    private void printChien(Chien chien) {

	System.out.println("" + chien);
	System.out.println();

	List<Resultat> resultats = chien.getResultats();
	List<Resultat> sortedList = resultats.stream().sorted(new Comparator<Resultat>() {
	    @Override
	    public int compare(Resultat a, Resultat b) {
		int i = a.getDate().compareTo(b.getDate());
		if (i == 0) {
		    i = a.getActivite().compareTo(b.getActivite());
		}
		return i;
	    }
	}).collect(Collectors.toList());

	int i = 1;
	for (Resultat r : sortedList) {
	    System.out.println(String.format("%02d - %s", i++, r));
	}
	System.out.println();

    }
}
