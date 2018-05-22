package net.rithms.riot.api.endpoints.static_data.dto;

import net.rithms.riot.api.Dto;

import java.io.Serializable;
import java.util.List;

public class ReforgedRunePath extends Dto implements Serializable {

    private static final long serialVersionUID = 8887189073494912973L;

    private List<ReforgedRuneSlot> slots;

    private String icon;

    private int id;

    private String key;

    private String name;

    public List<ReforgedRuneSlot> getSlots() {
        return slots;
    }

    public String getIcon() {
        return icon;
    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}
