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
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import googlephonelib.proxies.constants.Constants;

/**
 * Tests whether a phone number matches a valid pattern. Note this doesn't verify the number is actually in use, which is impossible to tell by just looking at a number itself.
 */
public class PhonenumberValid extends CustomJavaAction<java.lang.Boolean>
{
	private java.lang.String inputString;
	private java.lang.String region;

	public PhonenumberValid(IContext context, java.lang.String inputString, java.lang.String region)
	{
		super(context);
		this.inputString = inputString;
		this.region = region;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		ILogNode logger = Core.getLogger(Constants.getPhonenumberLogNode());
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		try {
			  PhoneNumber NumberProto = phoneUtil.parse(inputString, region.toUpperCase());
			  return phoneUtil.isValidNumber(NumberProto);
			} catch (NumberParseException e) {
				logger.warn("NumberParseException was thrown: " + e.toString());
			  return false;
		}		
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "PhonenumberValid";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
