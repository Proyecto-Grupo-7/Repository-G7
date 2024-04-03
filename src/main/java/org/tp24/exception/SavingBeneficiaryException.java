package org.tp24.exception;

import org.tp24.data.Beneficiary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tp24.ApplicationRunner;

public class SavingBeneficiaryException extends BeneficiaryException {
    private static final Logger LOGGER = LogManager.getLogger(ApplicationRunner.class);
    public SavingBeneficiaryException(Beneficiary beneficiary) {
        LOGGER.info("Saving Beneficiary");
    }
}
