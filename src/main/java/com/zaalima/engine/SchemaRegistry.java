package com.zaalima.engine;

import java.util.HashMap;
import java.util.Map;

public class SchemaRegistry {

    private Map<String, String> schemas;

    public SchemaRegistry() {
        this.schemas = new HashMap<>();
        registerDefaults();
    }

    private void registerDefaults() {
        schemas.put("TRADE", "TradeProto");
        schemas.put("ORDER", "OrderProto");
    }

    public void register(String eventType, String schemaClassName) {
        schemas.put(eventType, schemaClassName);
    }

    public String getSchemaFor(String eventType) {
        if (!schemas.containsKey(eventType)) {
            return "UNKNOWN_SCHEMA";
        }
        return schemas.get(eventType);
    }

    public boolean isRegistered(String eventType) {
        return schemas.containsKey(eventType);
    }

    public Map<String, String> getAllSchemas() {
        return schemas;
    }

    @Override
    public String toString() {
        return "SchemaRegistry{schemas=" + schemas + "}";
    }
}
