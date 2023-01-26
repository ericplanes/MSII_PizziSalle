package com.salle.api;

import com.salle.application.controller.DelegationController;
import com.salle.utilities.ApiStrings;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.Print;
import com.salle.utilities.exceptions.InvalidParameterException;

public class InitialPageView {

    Print console;

    public InitialPageView(Print console) {
        this.console = console;
    }

    public DelegationController logInPage() {
        DelegationController delegationController = null;
        int answer;
        boolean delegationCorrect = false;
        while (!delegationCorrect) {
            try {
                console.printTitle(ApiStrings.initialPageTitle);
                console.printWHITE(ApiStrings.selectDelegation);
                console.space(1);
                console.printWHITE(ApiStrings.readNavigationAnswer);
                answer = Integer.parseInt(console.readORANGE());
                switch (answer) {
                    case 1:
                        delegationController = new DelegationController(ConstantUtilities.delegationBCN);
                        break;
                    case 2:
                        delegationController = new DelegationController(ConstantUtilities.delegationGIR);
                        break;
                    case 3:
                        delegationController = new DelegationController(ConstantUtilities.delegationTAR);
                        break;
                    case 4:
                        delegationController = new DelegationController(ConstantUtilities.delegationLLE);
                        break;
                    default:
                        throw new InvalidParameterException();
                }

            } catch (Exception e) {
                console.printErrorMessage(ApiStrings.answerBetween1and4);
            }
            if (delegationController != null) delegationCorrect = true;
        }
        console.clear();
        return delegationController;
    }
}
