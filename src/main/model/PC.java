package model;

import model.parts.Case;
import model.parts.Cooler;
import model.parts.CPU;
import model.parts.GPU;
import model.parts.Monitor;
import model.parts.Motherboard;
import model.parts.OperatingSystem;
import model.parts.PowerSupply;
import model.parts.RAM;
import model.parts.Storage;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONObject;
import persistence.Writable;



public class PC implements Writable {
    private String name;
    private Case box;
    private Cooler cooler;
    private CPU processor;
    private List<GPU> graphicsCard;
    private List<Monitor> monitor;
    private Motherboard motherboard;
    private OperatingSystem system;
    private PowerSupply pwrSupply;
    private List<RAM> memory;
    private List<Storage> storage;
    
    //EFFECTS:name on PC is set to pcName; 
    //creates an PC with no parts in it
    public PC(String pcName) {
        this.name = pcName;
        this.box = null;
        this.cooler = null;
        this.processor = null;
        this.graphicsCard = new ArrayList<>();
        this.monitor = new ArrayList<>();
        this.motherboard = null;
        this.system = null;
        this.pwrSupply = null;
        this.memory = new ArrayList<>();
        this.storage = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds a case to PC
    //no additional constrains
    //checks to see if there is a already a CPU installed
    //if there is return false, else return true and install the CPU
    public boolean addCase(Case box) {
        if (this.box == null) {
            this.box = box;
            return true;
        }  else {
            return false;
        }
    }

    //MODIFIES: this
    //EFFECTS: adds a cooler to PC
    //no additional constrains
    //checks to see if there is a already a cooler installed
    //if there is return false, else return true and install the cooler
    public boolean addCooler(Cooler cooler) {
        if (this.cooler == null) {
            this.cooler = cooler;
            return true;
        }  else {
            return false;
        }
    }

    //MODIFIES: this
    //EFFECTS: adds a case to PC
    //no additional constrains
    //checks to see if there is a already a CPU installed
    //if there is return false, else return true and install the CPU
    public boolean addCPU(CPU processor) {
        if (this.processor == null) {
            this.processor = processor;
            return true;
        }  else {
            return false;
        }
    }

    //MODIFIES: this
    //EFFECTS: adds a motherboard to PC
    //no additional constrains
    //checks to see if there is a already a motherboard installed
    //if there is return false, else return true and install the motherboard
    public boolean addMotherboard(Motherboard motherboard) {
        if (this.motherboard == null) {
            this.motherboard = motherboard;
            return true;
        }  else {
            return false;
        }
    }

    //MODIFIES: this
    //EFFECTS: adds a operating system to PC
    //no additional constrains
    //checks to see if there is a already a operating system installed
    //if there is return false, else return true and install the operating system
    public boolean addOperatingSystem(OperatingSystem system) {
        if (this.system == null) {
            this.system = system;
            return true;
        }  else {
            return false;
        }
    }

    //MODIFIES: this
    //EFFECTS: adds a operating system to PC
    //no additional constrains
    //checks to see if there is a already a operating system installed
    //if there is return false, else return true and install the operating system
    public boolean addPowerSupply(PowerSupply pwrSupply) {
        if (this.pwrSupply == null) {
            this.pwrSupply = pwrSupply;
            return true;
        }  else {
            return false;
        }
    }


    //MODIFIES: this
    //EFFECTS: adds object monitor to list monitor
    //that also have no additional constrains, as many monitors can be added
    public void addMonitor(Monitor monitor) {
        this.monitor.add(monitor);
    }

    //MODIFIES: this
    //EFFECTS: adds object storage to list storage
    //that also have no additional constrains, as many storage can be added
    public void addStorage(Storage storage) {
        this.storage.add(storage);
    }

    //MODIFIES: this
    //EFFECTS: adds RAM sticks to the PC
    //If the limit of RAM sticks determined by the number of slots in the motherboard
    //If the limit is reached, return false, else return true and install the RAM
    public boolean addPartsRAM(RAM ram) {
        if (motherboard == null) {
            return false;
        } else if (motherboard.getRamSlots() <= memory.size()) {
            return false;
        } else {
            memory.add(ram);
            return true;
        }
    }

    //MODIFIES: this
    //EFFECTS: adds GPUs to the PC
    //If the limit of GPUs determined by the number of slots in the motherboard
    //If the limit is reached, return false, else return true and install the GPU
    public boolean addPartsGPU(GPU gpu) {
        if (motherboard == null) {
            return false;
        } 
        if (motherboard.getGpuSlots() <= graphicsCard.size()) {
            return false;
        } else {
            graphicsCard.add(gpu);
            return true;
        }
    }

     //MODIFIES: this
    //EFFECTS: removes RAM sticks to the PC 
    //if there are no RAM sticks, returns false otherwise return true
    public boolean removeRAM(String ram) {
        if (memory.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < memory.size(); i++) {
                if (memory.get(i).getModel().equals(ram)) {
                    memory.remove(i);
                    return true;
                }
            }
            return false;
        } 
    }

    //MODIFIES: this
    //EFFECTS: removes GPUs from PC 
    //if there are no GPUs, returns false otherwise return true
    public boolean removeGPU(String gpu) {
        if (graphicsCard.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < graphicsCard.size(); i++) {
                if (graphicsCard.get(i).getModel().equals(gpu)) {
                    graphicsCard.remove(i);
                    return true;
                }
            }
            return false;
        }
    }

    //MODIFIES: this
    //EFFECTS: removes monitors from PC 
    //if there are no monitors return false otherwise return true
    public boolean removeMonitor(String monitorName) {
        if (monitor.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < monitor.size(); i++) {
                if (monitor.get(i).getModel().equals(monitorName)) {
                    monitor.remove(i);
                    return true;
                }
            }
            return false;
        }
    }

    //MODIFIES: this
    //EFFECTS: removes storage from PC 
    //if there are no storage return false otherwise return true
    public boolean removeStorage(String storageName) {
        if (storage.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < storage.size(); i++) {
                if (storage.get(i).getModel().equals(storageName)) {
                    storage.remove(i);
                    return true;
                }
            }
            return false;
        }
    }

    //MODIFIES: this
    //EFFECTS: removes Case from PC 
    // if there is no case return false otherwise return true
    public boolean removeCase() {
        if (box == null) {
            return false;
        } else {
            box = null;
            return true;
        }
    }

    //MODIFIES: this
    //EFFECTS: removes Case from PC 
    // if there is no case return false otherwise return true
    public boolean removeCooler() {
        if (cooler == null) {
            return false;
        } else {
            cooler = null;
            return true;
        }
    }

    //MODIFIES: this
    //EFFECTS: removes Case from PC 
    // if there is no case return false otherwise return true
    public boolean removeCPU() {
        if (processor == null) {
            return false;
        } else {
            processor = null;
            return true;
        }
    }

    //MODIFIES: this
    //EFFECTS: removes Case from PC 
    // if there is no case return false otherwise return true
    public boolean removeMotherboard() {
        if (motherboard == null) {
            return false;
        } else {
            motherboard = null;
            return true;
        }
    }

    //MODIFIES: this
    //EFFECTS: removes Case from PC 
    // if there is no case return false otherwise return true
    public boolean removeOperatingSystem() {
        if (system == null) {
            return false;
        } else {
            system = null;
            return true;
        }
    }

    //MODIFIES: this
    //EFFECTS: removes Case from PC 
    // if there is no case return false otherwise return true
    public boolean removePowerSupply() {
        if (pwrSupply == null) {
            return false;
        } else {
            pwrSupply = null;
            return true;
        }
    }

    //EFFECTS: gives a total cost of the PC parts for which there can be more than one
    public int costsMultiples() {
        int totalMultiples = 0;
        for (int i = 0; i < graphicsCard.size(); i++) {
            totalMultiples += graphicsCard.get(i).getCost();
        }
        for (int i = 0; i < memory.size(); i++) {
            totalMultiples += memory.get(i).getCost();
        }
        for (int i = 0; i < monitor.size(); i++) {  
            totalMultiples += monitor.get(i).getCost();
        }
        for (int i = 0; i < storage.size(); i++) {
            totalMultiples += storage.get(i).getCost();
        }
        
        return totalMultiples;
    }

    //EFFECTS: gives a total cost of the PC parts for which there can be only one
    public int costSingles() {
        int totalSingles = 0;
        if (box != null) {
            totalSingles = box.getCost();
        }
        if (cooler != null) {
            totalSingles += cooler.getCost();
        }
        if (processor != null) {
            totalSingles += processor.getCost();
        }
        if (motherboard != null) {
            totalSingles += motherboard.getCost();
        }
        if (system != null) {
            totalSingles += system.getCost();
        }
        if (pwrSupply != null) {
            totalSingles += pwrSupply.getCost();
        }    
        return totalSingles;
    }

    //MODIFIES: this
    //EFFECTS: changes the name of the PC, to string name
    public void namePC(String name) {
        this.name = name;
    }

    //EFFECTS: return name of the PC
    public String getName() {
        return name;
    }

    //EFFECTS: returns case from PC, returns is null if there is none
    public Case getCase() {
        return box;
    }

    //EFFECTS: returns case from PC, returns is null if there is none
    public Cooler getCooler() {
        return cooler;
    }

    //EFFECTS: returns case from PC, returns is null if there is none
    public CPU getCPU() {
        return processor;
    }

    //EFFECTS: returns case from PC, returns is null if there is none
    public List<GPU> getGPU() {
        return graphicsCard;
    }

    //EFFECTS: returns case from PC, returns is null if there is none
    public List<Monitor> getMonitor() {
        return monitor;
    }

    //EFFECTS: returns case from PC, returns is null if there is none
    public Motherboard getMotherboard() {
        return motherboard;
    }

    //EFFECTS: returns case from PC, returns is null if there is none
    public OperatingSystem getOperatingSystem() {
        return system;
    }

    //EFFECTS: returns case from PC, return is null if there is none
    public PowerSupply getPowerSupply() {
        return pwrSupply;
    }

    //EFFECTS: returns case from PC, return is null if there is none
    public List<RAM> getRAM() {
        return memory;
    }

    //EFFECTS: returns case from PC, return is null if there is none
    public List<Storage> getStorage() {
        return storage;
    }

    //MODIFIES: this
    //EFFECTS: sets case from PC to given case
    public void setCase(Case box) {
        this.box = box;
    }

    //MODIFIES: this
    //EFFECTS: sets cooler from PC to given cooler
    public void setCooler(Cooler cooler) {
        this.cooler = cooler;
    }

    //MODIFIES: this
    //EFFECTS: sets CPU from PC to given CPU
    public void setCPU(CPU processor) {
        this.processor = processor;
    }

    //MODIFIES: this
    //EFFECTS: sets motherboard from PC to given motherboard
    public void setMotherboard(Motherboard testMotherboard) {
        this.motherboard = testMotherboard;
    }

    //MODIFIES: this
    //EFFECTS: sets system from PC to given system
    public void setSystem(OperatingSystem system) {
        this.system = system;
    }

    //MODIFIES: this
    //EFFECTS: sets powersupply from PC to given powersupply
    public void setPowerSupply(PowerSupply pwrSupply) {
        this.pwrSupply = pwrSupply;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("case", box);
        json.put("cooler", cooler);
        json.put("cpu", processor);
        json.put("gpu", graphicsCard);
        json.put("monitor", monitor);
        json.put("motherboard", motherboard);
        json.put("operating system", system);
        json.put("power supply", pwrSupply);
        json.put("ram", memory);
        json.put("storage", storage);
        return json;
    }
}
