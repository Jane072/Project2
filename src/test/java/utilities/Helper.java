package utilities;

import org.testng.ITestResult;

public class Helper {
	String returnParameters(ITestResult result) {
		String params = "";
		if (result.getParameters().length != 0) {

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + ",";
			}
			params = "(" + params.substring(0,params.length()-1) + ")";
		}

		return params;
	}

	String returnErrorMessage(ITestResult result) {
		Throwable failureException = result.getThrowable();
		if (failureException instanceof AssertionError) {
			if (failureException.getMessage() != null) {
				return failureException.getMessage();
			} else {
				return "Received java.lang.AssertionError with null message";
			}
		} else {
			return result.getThrowable().getMessage();
		}
	}
}
