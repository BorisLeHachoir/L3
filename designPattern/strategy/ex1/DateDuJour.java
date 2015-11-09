import java.text.*;
import java.util.*;

class DateDuJour
{
	private DateGlobal currentDate_;
	private Date date;

	public DateDuJour(DateGlobal currentDate)
	{
		currentDate_ = currentDate;
		date = new Date();
	}

	public DateGlobal getDate()
	{
		return currentDate_;
	}

	public void setDate(DateGlobal d)
	{
		currentDate_ = d;
	}

	public void afficher()
	{
		System.out.println(currentDate_.getFormat().format(date));
	}
}