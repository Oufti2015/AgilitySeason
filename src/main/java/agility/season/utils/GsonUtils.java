package agility.season.utils;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

    public static Gson buildGson() {
	return Converters
		.registerOffsetDateTime(new GsonBuilder())
		.setPrettyPrinting()
		.serializeNulls()
		.create();
    }
}
