package org.beer30.mrpickles;

import org.springframework.data.domain.AuditorAware;

/**
 * Created with IntelliJ IDEA.
 * User: tsweets
 * Date: 3/30/13
 * Time: 5:57 PM
 */
public class AuditorAwareBean implements AuditorAware<String> {
    public String getCurrentAuditor() {
        return "MrPickles";
    }
}
