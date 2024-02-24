package at.qe.skeleton.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Reservation {

    private String name;
    private String hash;
    private Date date;
    private Date startDate;
    private Date endDate;
    private Integer courtID;


    public Reservation(String name, String hash, Date date, Date startDate, Date endDate, Integer courtID){
        setName(name);
        setHash(hash);
        setDate(date);
        setStartDate(startDate);
        setEndDate(endDate);
        setCourtID(courtID);
    }
}
