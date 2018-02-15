package Model;

/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Attribute {

    private String nameEnglish;
    private String nameGerman;
    private String type;

    public Attribute(String nameEnglish, String nameGerman, String type) {

        this.nameEnglish = nameEnglish;
        this.nameGerman = nameGerman;
        this.type = type;
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
}
