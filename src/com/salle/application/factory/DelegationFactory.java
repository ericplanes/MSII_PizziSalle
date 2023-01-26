package com.salle.application.factory;

import com.salle.domain.delegation.*;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class DelegationFactory {
    public static AbsDelegation createDelegation(int delegationCode) throws InvalidParameterException {
        switch (delegationCode){
            case ConstantUtilities.delegationBCN:
                return new DelegationBCN();
            case ConstantUtilities.delegationGIR:
                return new DelegationGIR();
            case ConstantUtilities.delegationLLE:
                return new DelegationLLE();
            case ConstantUtilities.delegationTAR:
                return new DelegationTAR();
            default:
                throw new InvalidParameterException("The delegation code wasn't correct.");
        }
    }
}
