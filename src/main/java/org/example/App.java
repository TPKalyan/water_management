package org.example;

import org.example.manager.WaterManager;
import org.example.model.apartment.Apartment;
import org.example.model.apartment.ThreeBHK;
import org.example.model.apartment.TwoBHK;
import org.example.utils.Command;
import org.example.utils.FileUtils;

import java.util.List;

import static org.example.utils.FileUtils.readFile;

public class App {

    private static Apartment apartment;
    private static final WaterManager manager = new WaterManager();

    public static void main(String[] args)  {
        String filePath = args[0];

        List<Command> commands = FileUtils.parse(readFile(filePath));
        commands.forEach(command -> {
            switch (command.getAction()) {
                case ALLOT_WATER:
                    apartment = createApartmentAndAllotWater(command);
                    break;
                case ADD_GUESTS:
                    addGuests(apartment, command.getNumberOfGuests());
                    break;
                case BILL:
                    System.out.format("%s %s", apartment.getTotalWaterUsed(), apartment.getBillPerMonth());
                    break;
                default:
                    throw new RuntimeException("Invalid command");
            }
        });
    }

    private static void addGuests(Apartment apartment, Integer numberOfGuests) {
        manager.allotTankerWater(apartment, numberOfGuests);
    }

    private static Apartment createApartmentAndAllotWater(Command command) {
        Apartment apartment = isTwoBHK(command.getApartmentSize()) ? new TwoBHK() : new ThreeBHK();
        return manager.allotWater(apartment, command.getCorporationWaterRatio(), command.getBoreWaterRatio());
    }

    private static boolean isTwoBHK(Integer apartmentSize) {
        return apartmentSize == 2;
    }
}