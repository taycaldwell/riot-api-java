package net.rithms.riot.api.endpoints.static_data.dto;

import net.rithms.riot.api.Dto;

import java.io.Serializable;
import java.util.List;

public class ReforgedRuneSlot extends Dto implements Serializable {

    private static final long serialVersionUID = -546884086092344243L;

    private List<ReforgedRune> runes;

    public List<ReforgedRune> getRunes() {
        return runes;
    }
}
