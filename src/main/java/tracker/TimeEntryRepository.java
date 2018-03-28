package tracker;

import java.util.List;
import java.time.LocalDate;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry any);

    public TimeEntry find(long l);

    public List<TimeEntry> list();

    public TimeEntry update(long eq, TimeEntry any) ;

    public void delete(long l) ;
}
