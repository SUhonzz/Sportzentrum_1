package at.qe.skeleton.ui.controllers.dialog;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * The ModularDialogController class serves as a basic implementation of a dialogue without requirements.
 */

@Component
@Scope("view")
public class ModularDialogController extends AbstractDialogController {

    @Override
    public void addLogicToShowDialog() {
        //No need for further logic
    }

    @Override
    public void addLogicToHideDialog(){
        //No need for further logic
    }
}
