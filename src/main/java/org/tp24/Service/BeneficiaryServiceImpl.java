package org.tp24.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tp24.data.Beneficiary;
import org.tp24.exception.BeneficiaryNotFoundException;
import org.tp24.exception.SavingBeneficiaryException;
import org.tp24.repository.BeneficiaryRepository;

public class BeneficiaryServiceImpl {

    private BeneficiaryRepository beneficiaryRepository;
    private static final Logger LOGGER = LogManager.getLogger();

    public BeneficiaryServiceImpl(BeneficiaryRepository beneficiaryRepository) {
        this.beneficiaryRepository = beneficiaryRepository;
    }


    public List<Beneficiary> findAll() throws BeneficiaryNotFoundException
    {
        var Beneficiarys= beneficiaryRepository.findAll();
        if (Beneficiarys.isEmpty())
        {
            throw new BeneficiaryNotFoundException();
        }
        return Beneficiarys;
    }

    public Beneficiary save(Beneficiary beneficiary) throws SavingBeneficiaryException {
        Optional<Beneficiary> optBeneficiary = beneficiaryRepository.save(beneficiary);

        return optBeneficiary.orElseThrow(() -> new SavingBeneficiaryException(beneficiary));

    }
}
