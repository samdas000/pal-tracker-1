package tracker;

import tracker.TimeEntry;
import tracker.TimeEntryRepository;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long, TimeEntry> entries = new HashMap<>();
    private Long generatedId = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry createdTimeEntry = new TimeEntry(generatedId, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        entries.put(createdTimeEntry.getId(), createdTimeEntry);
        generatedId++;
        return createdTimeEntry;
    }

    @Override
    public TimeEntry find(long l) {
        return entries.get(l);
    }

    @Override
    public List<TimeEntry> list() {
        ArrayList timeEntries = new ArrayList(entries.values());
        return timeEntries;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry updatedTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        entries.put(id, updatedTimeEntry);
        return updatedTimeEntry;
    }

    @Override
    public void delete(long l) {
        entries.clear();
    }
}
