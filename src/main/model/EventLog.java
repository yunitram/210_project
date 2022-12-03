package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Represents a log of events.
 */
// taken from alarmsystem
public class EventLog implements Iterable<Event> {
    private static EventLog theLog;
    private Collection<Event> events;

    private EventLog() {
        events = new ArrayList<Event>();
    }
	
	/**
	 * Gets instance of EventLog - creates it
	 * if it doesn't already exist.
	 * (Singleton Design Pattern)
	 * @return  instance of EventLog
	 */
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }
        return theLog;
    }
	
	/**
	 * Adds an event to the event log.
	 * @param e the event to be added
	 */
    public void logEvent(Event e) {
        events.add(e);
    }


    @Override
	public Iterator<Event> iterator() {
        return events.iterator();
    }
}
