package org.tp24.exception;

import org.tp24.data.Beneficiary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tp24.ApplicationRunner;

public class BeneficiaryNotFoundException extends BeneficiaryException{
    private static final Logger LOGGER = LogManager.getLogger(ApplicationRunner.class);
    public BeneficiaryNotFoundException (Beneficiary beneficiary)
    {
        super();
    }

    public BeneficiaryNotFoundException() {
        LOGGER.info("Beneficiary Not Found");
    }
}
