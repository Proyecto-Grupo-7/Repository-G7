package org.tp24.repository.BeneficiaryImpl;

import org.tp24.data.Beneficiary;
import java.util.ArrayList;
import java.util.List;


public class BeneficiarySearch {

    public static List<Beneficiary> searchByName(List<Beneficiary> beneficiaries, String name) {
        List<Beneficiary> foundBeneficiaries = new ArrayList<>();
        for (Beneficiary beneficiary : beneficiaries) {
            if (beneficiary.name().equals(name)) {
                foundBeneficiaries.add(beneficiary);
            }
        }
        return foundBeneficiaries;
    }

}
