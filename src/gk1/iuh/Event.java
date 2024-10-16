/*
 * @ (#) Event.java       1.0
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package gk1.iuh;


import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * @description:
 * @author: Duc Thuan
 * @date: 16/10/2024
 * @version:    1.0
 * @created:
 */
public class Event {
    private final String eventCode;
    private String eventName;
    private LocalDate eventDate;
    private String location;
    private int participantNumber;
    private double cost;

    public Event() {
        this("","", LocalDate.now(),"",0,0.0);
    }

    public Event(String eventCode, String eventName,LocalDate eventDate, String location, int participantNumber, double cost) {
        this.eventCode = eventCode;
        this.setEventName(eventName);
        this.setEventDate(eventDate);
        this.setLocation(location);
        this.setParticipantNumber(participantNumber);
        this.setCost(cost);
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        if (eventCode == null || eventCode.charAt(0) == 'E') {
            throw new RuntimeException("Loi code");
        }
        for (int i = 1; i<eventCode.length(); i++) {
            if(!Character.isDigit(eventCode.charAt(i)))
                throw new RuntimeException("Loi code");
        }
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        if (eventName == null || eventName.length()==0)
            throw new RuntimeException("Loi name");
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location == null || location.length()==0)
            throw new RuntimeException("Loi dia chi");
        this.location = location;
    }

    public int getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(int participantNumber) {
        if (participantNumber<=0) {
            throw new RuntimeException("Loi nguoi");
        }
        this.participantNumber = participantNumber;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost<=0) {
            throw new RuntimeException("Loi cost");
        }
        this.cost = cost;
    }

    public double getCostPerParticipant() {
        return (cost * 1.1)/participantNumber;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.0");
        return String.format("| %s | %-25s | %s | %-15s | %d | %s | %s |", eventCode,
                eventName,dtf.format(eventDate), location, participantNumber,
                df.format(cost), df.format(getCostPerParticipant()));
    }
}
