package at.qe.skeleton.ui.controllers;

import at.qe.skeleton.ui.controllers.dialog.ModularDialogController;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.*;

@Getter
@Setter
@Component
@Scope("view")
public class CalenderController {

    @Autowired
    private ModularDialogController modularDialogController;

    private List<Date> invalidDates;
    private List<Integer> invalidDays;
    private Date minDate;
    private Date maxDate;
    private Date dateDe;

    private Date date;
    private Date time;


    private boolean time07_08;
    private boolean time08_09;
    private boolean time09_10;
    private boolean time10_11;
    private boolean time11_12;
    private boolean time12_13;
    private boolean time13_14;
    private boolean time14_15;
    private boolean time15_16;

    private boolean court1;
    private boolean court2;
    private boolean court3;
    private boolean court4;
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

        time07_08 = true;
        time08_09 = true;
        time09_10 = true;
        time10_11 = true;
        time11_12 = true;
        time12_13 = true;
        time13_14 = true;
        time14_15 = true;
        time15_16 = true;

        court1 = true;
        court2 = true;
        court3 = true;
        court4 = true;

    }

    public void onDateSelect(SelectEvent<Date> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }


    /* ******** DATEPICKER UPDATE LOGIC  ******** */

    public void updateDate(SelectEvent<Date> event) {
        // Update the date property with the selected date from the event
        // before updating check validity
        checkValidity(event.getObject(),minDate, maxDate);

    }

    public void checkValidity(Date date, Date minDate, Date maxDate){
        if(date.after(minDate) & date.before(maxDate)){
            setDate(date);
            flushDialogs();
            modularDialogController.showDialogTime();
            //showDialogTimes();
        }
    }

    /* ******** END  ******** */

    /* ******** TIMEPICKER UPDATE LOGIC  ******** */

    public void updateTime(SelectEvent<Date> event) {
        // Update the date property with the selected date from the event
        // before updating check validity
        this.time = event.getObject();
        System.out.println(this.time);

    }

    public void manipulateTime07_08(ActionEvent event) {
        this.time07_08 =  !time07_08;
        flushDialogs();
        modularDialogController.hideDialogTime();
        modularDialogController.showDialogCourts();
        //hideDialogTimes();
        //showDialogCourts();
    }
    public void manipulateTime08_09(ActionEvent event) {
        this.time08_09 = !time08_09;
        flushDialogs();
        modularDialogController.hideDialogTime();
        modularDialogController.showDialogCourts();
        //hideDialogTimes();
        //showDialogCourts();
    }
    public void manipulateTime09_10(ActionEvent event) {
        this.time09_10 = !time09_10;
        flushDialogs();
        modularDialogController.hideDialogTime();
        modularDialogController.showDialogCourts();
        //hideDialogTimes();
        //showDialogCourts();
    }
    public void manipulateTime10_11(ActionEvent event) {
        this.time10_11 = !time10_11;
        flushDialogs();
        modularDialogController.hideDialogTime();
        modularDialogController.showDialogCourts();
        //hideDialogTimes();
        //showDialogCourts();
    }
    public void manipulateTime11_12(ActionEvent event) {
        this.time11_12 = !time11_12;
        flushDialogs();
        modularDialogController.hideDialogTime();
        modularDialogController.showDialogCourts();
        //hideDialogTimes();
        //showDialogCourts();
    }
    public void manipulateTime12_13(ActionEvent event) {
        this.time12_13 = !time12_13;
        flushDialogs();
        modularDialogController.hideDialogTime();
        modularDialogController.showDialogCourts();
        //hideDialogTimes();
        //showDialogCourts();
    }
    public void manipulateTime13_14(ActionEvent event) {
        this.time13_14 = !time13_14;
        flushDialogs();
        modularDialogController.hideDialogTime();
        modularDialogController.showDialogCourts();
        //hideDialogTimes();
        //showDialogCourts();
    }
    public void manipulateTime14_15(ActionEvent event) {
        this.time14_15 = !time14_15;
        flushDialogs();
        modularDialogController.hideDialogTime();
        modularDialogController.showDialogCourts();
        //hideDialogTimes();
        //showDialogCourts();
    }
    public void manipulateTime15_16(ActionEvent event) {
        this.time15_16 = !time15_16;
        modularDialogController.hideDialogTime();
        modularDialogController.showDialogCourts();
        //hideDialogTimes();
        //showDialogCourts();
    }

    /* ******** END  ******** */

    /* ******** COURT-PICKER UPDATE LOGIC  ******** */

    public void pickCourt1(){
        flushDialogs();
        modularDialogController.showDialogConfirm();
        this.court1 = !court1;
    }
    public void pickCourt2(){
        flushDialogs();
        modularDialogController.showDialogConfirm();
        this.court2 = !court2;
    }
    public void pickCourt3(){
        flushDialogs();
        modularDialogController.showDialogConfirm();
        this.court3 = !court3;
    }
    public void pickCourt4(){
        flushDialogs();
        modularDialogController.showDialogConfirm();
        this.court4 = !court4;
    }

    /* ******** END  ******** */

    /* ******** DIALOGS LOGIC  ******** */

    public void returnToMainPage(){
        flushDialogs();
        //modularDialogController.hideDialogTime();
    }
    public void returnToTimes(){
        flushDialogs();
        //modularDialogController.hideDialogCourts();
        modularDialogController.showDialogTime();
    }
    public void returnToCourts(){
        flushDialogs();
        //modularDialogController.hideDialogConfirm();
        modularDialogController.showDialogCourts();
    }

    public void flushDialogs(){
        modularDialogController.hideDialogTime();
        modularDialogController.hideDialogCourts();
        modularDialogController.hideDialogConfirm();
    }


    /* ******** END  ******** */



    /*
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    */






}
