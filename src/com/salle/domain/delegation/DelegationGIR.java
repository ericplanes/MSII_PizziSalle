package com.salle.domain.delegation;

import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.NotFoundException;

public class DelegationGIR extends AbsDelegation {

    //Constructor
    public DelegationGIR() {
        super();
        try {
            this.delegationCode = ConstantUtilities.delegationGIR;
            this.name = ConstantUtilities.getDelegationString(this.delegationCode);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
