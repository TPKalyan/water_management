package org.example.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.utils.Command.Action.ADD_GUESTS;
import static org.example.utils.Command.Action.ALLOT_WATER;
import static org.example.utils.Command.Action.BILL;

class FileUtilsTest {

    @Test
    void shouldParseAllotWaterCommand() {
        List<Command> commands = FileUtils.parse("ALLOT_WATER 2 3:4");
        Command allotWaterCommand = commands.get(0);


        assertThat(allotWaterCommand.getAction()).isEqualTo(ALLOT_WATER);
        assertThat(allotWaterCommand.getApartmentSize()).isEqualTo(2);
        assertThat(allotWaterCommand.getCorporationWaterRatio()).isEqualTo(3);
        assertThat(allotWaterCommand.getBoreWaterRatio()).isEqualTo(4);
    }

    @Test
    void shouldParseAddGuestsCommand() {
        List<Command> commands = FileUtils.parse("ADD_GUESTS 2");
        Command addGuestsCommand = commands.get(0);

        assertThat(addGuestsCommand.getAction()).isEqualTo(ADD_GUESTS);
        assertThat(addGuestsCommand.getNumberOfGuests()).isEqualTo(2);
    }

    @Test
    void shouldParseBillCommand() {
        List<Command> commands = FileUtils.parse("BILL");
        Command billCommand = commands.get(0);

        assertThat(billCommand.getAction()).isEqualTo(BILL);
    }
}