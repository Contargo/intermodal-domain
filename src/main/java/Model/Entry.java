package Model;

import java.util.ArrayList;
import java.util.List;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Entry {

    private String nameEnglish;
    private String nameGerman;
    private String type;

    private List<Attribute> attributes = new ArrayList<Attribute>();

    public Entry(String nameEnglish, String nameGerman, String type) {

        this.nameEnglish = nameEnglish;
        this.nameGerman = nameGerman;
        this.type = type;
    }

    public void addAttribute(Attribute attribute) {

        attributes.add(attribute);
    }


    public String getNameEnglish() {

        return nameEnglish;
    }


    public String getNameGerman() {

        return nameGerman;
    }


    public String getType() {

        return type;
    }


    public List<Attribute> getAttributes() {

        return attributes;
    }
}
