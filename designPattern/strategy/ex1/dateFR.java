import java.text.*;
import java.util.*;

class DateFR implements DateGlobal
{
	private DateFormat formatfr;

	public DateFR()
	{
		formatfr = DateFormat.getDateInstance(DateFormat.SHORT, Locale.UK);
	}

	public DateFormat getFormat()
	{
		return formatfr;
	}
}