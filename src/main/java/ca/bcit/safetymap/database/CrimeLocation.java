package ca.bcit.safetymap.database;


import com.google.android.gms.common.Feature;

import java.util.List;

public class CrimeLocation {

    private String type;
    private List<Feature> features = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public class Feature
    {

        private String type;

        private Properties properties;

        private Geometry geometry;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }

        public class Geometry
        {
            private String type;

            private List<Double> coordinates = null;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<Double> getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(List<Double> coordinates) {
                this.coordinates = coordinates;
            }
        }
        public class Properties
        {

            private Integer oBJECTID;

            private String fileNumber;

            private String occuranceYear;

            private String reportedDate;

            private String reportedTime;

            private String reportedWeekday;

            private String offense;

            private String offenseCategory;

            private String houseNumber;

            private String streetName;

            private String city;

            private String reportedDateText;

            private String reportedTimeText;

            public Integer getOBJECTID() {
            return oBJECTID;
        }

            public void setOBJECTID(Integer oBJECTID) {
            this.oBJECTID = oBJECTID;
        }

            public String getFileNumber() {
            return fileNumber;
        }

            public void setFileNumber(String fileNumber) {
            this.fileNumber = fileNumber;
        }

            public String getOccuranceYear() {
            return occuranceYear;
        }

            public void setOccuranceYear(String occuranceYear) {
            this.occuranceYear = occuranceYear;
        }

            public String getReportedDate() {
            return reportedDate;
        }

            public void setReportedDate(String reportedDate) {
            this.reportedDate = reportedDate;
        }

            public String getReportedTime() {
            return reportedTime;
        }

            public void setReportedTime(String reportedTime) {
            this.reportedTime = reportedTime;
        }

            public String getReportedWeekday() {
            return reportedWeekday;
        }

            public void setReportedWeekday(String reportedWeekday) {
            this.reportedWeekday = reportedWeekday;
        }

            public String getOffense() {
            return offense;
        }

            public void setOffense(String offense) {
            this.offense = offense;
        }

            public String getOffenseCategory() {
            return offenseCategory;
        }

            public void setOffenseCategory(String offenseCategory) {
            this.offenseCategory = offenseCategory;
        }

            public String getHouseNumber() {
            return houseNumber;
        }

            public void setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
        }

            public String getStreetName() {
            return streetName;
        }

            public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

            public String getCity() {
            return city;
        }

            public void setCity(String city) {
            this.city = city;
        }

            public String getReportedDateText() {
            return reportedDateText;
        }

            public void setReportedDateText(String reportedDateText) {
            this.reportedDateText = reportedDateText;
        }

            public String getReportedTimeText() {
            return reportedTimeText;
        }

            public void setReportedTimeText(String reportedTimeText) {
            this.reportedTimeText = reportedTimeText;
        }
        }
    }

}
