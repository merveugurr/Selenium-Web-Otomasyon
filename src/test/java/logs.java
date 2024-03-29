
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class logs implements TestWatcher {
    Log log = new Log();

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        log.info(testName + " SUCCEED");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String testFailCause = cause.getMessage() ;
        log.error(testName + " FAILED with cause : " + testFailCause);
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        log.warn("Test disabled because of " + reason.get());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        log.warn("Test is aborted");
    }
}
