package com.salle.domain.delegation;

import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.NotFoundException;

public class DelegationLLE extends AbsDelegation {

    //Constructor
    public DelegationLLE() {
        super();
        try {
            this.delegationCode = ConstantUtilities.delegationLLE;
            this.name = ConstantUtilities.getDelegationString(this.delegationCode);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
