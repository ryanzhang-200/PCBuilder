package model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

public class PCLists implements Writable {
    
    private List<PC> pcList = new ArrayList<>();
    private PC selectedComputer;

    //MODIFIES: this
    //EFFECTS: creates PCList with the PC selected computer
    // starts off as null
    public PCLists() {
        List<PC> pcList = new ArrayList<>();
        selectedComputer = null;
    }

    //EFFECTS: returns selectedComputer, returns null if none is selected
    public PC getSelectedComputer() {
        return selectedComputer;
    }

    //MODIFIES: this
    //EFFECTS: sets selectedComputer to null
    public void setSelectedComputerToNull() {
        selectedComputer = null;
    }

    //EFFECTS: returns pcList, returns null if none is selected
    public List<PC> returnComputers() {
        return pcList;
    }

    //MODIFIES: this
    //EFFECTS: changes selectedComputer to another PC on pcList
    public void selectPC(String name) {
        for (int i = 0; i < pcList.size(); i++) {
            PC selectingComputer = pcList.get(i);
            if (selectingComputer.getName().equals(name)) {
                this.selectedComputer = pcList.get(i);
                break;
            }
        }
    }

    //EFFECTS: opens additional information for the selected PC
    //allows for parts to be added, costs to be examined, names to be changed.

    //MODIFIES: this
    //EFFECTS: is given a name and adds a PC to pcList with given name
    //if a PC with the name already exists, return false;
    public boolean addPC(PC pc) {
        for (int i = 0; i < pcList.size(); i++) {
            PC computerLookingAt = pcList.get(i);
            if (computerLookingAt.getName().equals(pc.getName())) {
                return false;
            }
        }

        pcList.add(pc);
        return true;
    }

    //MODIFIES: this
    //EFFECTS: give String name, removes PC from pcList with string name
    //return false if no such PC exists
    public boolean removePC(String name) {
        for (int i = 0; i < pcList.size(); i++) {
            PC computerLookingAt = pcList.get(i);
            if (computerLookingAt.getName().equals(name)) {
                pcList.remove(i);
                return true;
            }
        }
        return false;
    }

    //MODIFIES: this
    //EFFECTS: copies selected PC and adds to to pcList
    public boolean copyPC() {
        if (!pcList.isEmpty() && selectedComputer != null) {
            PC copiedPC;
            String copiedName = selectedComputer.getName();
            copiedName = copiedName.concat("copy");
            copiedPC = new PC(copiedName);
            pcList.add(copiedPC);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("pcList", pcListToJson());
        return json;
    }
    
    // EFFECTS: returns PC in this PCList as a JSON array
    private JSONArray pcListToJson() {
        JSONArray jsonArray = new JSONArray();

        for (PC t : pcList) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }
}
