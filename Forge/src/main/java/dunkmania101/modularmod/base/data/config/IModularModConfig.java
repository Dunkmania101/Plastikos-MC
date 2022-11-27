package dunkmania101.modularmod.base.data.config;

import java.util.List;

public interface IModularModConfig {
    default void setup() {
    }

    String getStringValue(String id);
    int getIntValue(String id);
    float getFloatValue(String id);
    double getDoubleValue(String id);
    List<?> getListValue(String id);
}
