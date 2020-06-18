package core.helpers.enums;

public class CoreEnums {

    public enum ApplicationProperty {

        HOST;

        @Override
        public String toString() {
            return this.name().toLowerCase();
        }
    }
}
