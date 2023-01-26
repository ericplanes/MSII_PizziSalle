package com.salle.domain.delegation;

import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.NotFoundException;

public class DelegationBCN extends AbsDelegation {

    //Constructor
    public DelegationBCN() {
        super();
        try {
            this.delegationCode = ConstantUtilities.delegationBCN;
            this.name = ConstantUtilities.getDelegationString(this.delegationCode);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
