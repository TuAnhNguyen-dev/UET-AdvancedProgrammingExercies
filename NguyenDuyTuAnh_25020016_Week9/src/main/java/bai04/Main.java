package bai04;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Cross-platform file path handling demo.
 *
 * This demonstrates how to handle file paths correctly across Windows, Linux, and macOS
 * using File.separator and java.nio.file.Path API.
 */
public class Main {

  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  /**
   * Main method to demonstrate path handling approaches.
   *
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    logger.info("=== Cross-Platform File Path Handling Demo ===");
    logger.info("Operating System: {}", System.getProperty("os.name"));
    logger.info("Java Version: {}", System.getProperty("java.version"));

    demonstrateProblem();
    demonstrateSolution();
  }

  /**
   * Demonstrates the WRONG way to handle paths (hardcoded separators).
   * This will work on Windows but fail on Linux/macOS and vice versa.
   */
  private static void demonstrateProblem() {
    logger.info("\n--- ❌ THE PROBLEM: Hardcoded Path Separators ---");

    // Windows-specific hardcoded path (uses backslash \)
    String windowsPath = "C:\\Users\\data\\files\\test.txt";
    logger.warn("Windows hardcoded path: {}", windowsPath);

    // Linux/macOS-specific hardcoded path (uses forward slash /)
    String unixPath = "/home/user/data/files/test.txt";
    logger.warn("Unix hardcoded path: {}", unixPath);

    logger.warn("⚠️ These hardcoded paths won't work correctly on different operating systems!");
  }

  /**
   * Demonstrates the CORRECT way to handle paths across all operating systems.
   */
  private static void demonstrateSolution() {
    logger.info("\n--- ✅ THE SOLUTION: Cross-Platform Path Handling ---");

    // Solution 1: Using File.separator
    logger.info("\n1. Using File.separator:");
    String separator = File.separator;
    logger.info("File.separator: '{}'", separator);

    // Build path dynamically
    String dynamicPath1 = "." + separator + "data" + separator + "files" + separator + "test.txt";
    logger.info("Dynamically built path: {}", dynamicPath1);

    // Solution 2: Using java.nio.file.Path (RECOMMENDED)
    logger.info("\n2. Using java.nio.file.Path (RECOMMENDED):");
    Path path = Paths.get(".", "data", "files", "test.txt");
    logger.info("Path object: {}", path);
    logger.info("Absolute path: {}", path.toAbsolutePath());

    // Solution 3: Creating directories and files safely
    logger.info("\n3. Creating directories safely:");
    Path dataDir = Paths.get(".", "data");
    Path filesDir = dataDir.resolve("files");

    logger.info("Data directory path: {}", dataDir);
    logger.info("Files directory path: {}", filesDir);

    try {
      if (!Files.exists(dataDir)) {
        Files.createDirectories(dataDir);
        logger.info("✅ Created data directory");
      } else {
        logger.info("ℹ️ Data directory already exists");
      }

      if (!Files.exists(filesDir)) {
        Files.createDirectories(filesDir);
        logger.info("✅ Created files directory");
      } else {
        logger.info("ℹ️ Files directory already exists");
      }
    } catch (Exception e) {
      logger.error("Error creating directories", e);
    }

    // Solution 4: Resolving paths
    logger.info("\n4. Resolving paths:");
    Path testFile = filesDir.resolve("test.txt");
    logger.info("Test file path: {}", testFile);

    // Write sample content
    try {
      Files.writeString(testFile, "Test content\n");
      logger.info("✅ Successfully wrote test file: {}", testFile);

      // Read content back
      String content = Files.readString(testFile);
      logger.info("✅ Successfully read test file content:\n{}", content);
    } catch (Exception e) {
      logger.error("Error handling file", e);
    }

    logger.info("\n=== Summary ===");
    logger.info("✅ Use java.nio.file.Path for all path operations");
    logger.info("✅ Use Paths.get(...) with varargs for path construction");
    logger.info("✅ Use path.resolve() for appending path segments");
    logger.info("✅ Avoid hardcoded File.separator or path separators");
    logger.info("✅ This ensures your code works on all operating systems!");

    logger.info("\n=== Cross-Platform File Path Handling Demo Completed ===");
  }
}

