package ca.bcit.safetymap.data;


import com.google.android.gms.common.Feature;

import java.util.List;

public class CrimeLocations {

    private String type;
    private Feature[] features;

    public String getType() {
        return type;
    }

    public Feature[] getFeatures() {
        return features;
    }

    public static class Feature
    {

        private String type;
        private Properties properties;
        private Geometry geometry;

        public String getType() {
            return type;
        }

        public Properties getProperties() {
            return properties;
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public class Geometry
        {
            private String type;
            private double[][][] coordinates;

            public String getType() {
                return type;
            }

            public double[][] getCoordinates() {
                return coordinates[0];
            }

            public double[] getFirstCoordinate()
            {
                return coordinates[0][0];
            }
        }
        public class Properties
        {

            private int oBJECTID;
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
            private String latitude;
            private String longitude;

            public String getLatitude()
            {
                return latitude;
            }

            public void setLatitude(String latitude)
            {
                this.latitude = latitude;
            }

            public String getLongitude()
            {
                return longitude;
            }

            public void setLongitude(String longitude)
            {
                this.longitude = longitude;
            }

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
