package net.rithms.riot.api.endpoints.static_data.dto;

import net.rithms.riot.api.Dto;

import java.io.Serializable;

public class ReforgedRune extends Dto implements Serializable {

    private static final long serialVersionUID = 8589910883371420338L;

    private String runePathName;

    private int runePathId;

    private String name;

    private int id;

    private String key;

    private String shortDesc;

    private String longDesc;

    private String icon;

    public String getRunePathName() {
        return runePathName;
    }

    public int getRunePathId() {
        return runePathId;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return getId() + ": " + getName();
    }
}
