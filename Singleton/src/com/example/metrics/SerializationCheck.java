package com.example.metrics;

import java.io.*;

public class SerializationCheck {

    public static void main(String[] args) throws Exception {
        MetricsRegistry registry = MetricsRegistry.getInstance();
        registry.increment("SERIALIZATION_TEST");

        String fileName = "metrics-registry.ser";

        // serialize
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(registry);
        }

        // deserialize
        MetricsRegistry deserialized;
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {
            deserialized = (MetricsRegistry) in.readObject();
        }

        System.out.println("Original hash  = " + registry.hashCode());
        System.out.println("Deserialized hash = " + deserialized.hashCode());
        System.out.println("SERIALIZATION_TEST = "
                + deserialized.getCount("SERIALIZATION_TEST"));
    }
}
