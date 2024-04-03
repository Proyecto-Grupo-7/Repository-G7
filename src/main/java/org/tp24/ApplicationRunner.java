package org.tp24;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tp24.data.Beneficiary;
import org.tp24.exception.BeneficiaryException;
import org.tp24.Service.BeneficiaryServiceImpl;

import org.tp24.repository.BeneficiaryImpl.BeneficiaryFileBased;
import static org.tp24.repository.BeneficiaryImpl.BeneficiarySearch.searchByName;

public class ApplicationRunner {

    private static final Logger LOGGER = LogManager.getLogger(ApplicationRunner.class);

    public static void main(String[] args) throws BeneficiaryException {

        
        BeneficiaryServiceImpl BeneficiaryService = new BeneficiaryServiceImpl(new BeneficiaryFileBased());
        List<Beneficiary> Beneficiarys = BeneficiaryService.findAll();

        LOGGER.info(Beneficiarys);

        var beneficiary = new Beneficiary("678", "ANDRES", "PEREZ");
        var newBeneficiary = BeneficiaryService.save(beneficiary);

        LOGGER.info(newBeneficiary);

        System.out.println(BeneficiaryService.findAll());

        String nameToSearch = "pepe";
        List<Beneficiary> foundBeneficiaries = searchByName(Beneficiarys, nameToSearch);
        for (Beneficiary foundBeneficiary : foundBeneficiaries) {
            LOGGER.info(foundBeneficiary);
        }
    }
}
