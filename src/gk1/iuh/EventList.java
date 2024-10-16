package gk1.iuh;

import java.time.LocalDate;
import java.util.Arrays;

public class EventList {
    private Event[] ds;
    private int dem;

    public EventList() {
        this.ds = new Event[10];
    }

    public EventList(int dem) {
        if (dem<=0) {
            throw new RuntimeException("Loi kich thuoc");
        }
        ds = new Event[dem];
    }

    public boolean addDs(Event e) {
        if (e==null)
            throw new RuntimeException("event rong");
        for (int i = 0; i<dem; i++) {
            if (e.getEventCode().equalsIgnoreCase(ds[i].getEventCode()))
                throw new RuntimeException("Trung ma");
        }
        if (dem>= ds.length) {
            int newlength = (int) (ds.length * 1.5);
            Event[] temp = Arrays.copyOf(ds,newlength);
            for (int i = 0; i<newlength; i++) {
                temp[i] = e;
            }
            ds = temp;
        }
        this.ds[dem++] = e;
        return true;
    }

    public Event[] getDs() {
        return ds;
    }

    public boolean update(Event e) {
        for (Event event: ds) {
            if (event.getEventCode().equalsIgnoreCase(e.getEventCode())) {
                if (event.getEventDate().isAfter(LocalDate.now())) {
                    event.setEventName(e.getEventName());
                    event.setEventDate(e.getEventDate());
                    event.setLocation(e.getLocation());
                    event.setParticipantNumber(e.getParticipantNumber());
                    event.setCost(e.getCost());
                    return true;
                }
            }
        }

        return false;
    }

    public Event[] getEventsWithMaxParsInYear(int year) {
        int max =0;
        for (Event e: ds) {
            if (e.getEventDate().getYear() == year) {
                if (e.getParticipantNumber() >= max) {
                    max = e.getParticipantNumber();
                }
            }
        }
        int count = 0;
        for (Event e: ds) {
            if (e.getParticipantNumber() == max && e.getEventDate().getYear() == year) {
                count++;
            }

        }
        Event[] temp = new Event[count];
        int index = 0;
        for (Event e: ds) {
            if (e.getParticipantNumber()==max && e.getEventDate().getYear()==year) {
                temp[index++] = e;
            }
        }
        return temp;
    }

    public boolean remove(String ma) {
        for (int i = 0; i<dem; i++) {
            if (ds[i].getEventCode().equalsIgnoreCase(ma)) {
                for (int j = i; j<dem-1; j++){
                    ds[j] = ds[j+1];

                }
                dem--;
                ds[dem] = null;
                return true;
            }
        }
        return false;
    }

    public void sort() {
//        for (int i = 0; i<dem; i++) {
//            for (int j = i; j<dem-1; j++) {
//                if (ds[j].getEventCode().compareTo(ds[j+1].getEventCode())>0) {
//                    Event temp = ds[j];
//                    ds[j] = ds[j+1];
//                    ds[j+1] = temp;
//                }
//            }
//        }
        Arrays.sort(ds,0,dem,(h1,h2)->Integer.compare(h1.getParticipantNumber(),h2.getParticipantNumber()));
        Arrays.sort(ds,0,dem,(h1,h2)->h1.getEventCode().compareTo(h2.getEventCode()));
    }
}
