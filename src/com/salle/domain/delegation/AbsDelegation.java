package com.salle.domain.delegation;

public abstract class AbsDelegation {
    String name;
    int delegationCode;

    public AbsDelegation() {}

    public String getName() {
        return name;
    }

    public int getDelegationCode() {
        return delegationCode;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Delegation: " + this.name;
        return str;
    }
}
