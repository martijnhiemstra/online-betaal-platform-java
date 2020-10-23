package nl.greenhighway.obp.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class TestUtils {

	private static final Path resourceDirectory = Paths.get("src", "test", "resources");

	private static final Path jsonDirectory = resourceDirectory.resolve("json");

	public static final String readFileContents(final String filename) throws IOException {
		Path path = jsonDirectory.resolve(filename);

		return Files.readString(path);
	}

}
