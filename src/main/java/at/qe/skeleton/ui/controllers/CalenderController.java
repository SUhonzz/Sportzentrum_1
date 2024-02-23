package at.qe.skeleton.ui.controllers;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Scope("view")
public class CalenderController {

    private List<Date> invalidDates;
    private List<Integer> invalidDays;
    private Date minDate;
    private Date maxDate;
    private Date dateDe;
    private Date date;


    @PostConstruct
    public void init() {
        invalidDates = new ArrayList<>();
        Date today = new Date();
        invalidDates.add(today);


        long oneDay = 24 * 60 * 60 * 1000;

        for (int i = 0; i < 5; i++) {
            invalidDates.add(new Date(invalidDates.get(i).getTime() + oneDay));
        }

        //?
        invalidDays = new ArrayList<>();
        invalidDays.add(0); /* the first day of week is disabled */
        invalidDays.add(3);

        //min date = today; max date = 2 weeks (still to handle (Tennis-club))
        minDate = new Date(today.getTime());
        maxDate = new Date(today.getTime() + (14 * oneDay));

        /*
        Calendar tmp = Calendar.getInstance();
        tmp.set(Calendar.HOUR_OF_DAY, 9);
        tmp.set(Calendar.MINUTE, 0);
        tmp.set(Calendar.SECOND, 0);
        tmp.set(Calendar.MILLISECOND, 0);

        minTime = tmp.getTime();

        tmp = Calendar.getInstance();
        tmp.set(Calendar.HOUR_OF_DAY, 17);
        tmp.set(Calendar.MINUTE, 0);
        tmp.set(Calendar.SECOND, 0);
        tmp.set(Calendar.MILLISECOND, 0);

        //maxTime =  tmp.getTime();

        minDateTime = new Date(today.getTime() - (7 * oneDay));
        maxDateTime = new Date(today.getTime() + (7 * oneDay));
        */

        dateDe = GregorianCalendar.getInstance().getTime();
        //dateTimeDe = GregorianCalendar.getInstance().getTime();
    }

    public void onDateSelect(SelectEvent<Date> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
