package be.cm.mredant.exceptions;

public class EntryAlreadyExistsInDatabaseException extends OrderException {

    public EntryAlreadyExistsInDatabaseException(String entry, String databaseName) {
        super(String.format("%s already contains %s", databaseName, entry));
    }

}
