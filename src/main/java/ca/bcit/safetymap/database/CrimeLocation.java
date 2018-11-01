package ca.bcit.safetymap.database;


import com.google.android.gms.common.Feature;

import java.util.List;

public class CrimeLocation {

    public class Example {

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

    }
}
