import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// Events to be printed in the following order
// desc | start time | end time | date | venue | priority | tagDesc
// completeStatus will not be shown to the user, only for internal tracking

// not yet added: option to add notes to entry

class Entry implements Serializable {
	/**
	 * Entry class implements serializable for input/output stream in Storage
	 * class so as to preserve the object properties of Entry
	 */
	private static final long serialVersionUID = 1L;
	String description;
	String priority;
	String tagDesc;
	String venue;
	String date;
	int startTime, endTime;
	int completeStatus;


	// constructor
	public Entry(String[] data) {

	}
	
	public Entry(Entry copy){
		description = copy.description;
		priority = copy.priority;
		tagDesc = copy.tagDesc;
		venue = copy.venue;
		date = copy.date;
		startTime = copy.startTime;
		endTime = copy.endTime;
		completeStatus = copy.completeStatus;
	}

	public Entry() {
	}

	public String getDesc() {
		return description;
	}

	// description of event/task
	public void setDesc(String desc) {
		this.description = desc;
	}

	public int getStart() {
		return startTime;
	}

	// start time (displayed in 24h format)
	public void setStart(int start) {
		this.startTime = start;
	}

	public int getEnd() {
		return endTime;
	}

	// end time (displayed in 24h format)
	public void setEnd(int end) {
		this.endTime = end;
	}

	public String getDate() {
		return date;
	}

	// date displayed as e.g. Mon, Dec 14, 2012
	public void setDate(int _date) {

		int month = (_date / 10000) % 100;
		int day = _date / 1000000;
		int year = _date % 10000;

		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		Date date = cal.getTime();
		// Transformation of the date
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
		this.date = sdf.format(date);

	}

	public String getVenue() {
		return venue;
	}

	// venue of the event, identified by @location
	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getPriority() {
		return priority;
	}

	// priority, identified by !H/M/L for high/medium/low
	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTagDesc() {
		return tagDesc;
	}

	// hashtag desc, identified by #tagname
	public void setTagDesc(String tagDesc) {
		this.tagDesc = tagDesc;
	}

	public int getCompleteStatus() {
		return completeStatus;
	}

	// completed (1 is completed, 0 is uncompleted)
	public void setCompleteStatus(int completeStatus) {
		this.completeStatus = completeStatus;
	}

	// for printing of entries
	public String toString() {
		return this.getDesc() + " " + this.getStart() + " " + this.getEnd()
				+ " " + this.getDate() + " " + this.getVenue() + " "
				+ this.getPriority() + " " + this.getTagDesc();
	}

}
