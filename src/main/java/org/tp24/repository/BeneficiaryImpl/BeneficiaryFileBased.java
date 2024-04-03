package org.tp24.repository.BeneficiaryImpl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.tp24.data.Beneficiary;
import org.tp24.repository.BeneficiaryRepository;
import org.tp24.utils.BeneficiaryConstants;
import org.tp24.utils.FileUtils;

public class BeneficiaryFileBased implements BeneficiaryRepository {

    @Override
    public List<Beneficiary> findAll() {
        Path path = Paths.get(BeneficiaryConstants.BENEFICIARY_DATA_PATH);
        try {

            Stream<String> stream = Files.lines(path);

            return stream.map(this::build).toList();

        } catch (IOException ex) {
            Logger.getLogger(BeneficiaryFileBased.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

    private Beneficiary build(String text) {
        String[] beneficiaryArray = text.split(",");
        return new Beneficiary(beneficiaryArray[0], beneficiaryArray[1], beneficiaryArray[2]);
    }

    public Optional<Beneficiary> save(Beneficiary beneficiary) {
        Path path = Paths.get(BeneficiaryConstants.BENEFICIARY_DATA_PATH);

        String content = FileUtils.BeneficiarytoText(beneficiary);

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, java.nio.file.StandardOpenOption.APPEND);) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(beneficiary);
    }

   
}
