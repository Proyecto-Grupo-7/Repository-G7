package org.tp24.repository;

import java.util.List;
import java.util.Optional;

import org.tp24.data.Beneficiary;
import org.tp24.exception.SavingBeneficiaryException;

public interface BeneficiaryRepository {

    default List<Beneficiary> findAll() {return null;}

    default Optional<Beneficiary> save(Beneficiary beneficiary)
    {
        return null;
    }

    default List<Beneficiary> search(String name, String lastName) {return null;}

}

