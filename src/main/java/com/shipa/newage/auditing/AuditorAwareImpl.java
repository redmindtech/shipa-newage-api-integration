package com.shipa.newage.auditing;

import static com.shipa.newage.constants.Constants.DEFAULT_AUDITOR_NAME;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

/**
 * @author SureshKumar
 * 12-Sep-2023
 */

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
    public Optional<String> getCurrentAuditor(){
        return Optional.of(DEFAULT_AUDITOR_NAME);
    }
}