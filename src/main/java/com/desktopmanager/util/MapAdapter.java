package com.desktopmanager.util;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.desktopmanager.persistence.MapElements;

/**
 * @author Mariusz Czarny
 *
 */
public class MapAdapter extends XmlAdapter<MapElements[], Map<String, String>> {
    public MapElements[] marshal(Map<String, String> elements) throws Exception {
        MapElements[] mapElements = new MapElements[elements.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : elements.entrySet()) {
            mapElements[i++] = new MapElements(entry.getKey(), entry.getValue());
        }

        return mapElements;
    }

    public Map<String, String> unmarshal(MapElements[] elements) throws Exception {
        Map<String, String> map = new HashMap<>();
        for (MapElements element : elements) {
            map.put(element.key, element.value);
        }
        return map;
    }
}
