package com.lukaklacar.binaryrepository.settings;

public class BinaryRepositorySettings {

    private String dataLocation;

    BinaryRepositorySettings(String dataLocation) {
        this.dataLocation = dataLocation;
    }

    public static BinaryRepositorySettingsBuilder builder() {
        return new BinaryRepositorySettingsBuilder();
    }

    public String getDataLocation() {
        return this.dataLocation;
    }

    public void setDataLocation(String dataLocation) {
        this.dataLocation = dataLocation;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof BinaryRepositorySettings)) return false;
        final BinaryRepositorySettings other = (BinaryRepositorySettings) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$dataLocation = this.getDataLocation();
        final Object other$dataLocation = other.getDataLocation();
        if (this$dataLocation == null ? other$dataLocation != null : !this$dataLocation.equals(other$dataLocation))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $dataLocation = this.getDataLocation();
        result = result * PRIME + ($dataLocation == null ? 43 : $dataLocation.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof BinaryRepositorySettings;
    }

    public String toString() {
        return "com.lukaklacar.binaryrepository.settings.BinaryRepositorySettings(dataLocation=" + this.getDataLocation() + ")";
    }

    public static class BinaryRepositorySettingsBuilder {
        private String dataLocation;

        BinaryRepositorySettingsBuilder() {
        }

        public BinaryRepositorySettings.BinaryRepositorySettingsBuilder dataLocation(String dataLocation) {
            this.dataLocation = dataLocation;
            return this;
        }

        public BinaryRepositorySettings build() {
            return new BinaryRepositorySettings(dataLocation);
        }

        public String toString() {
            return "com.lukaklacar.binaryrepository.settings.BinaryRepositorySettings.BinaryRepositorySettingsBuilder(dataLocation=" + this.dataLocation + ")";
        }
    }
}
