package com.salle.domain.delegation;

import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.NotFoundException;

public class DelegationTAR extends AbsDelegation {

    //Constructor
    public DelegationTAR() {
        super();
        try {
            this.delegationCode = ConstantUtilities.delegationTAR;
            this.name = ConstantUtilities.getDelegationString(this.delegationCode);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
