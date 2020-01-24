import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Normalize {
	private static final String DATE_FORMAT = "dd-M-yy hh:mm:ss a";
	private static final String DATE_FORMAT_ISO = "yyyy-MM-dd'T'HH:mm:ssZ";

	public static void main(String[] args) {

		/*
		 * Unicode validation Read csv file into an string array Do the normalize of
		 * data in the string array follow the order write the string array into an csv
		 * file
		 */

		// Print out to test the parameter
		System.out.println("Parameters: " + args[0] + "   " + args[1]);

		// read the path of csv file
		String csvFile = args[0];
		// output file names
		String outputFile = args[1];

		// TODO: read data from CSV file using method readDataFromCSV

		// TODO: write data from list of Info object to CSV file

	}

	private static void readDataFromCSV(String fileName) {
		// use BufferedReader to load the data from csv

		// decoder to convert from special character to Unicode
		/*
		 * CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
		 * decoder.onMalformedInput(CodingErrorAction.REPLACE);
		 * decoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
		 */

		BufferedReader br = null;
		Path pathToFile = Paths.get(fileName);

		String line = "";
		String cvsSplitBy = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";

		try {
			// read the first line form the text file
			br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8);

			// br = new BufferedReader(new FileReader(fileName));

			while ((line = br.readLine()) != null) {

				// use comma as separator, ignoring the commas inside double quotes
				String[] tokens = line.split(cvsSplitBy, -1);

				// TODO: Doing normalize each column to a standard

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void writeDataToCSV(String fileName, List<Info> listInfo) {
		// TODO: need to implement the writing process from list of Info objects to CSV
		// file
	}

	private static String timeStampFormatter(String timestamp) {
		// String dateInString = "22-1-2015 10:15:55 AM";
		LocalDateTime ldt = LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern(DATE_FORMAT));
		ZoneId losanglesZoneId = ZoneId.of("America/Los_Angeles");

		// LocalDateTime + ZoneId = ZonedDateTime
		ZonedDateTime pacificZonedDateTime = ldt.atZone(losanglesZoneId);
		ZoneId newYokZoneId = ZoneId.of("America/New_York");

		// DateTimeFormatter.ISO_LOCAL_DATE_TIME
		// Convert to different time zone
		ZonedDateTime easternDateTime = pacificZonedDateTime.withZoneSameInstant(newYokZoneId);

		DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT_ISO);

		return format.format(easternDateTime);
	}

	private static String zipCodeFormatter(String zcode) {

		StringBuilder zipcode = new StringBuilder(zcode);

		if (zipcode.length() < 5) {
			for (int z = zipcode.length(); z < 5; z++) {
				zipcode.insert(0, "0");
			}
		}
		return zipcode.toString();
	}

	//
	private static String fullNameFormatter(String name) {

		return name.toUpperCase();
	}

	private static String addressFormatter(String address) {
		// TODO: Need to validate Unicode
		
		return address;
	}

	private static int durationFormatter(String duration) {

		int sec_duration = (int) ((Integer.parseInt(duration.split(":")[0]) * 3600)
				+ (Integer.parseInt(duration.split(":")[1]) * 60) + Integer.parseInt(duration.split(":")[2])
				+ (Float.parseFloat(duration.split(":")[3])) / 100);

		return sec_duration;
	}

	private static int totalDuration(int foo, int bar) {
		return foo + bar;
	}

	private static String notesFormatter(String note) {
		return null;
	}

	/*
	 * function: createInfo
	 */
	private static Info createInfo(String[] metadata) {
		// ToDo: Implement the function of createInfo
		// define the attributes of Info object
		// return an Info instance
		return null;
	}
}

class Info {
	private String timestamp;
	private String zip;
	private String address;
	private String fullName;
	private float fooDuration;
	private float barDuration;
	private float totalDuration;
	private String notes;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public float getFooDuration() {
		return fooDuration;
	}

	public void setFooDuration(float fooDuration) {
		this.fooDuration = fooDuration;
	}

	public float getBarDuration() {
		return barDuration;
	}

	public void setBarDuration(float barDuration) {
		this.barDuration = barDuration;
	}

	public float getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(float totalDuration) {
		this.totalDuration = totalDuration;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Info [timestamp=" + timestamp + ", zip=" + zip + ", address=" + address + ", fullName=" + fullName
				+ ", fooDuration=" + fooDuration + ", barDuration=" + barDuration + ", totalDuration=" + totalDuration
				+ ", notes=" + notes + "]";
	}

}