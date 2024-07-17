package ui;

import model.PCLists;
import model.parts.CPU;
import model.parts.Case;
import model.parts.Cooler;
import model.parts.GPU;
import model.parts.Monitor;
import model.parts.Motherboard;
import model.parts.OperatingSystem;
import model.parts.PowerSupply;
import model.parts.RAM;
import model.parts.Storage;
import model.PC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PCBuilder {

    private PCLists pcList;

    private Scanner scanner;
    private boolean isPCBuilderRunning;
    private boolean isReviewing;

    // EFFECTS: creates an instance of the PCBuilder console ui application
    public PCBuilder() {
        runPCBuilder();
    }

     // MODIFIES: this
    // EFFECTS: initializes the application with the starting values
    public void init() {
        this.pcList = new PCLists();
        this.scanner = new Scanner(System.in);
        this.isPCBuilderRunning = true;
    }

    // EFFECTS: runs an instance of the PCBuilder console ui application
    private void runPCBuilder() {
        boolean isPCBuilderRunning = true;
        String command = null;

        init();

        while (isPCBuilderRunning) {
            displayMainMenu();
            command = scanner.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                isPCBuilderRunning  = false;
            } else {
                processMainMenuCommands(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // EFFECTS: displays a list of commands that can be used in the main menu
    private void displayMainMenu() {
        System.out.println("\nMAIN MENU");
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add a PC");
        System.out.println("\ts -> select a PC");
        System.out.println("\tl -> review selected PC");
        System.out.println("\tv -> view list of PCs");
        System.out.println("\tr -> remove a PC");
        System.out.println("\tc -> copy a PC");
        System.out.println("\tp -> purchase a PC");
        System.out.println("\tq -> quit pc builder ap");
    }

    // MODIFIES: this
    // EFFECTS: processes the user's input in the main menu
    @SuppressWarnings("methodlength")
    public void processMainMenuCommands(String input) {
        printDivider();
        switch (input) {
            case "a":
                addNewPC();
                break;
            case "s":
                selectPC();
                break;
            case "l":
                reviewPC();
                break;
            case "v":
                viewPC();
                break;
            case "r":
                removePC();
                break;
            case "c":
                copyPC();
                break;
            case "p":
                purchasePC();
                break;
            case "q":
                quitApplication();
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
        }
        printDivider();
    }

    //EFFECTS: prints out the name of each computer and given the cost of each computer
    public void viewPC() {
        for (int i = 0; i < pcList.returnComputers().size(); i++) {
            PC viewedPC = pcList.returnComputers().get(i);
            int totalCosts = viewedPC.costSingles() + viewedPC.costsMultiples();
            System.out.print("\n" + viewedPC.getName() + ", Cost:" + totalCosts);
        }
    }

    //MODIFIES: PCList
    //EFFECTS: adds a new PC with in an inputed name to PCList,
    //does not add PC if there is another PC with the same name as the input
    public void addNewPC() {
        System.out.println("please input name");
        String name = this.scanner.next();
        PC newPC = new PC(name);
        boolean test = this.pcList.addPC(newPC);
        if (test) {
            this.pcList.addPC(newPC);
            System.out.println("PC Added!");
        } else {
            System.out.println("Error PC " + name + " already exists");
        }
        
    }

    //MODIFIES: PCList
    //EFFECTS: changes selectedPC to a PC with input name in the list,
    //does not selected PC if no such PC exists in PCList
    public void selectPC() {
        String name = null;
        System.out.println("please input name");
        name = scanner.next();
        pcList.selectPC(name);
        System.out.println("selected " + pcList.getSelectedComputer().getName());
    }

    //EFFECTS: runs the menu for reviewing and changing an individual PC
    public void reviewPC() {
        boolean isReviewing = true;
        String commandPC = null;

        while (isReviewing) {
            displayPCMenu();
            commandPC = scanner.next();
            commandPC = commandPC.toLowerCase();

            if (commandPC.equals("b")) {
                isReviewing = false;
            } else {
                processPCMenuCommands(commandPC);
            }
        }

        System.out.println("\nBack to Main Menu");
    }

    //MODIFIES: PCList
    //EFFECTS: removes a PC with the input name in the list,
    //does not removes PC if no such PC exists in PCList
    public void removePC() {
        String name = null;
        System.out.println("please input name");
        name = scanner.next();
        if (pcList.removePC(name)) {
            pcList.removePC(name);
            System.out.println("PC" + name + "Remove!");
        } else {
            System.out.println("Error no such PC exists");
        }
    }

    //MODIFIES: PCList
    //EFFECTS: copys selectedPC and adds that PC with the name (nameofPC)copy
    //does not copy PC if selectedPC is null
    public void copyPC() {
        if (pcList.copyPC()) {
            pcList.copyPC();
            System.out.println("PC Copied!");
        } else {
            System.out.println("Error selected Computer is Null");
        }
    }

    //MODIFIES: PCList
    //EFFECTS: removes selectedPC and returns of the total cost of that PC as if it was purchased
    //does not purchases or return cost if selectedPC is null
    public void purchasePC() {
        PC pc = pcList.getSelectedComputer();
        if (pcList.getSelectedComputer() != null) {
            int totalCosts = pcList.getSelectedComputer().costSingles() + pcList.getSelectedComputer().costsMultiples();
            pcList.removePC(pcList.getSelectedComputer().getName());
            pcList.setSelectedComputerToNull();
            System.out.println("Parts for Computer purchased for" + totalCosts + " $");
        } else {
            System.out.println("Error no such computer is selected");
        }
    }

    // MODIFIES: this
    // EFFECTS: prints a closing message and marks the program as not running
    public void quitApplication() {
        System.out.println("Thanks for using the PC Builder app!");
        System.out.println("Have a good day!");
        this.isPCBuilderRunning = false;
    }

    // EFFECTS: displays a list of commands that can be used in the menu for reviewing and changing a PC
    private void displayPCMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add a part to PC");
        System.out.println("\tr -> to return costs of PC");
        System.out.println("\tn -> to change the name of a PC");
        System.out.println("\ts -> to remove a part from PC");
        System.out.println("\tb -> to go back to main menu");
    }

    // MODIFIES: PCList
    // EFFECTS: processes the user's input in the menu for reviewing and changing a PC
    @SuppressWarnings("methodlength")
    public void processPCMenuCommands(String input) {
        printDivider();
        switch (input) {
            case "a":
                addNewPCPart();
                break;
            case "r":
                returnCostFirstHalf();
                returnCostSecondHalf();
                int total = 0;
                total += pcList.getSelectedComputer().costSingles() + pcList.getSelectedComputer().costsMultiples();
                System.out.println(total);
                break;
            case "n":
                changeNamePC();
                break;
            case "s":
                removePCPart();
                break;
            case "b":
                backToMainMenu();
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
        }
        printDivider();
    }

    //MODIFIES: PC
    //EFFECTS: processes that user input for what part should be add to the PC
    //as of what model of that part it will be
    @SuppressWarnings("methodlength")
    public void addNewPCPart() {
        PC pc = pcList.getSelectedComputer();
        String input = "";
        String name = "";
        addNewpcPartMenu();
        System.out.println("Type in the part you want added");
        input = scanner.next();
        System.out.println("Type in the model of the part");
        name = scanner.next();
        printDivider();
        switch (input) {
            case "case":
                Case newCase = new Case(name);
                pc.addCase(newCase);
                break;
            case "cooler":
                Cooler newCooler = new Cooler(name);
                pc.addCooler(newCooler);
                break;
            case "cpu":
                CPU newCpu = new CPU(name);
                pc.addCPU(newCpu);
                break;
            case "gpu":
                GPU newGpu = new GPU(name);
                pc.addPartsGPU(newGpu);
                break;
            case "monitor":
                Monitor newDesktop = new Monitor(name);
                pc.addMonitor(newDesktop);
                break;
            case "motherboard":
                Motherboard newMotherboard = new Motherboard(name);
                pc.addMotherboard(newMotherboard);
                break;
            case "operating system":
                OperatingSystem newSystem = new OperatingSystem(name);
                pc.addOperatingSystem(newSystem);
                break;
            case "ram":
                RAM newRam = new RAM(name);
                pc.addPartsRAM(newRam);
                break;
            case "power supply":
                PowerSupply newPowerSupply = new PowerSupply(name);
                pc.addPowerSupply(newPowerSupply);
                break;
            case "storage":
                Storage newStorage = new Storage(name);
                pc.addStorage(newStorage);
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
        }
        printDivider();
    }

    // EFFECTS: displays a list of parts that can be added
    // as well as the command to insert each of them into the PC
    public void addNewpcPartMenu() {
        System.out.println("\nSelect part to add:");
        System.out.println("\tcase -> add a Case");
        System.out.println("\tcooler -> add a Cooler");
        System.out.println("\tcpu -> add a CPU");
        System.out.println("\tgpu -> add a GPU");
        System.out.println("\tmonitor -> add a Monitor");
        System.out.println("\tmotherboard -> add a Motherboard");
        System.out.println("\toperating system -> add a Operating System");
        System.out.println("\tram -> add a Memory Stick");
        System.out.println("\tpower supply -> add a Power Supply");
        System.out.println("\tstorage -> add Storage");
    }

    //MODIFIES: PC
    //EFFECTS: processes that user input for what part should removed from the PC
    //as well as for the parts for where there can be multiple of, which models to remove
    @SuppressWarnings("methodlength")
    public void removePCPart() {
        PC pc = pcList.getSelectedComputer();
        String input = "";
        String name = "";
        removeNewpcPartMenu();
        System.out.println("Type in the part you want added");
        input = scanner.next();
        System.out.println("Type in the model of the part (only for necessity RAM, GPU, monitors, and storage)");
        name = scanner.next();
        printDivider();
        switch (input) {
            case "case":
                pc.removeCase();
                break;
            case "cooler":
                pc.removeCooler();
                break;
            case "cpu":
                pc.removeCPU();
                break;
            case "gpu":
                pc.removeGPU(name);
                break;
            case "monitor":
                pc.removeMonitor(name);
                break;
            case "motherboard":
                pc.removeMotherboard();
                break;
            case "operating system":
                pc.removeOperatingSystem();
                break;
            case "ram":
                pc.removeRAM(name);
                break;
            case "power supply":
                pc.removePowerSupply();
                break;
            case "storage":
                pc.removeMonitor(name);
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
        }
        printDivider();
    }

    // EFFECTS: displays a list of parts that can be removed
    // as well as the command to remove each of them from the PC
    public void removeNewpcPartMenu() {
        System.out.println("\nSelect part to add:");
        System.out.println("\tcase -> remove a Case");
        System.out.println("\tcooler -> remove a Cooler");
        System.out.println("\tcpu -> remove a CPU");
        System.out.println("\tgpu -> remove a GPU");
        System.out.println("\tmonitor -> remove a Monitor");
        System.out.println("\tmotherboard -> remove a Motherboard");
        System.out.println("\toperating system -> remove a Operating System");
        System.out.println("\tram -> remove a Memory Stick");
        System.out.println("\tpower supply -> remove a Power Supply");
        System.out.println("\tstorage -> remove Storage");
    }

    //EFFECTS: returns part of the cost of an individual computer
    public void returnCostFirstHalf() {
        PC pc = pcList.getSelectedComputer();
        System.out.println("Case Cost:" + pc.getCase().getCost());
        System.out.println("Case Cost:" + pc.getCooler().getCost());
        System.out.println("Case Cost:" + pc.getCPU().getCost());
        int costGpuAdd = 0;
        for (int i = 0; i < pc.getGPU().size(); i++) {
            costGpuAdd += pc.getGPU().get(i).getCost();
        }
        System.out.println("Case Cost:" + costGpuAdd);
        int costDesktopAdd = 0;
        for (int i = 0; i < pc.getMonitor().size(); i++) {
            costDesktopAdd += pc.getMonitor().get(i).getCost();
        }
        System.out.println("Case Cost:" + costDesktopAdd);
    }

    //EFFECTS: returns the other half of the cost of an individual computer
    public void returnCostSecondHalf() {
        PC pc = pcList.getSelectedComputer();
        System.out.println("Case Cost:" + pc.getMotherboard().getCost());
        System.out.println("Case Cost:" + pc.getOperatingSystem().getCost());
        int costRamAdd = 0;
        for (int i = 0; i < pc.getRAM().size(); i++) {
            costRamAdd += pc.getRAM().get(i).getCost();
        }
        System.out.println("Case Cost:" + costRamAdd);
        int costStorageAdd = 0;
        for (int i = 0; i < pc.getStorage().size(); i++) {
            costStorageAdd += pc.getStorage().get(i).getCost();
        }
        System.out.println("Case Cost:" + costStorageAdd);
    }

    //MODIFIES: PC
    //EFFECTS: changes the name of an individual PC
    public void changeNamePC() {
        PC pc = pcList.getSelectedComputer();
        String name = null;
        name = scanner.nextLine();
        pc.namePC(name);
        System.out.println("PC's name has been changed to " + name + "!");
    }

    // MODIFIES: this
    // EFFECTS: prints a message and marks the program to go back to main menu
    public void backToMainMenu() {
        System.out.println("Back to Main Menu");
        this.isReviewing = false;
    }

    // EFFECTS: prints out a line of dashes to act as a divider
    private void printDivider() {
        System.out.println("------------------------------------");
    }
}
