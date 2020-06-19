package core.helpers.enums;

public class TestDataEnums {

    public enum City {

        MOSCOW("Москва", "г Москва"), LIPETSK("Липецк", "г Липецк, Липецкая обл"),
        VORONEZH("Воронеж", "г Воронеж, Воронежская обл"), TYUMEN("Тюмень", "г Тюмень, Тюменская обл");

        private String value;
        private String location;

        City(String value, String location) {
            this.value = value;
            this.location = location;
        }

        public String getLocation() {
            return this.location;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }
}
