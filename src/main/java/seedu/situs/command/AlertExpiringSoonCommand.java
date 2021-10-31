package seedu.situs.command;

import seedu.situs.exceptions.SitusException;

import seedu.situs.localtime.CurrentDate;
import seedu.situs.storage.Storage;

import java.io.IOException;
import java.time.LocalDate;

//@@author mudkip8

public class AlertExpiringSoonCommand extends Command {

    private static long expiryThreshold;

    public AlertExpiringSoonCommand() {
        try {
            expiryThreshold = new Storage().loadExpiryThreshold();
        } catch (IOException | NumberFormatException e) {
            expiryThreshold = 5;
        }
    }

    public static long getExpiryThreshold() {
        return expiryThreshold;
    }

    public static void setExpiryThreshold(long expiryThreshold) throws IOException {
        AlertExpiringSoonCommand.expiryThreshold = expiryThreshold;
        new Storage().writeThresholdData();
    }

    @Override
    public String run() throws SitusException {
        LocalDate expiryDateThreshold = CurrentDate.getCurrentDate().plusDays(expiryThreshold);

        return new ExpireCommand(expiryDateThreshold).run();
    }
}
