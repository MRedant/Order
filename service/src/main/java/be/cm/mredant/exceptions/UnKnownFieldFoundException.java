package be.cm.mredant.exceptions;

public class UnKnownFieldFoundException extends OrderException {

    public UnKnownFieldFoundException(String field, String resource, CrudAction crudAction) {
        super(String.format("No %s can be present on a %s object passed for %s", field, resource, crudAction.getLabel()));
    }

    public enum CrudAction{

        CREATE("creation"),
        READ("retrieving"),
        UPDATE("updating"),
        DELETE("deletion");

        private String label;

        CrudAction(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}
