package org.tp24.utils;

import org.tp24.data.Beneficiary;

import java.text.MessageFormat;

public class FileUtils {

    private FileUtils() {
    }

    public static String GenerateBeneficiaryPath(Beneficiary beneficiary)
    {
        return MessageFormat.format( "./src/main/resources/Beneficiary_{0}",beneficiary.id());
    }

    public static String BeneficiarytoText(Beneficiary beneficiary)
    {
        return MessageFormat.format("{0},{1},{2}", beneficiary.id(), beneficiary.name(), beneficiary.lastName());

    }
}
