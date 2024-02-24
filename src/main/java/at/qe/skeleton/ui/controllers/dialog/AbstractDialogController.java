package at.qe.skeleton.ui.controllers.dialog;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Component
@Scope("view")
public abstract class AbstractDialogController {

    private boolean dialogTime = false;
    private boolean dialogCourts = false;
    private boolean dialogConfirm = false;


    public boolean isDialogTime() {
        return this.dialogTime;
    }
    public boolean isDialogCourts() {
        return this.dialogCourts;
    }
    public boolean isDialogConfirm() {
        return this.dialogConfirm;
    }

    public void showDialogTime() {
        setDialogTime(true);
        addLogicToShowDialog();
    }
    public void showDialogCourts() {
        setDialogCourts(true);
        addLogicToShowDialog();
    }
    public void showDialogConfirm() {
        setDialogConfirm(true);
        addLogicToShowDialog();
    }

    public abstract void addLogicToShowDialog();

    public void hideDialogTime() {
        setDialogTime(false);
        addLogicToHideDialog();
    }
    public void hideDialogCourts() {
        setDialogCourts(false);
        addLogicToHideDialog();
    }
    public void hideDialogConfirm() {
        setDialogConfirm(false);
        addLogicToHideDialog();
    }

    public abstract void addLogicToHideDialog();
}

