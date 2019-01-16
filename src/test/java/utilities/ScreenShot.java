package utilities;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

public class ScreenShot extends TestListenerAdapter {

	private LocalDate date;
	private LocalTime time;
	private DateTimeFormatter dateFormatter;
	private DateTimeFormatter timeFormatter;
	private String location;
	String fileName;

	@Override
	public void onTestFailure(ITestResult context) {
		date = LocalDate.now(); 
		time = LocalTime.now();
		dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd"); 
		timeFormatter = DateTimeFormatter.ofPattern("hhmm"); 
		location = System.getProperty("user.dir") + "\\Screenshots\\";
		
		fileName = date.format(dateFormatter) + "T";
		fileName +=time.format(timeFormatter) + "-";
		fileName += context.getName();
		
		
		try {
			screenCapture_Robot();
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void screenCapture_Robot() throws IOException, HeadlessException, AWTException {
		// This code will capture screenshot of current screen
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

		// This will store screenshot on Specific location
		ImageIO.write(image, "png", new File(location + "\\" + fileName + ".png"));
	}

}
