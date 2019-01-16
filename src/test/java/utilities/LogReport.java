package utilities;

import org.apache.log4j.Hierarchy;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LogReport extends Helper implements ITestListener, IInvokedMethodListener {
	private static Logger log;

	public LogReport() {
		log = Logger.getLogger(LogReport.class);
		PropertyConfigurator.configure("logfile.properties");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// log.info("Executing Test: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String args = returnParameters(result);
		String output = String.format("%s %s %s", result.getName(), args, "PASSED");
		log.info(output);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String args = returnParameters(result);
		String errorMsg = returnErrorMessage(result);

		String output = String.format("%s %s %s %s", result.getName(), args, "FAILED", errorMsg);
		log.error(output);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String args = returnParameters(result);
		String errorMsg = returnErrorMessage(result);
		String output = String.format("%s %s %s %s", result.getName(), args, "SKIPPED", errorMsg);
		log.info(output);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		log.info("Begin Test");
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("Test Complete");

	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		String args = returnParameters(testResult);
		if (args.isEmpty())
			args = "None";
		String textMsg = "About to begin executing the following test : " + testResult.getName() + " Parameters: "
				+ args;
		log.info(textMsg);

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		String args = returnParameters(testResult);
		if (args.isEmpty())
			args = "None";
		String textMsg = "Completed executing the following test : " + testResult.getName() + " Parameters: " + args;
		log.info(textMsg);

	}

}
