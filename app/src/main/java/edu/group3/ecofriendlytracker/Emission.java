package edu.group3.ecofriendlytracker;

import java.util.HashMap;

/**
 *
 * @author altaf
 */
public class Emission {
    private final static HashMap<String, Double> emissionMap = new HashMap<>();
    
    static {
        emissionMap.put("CAR_GASOLINE", 0.16388);
        emissionMap.put("CAR_DIESEL", 0.16977);
        emissionMap.put("CAR_ELECTRIC", 0.0);
        emissionMap.put("CAR_HYBRID", 0.11897);
        emissionMap.put("MOTORCYCLE_GASOLINE", 0.11590);
        emissionMap.put("MOTORCYCLE_ELECTRIC", 0.00929);
        emissionMap.put("PUBLIC_TRANSPORTATION_BUS", 0.22187);
        emissionMap.put("PUBLIC_TRANSPORTATION_TRAIN", 0.22187);
        emissionMap.put("NON_EMISSION_CYCLING", 0.0);
        emissionMap.put("NON_EMISSION_WALKING", 0.0);
        emissionMap.put("NGP_LPG_LOW", 0.00267);
        emissionMap.put("NGP_LPG_MEDIUM", 0.00517);
        emissionMap.put("NGP_LPG_HIGH", 0.15632);
        emissionMap.put("NGP_GENSET", 0.00783);
        emissionMap.put("RE_SOLAR_PANEL", 0.0);
    }
    
    public static String formIdParser(Form form) {
        String subCatId, specificId;
        String emissionKey = "", additionalId = "";
        
        String subCatIdTemp = form.subCategory
                .toUpperCase()
                .replace(" ", "_")
                .replace("-", "_");
        
        if (subCatIdTemp.contains("NATURAL")) {
            subCatId = "NGP";
        } else if (subCatIdTemp.contains("RENEWABLE")) {
            subCatId = "RE";
        } else {
            subCatId = subCatIdTemp;
        }
        
        String specificIdTemp = form.specific
                .toUpperCase()
                .replace(" ", "_");
        
        if (form.specific.toUpperCase().contains("LPG")) {
            specificId = "LPG";
            
            additionalId = form.additionalOption
                    .replace("temperature", "")
                    .toUpperCase();
            
        } else if (form.specific.toUpperCase().contains("GENERATOR")) {
            specificId = "GENSET";
        } else {
            specificId = specificIdTemp;
        }
        
        String emissionKeyTemp = subCatId + "_" + specificId;
        emissionKey += additionalId.isEmpty() ? emissionKeyTemp : (emissionKeyTemp + "_" + additionalId);
        emissionKey = emissionKey.strip();
        
        return emissionKey;
    }
    
    public static double getEmissionAmount(String key) {
        return emissionMap.get(key);
    }
}
