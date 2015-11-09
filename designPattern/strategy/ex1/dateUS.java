import java.text.*;
import java.util.*;

class DateUS implements DateGlobal
{
	private DateFormat formatus;

	public DateUS()
	{
		formatus = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
	}

	public DateFormat getFormat()
	{
		return formatus;
	}
}