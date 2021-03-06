// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package googlephonelib.actions;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import googlephonelib.proxies.constants.Constants;

/**
 * Parses a string and returns it in proto buffer format. This method will throw a NumberParseException if the number is not considered to be a possible number. Note that validation of whether the number is actually a valid number for a particular region is not performed. This can be done separately with PhonenumberValid function.
 */
public class ParsePhonenumber extends CustomJavaAction<java.lang.String>
{
	private java.lang.String inputString;
	private java.lang.String region;

	public ParsePhonenumber(IContext context, java.lang.String inputString, java.lang.String region)
	{
		super(context);
		this.inputString = inputString;
		this.region = region;
	}

	@Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
		ILogNode logger = Core.getLogger(Constants.getPhonenumberLogNode());
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		try {
			  PhoneNumber NumberProto = phoneUtil.parse(inputString, region.toUpperCase());
			  return phoneUtil.format(NumberProto, PhoneNumberFormat.INTERNATIONAL);
			} catch (NumberParseException e) {
				logger.warn("NumberParseException was thrown: " + e.toString());
			  return null;
		}
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "ParsePhonenumber";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
