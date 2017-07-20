package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    // Map to store time entry
    private Map<Long, TimeEntry> timeEntryMap = new HashMap();
    private long timeEnrtyId = 0;

    public TimeEntry create(TimeEntry timeEntry) {

        TimeEntry createdTimeEntry = new TimeEntry(getTimeEntryId(), timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryMap.put(createdTimeEntry.getId(), createdTimeEntry);

        return createdTimeEntry;

    }

    // increment timeId
    private long getTimeEntryId() {
        return ++timeEnrtyId;
    }

    public TimeEntry find(long timeId) {
        return timeEntryMap.get(timeId);
    }

    public List<TimeEntry> list() {
        List<TimeEntry> timeEntryList = new ArrayList<>(timeEntryMap.values());
        return timeEntryList;
    }

    public TimeEntry update(long timeId, TimeEntry timeEntry) {

        timeEntry = new TimeEntry(timeId, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryMap.put(timeId, timeEntry);
        return timeEntryMap.get(timeId);
    }

    public void delete(long timeId) {
        timeEntryMap.remove(timeId);
    }
}

