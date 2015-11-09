import java.text.*;
import java.util.*;

class DateStandard implements DateGlobal
{
	private DateFormat formatIntl;

	public DateStandard()
	{
		formatIntl = new SimpleDateFormat("yyyy-MM-dd");
	}

	public DateFormat getFormat()
	{
		return formatIntl;
	}
}