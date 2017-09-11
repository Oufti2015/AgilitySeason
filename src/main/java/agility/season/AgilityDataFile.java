package agility.season;

import java.io.File;
import java.io.IOException;

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
}
